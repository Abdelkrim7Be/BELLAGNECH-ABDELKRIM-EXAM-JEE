package com.bellagnech.examjee.services;

import com.bellagnech.examjee.dtos.ClientDTO;
import com.bellagnech.examjee.dtos.CreditDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service pour gérer les opérations liées aux clients.
 */
public interface ClientService {
    
    /**
     * Récupère tous les clients.
     *
     * @return Une liste de tous les clients
     */
    List<ClientDTO> getAllClients();
    
    /**
     * Récupère un client par son ID.
     *
     * @param id L'ID du client à récupérer
     * @return Un Optional contenant le client s'il existe
     */
    Optional<ClientDTO> getClientById(Long id);
    
    /**
     * Récupère un client par son email.
     *
     * @param email L'email du client à rechercher
     * @return Un Optional contenant le client s'il existe
     */
    Optional<ClientDTO> getClientByEmail(String email);
    
    /**
     * Recherche des clients dont le nom contient la chaîne spécifiée.
     *
     * @param nom La chaîne à rechercher dans le nom des clients
     * @return Une liste de clients correspondant au critère
     */
    List<ClientDTO> searchClientsByName(String nom);
    
    /**
     * Crée un nouveau client.
     *
     * @param clientDTO Les données du client à créer
     * @return Le client créé
     */
    ClientDTO createClient(ClientDTO clientDTO);
    
    /**
     * Met à jour un client existant.
     *
     * @param id L'ID du client à mettre à jour
     * @param clientDTO Les nouvelles données du client
     * @return Le client mis à jour
     */
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    
    /**
     * Supprime un client par son ID.
     *
     * @param id L'ID du client à supprimer
     */
    void deleteClient(Long id);
    
    /**
     * Récupère tous les crédits d'un client.
     *
     * @param clientId L'ID du client
     * @return Une liste des crédits du client
     */
    List<CreditDTO> getClientCredits(Long clientId);
}
