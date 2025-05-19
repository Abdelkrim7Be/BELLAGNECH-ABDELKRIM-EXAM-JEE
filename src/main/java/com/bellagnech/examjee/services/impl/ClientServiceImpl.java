package com.bellagnech.examjee.services.impl;

import com.bellagnech.examjee.dtos.ClientDTO;
import com.bellagnech.examjee.dtos.CreditDTO;
import com.bellagnech.examjee.entities.Client;
import com.bellagnech.examjee.mappers.ClientMapper;
import com.bellagnech.examjee.mappers.CreditMapper;
import com.bellagnech.examjee.repositories.ClientRepository;
import com.bellagnech.examjee.repositories.CreditRepository;
import com.bellagnech.examjee.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implémentation du service pour gérer les opérations liées aux clients.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    
    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final ClientMapper clientMapper;
    private final CreditMapper creditMapper;
    
    @Autowired
    public ClientServiceImpl(
            ClientRepository clientRepository,
            CreditRepository creditRepository,
            ClientMapper clientMapper,
            CreditMapper creditMapper) {
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
        this.clientMapper = clientMapper;
        this.creditMapper = creditMapper;
    }
    
    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<ClientDTO> getClientById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDTO);
    }
    
    @Override
    public Optional<ClientDTO> getClientByEmail(String email) {
        return clientRepository.findByEmail(email)
                .map(clientMapper::toDTO);
    }
    
    @Override
    public List<ClientDTO> searchClientsByName(String nom) {
        return clientRepository.findByNomContainingIgnoreCase(nom).stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDTO(savedClient);
    }
    
    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        // Vérifier si le client existe
        Optional<Client> existingClientOpt = clientRepository.findById(id);
        if (existingClientOpt.isPresent()) {
            Client existingClient = existingClientOpt.get();
            
            // Mettre à jour les propriétés du client
            existingClient.setNom(clientDTO.getNom());
            existingClient.setEmail(clientDTO.getEmail());
            
            // Sauvegarder les modifications
            Client updatedClient = clientRepository.save(existingClient);
            return clientMapper.toDTO(updatedClient);
        } else {
            throw new RuntimeException("Client non trouvé avec l'ID: " + id);
        }
    }
    
    @Override
    public void deleteClient(Long id) {
        // Vérifier si le client existe
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Client non trouvé avec l'ID: " + id);
        }
    }
    
    @Override
    public List<CreditDTO> getClientCredits(Long clientId) {
        // Vérifier si le client existe
        if (clientRepository.existsById(clientId)) {
            return creditRepository.findByClientId(clientId).stream()
                    .map(creditMapper::toDTO)
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Client non trouvé avec l'ID: " + clientId);
        }
    }
}
