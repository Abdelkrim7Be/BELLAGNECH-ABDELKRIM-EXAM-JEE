package com.bellagnech.examjee.services.impl;

import com.bellagnech.examjee.dtos.CreditDTO;
import com.bellagnech.examjee.dtos.CreditImmobilierDTO;
import com.bellagnech.examjee.dtos.CreditPersonnelDTO;
import com.bellagnech.examjee.dtos.CreditProfessionnelDTO;
import com.bellagnech.examjee.dtos.RemboursementDTO;
import com.bellagnech.examjee.entities.Credit;
import com.bellagnech.examjee.entities.CreditImmobilier;
import com.bellagnech.examjee.entities.CreditPersonnel;
import com.bellagnech.examjee.entities.CreditProfessionnel;
import com.bellagnech.examjee.enums.StatutCredit;
import com.bellagnech.examjee.enums.TypeBien;
import com.bellagnech.examjee.mappers.CreditImmobilierMapper;
import com.bellagnech.examjee.mappers.CreditMapper;
import com.bellagnech.examjee.mappers.CreditPersonnelMapper;
import com.bellagnech.examjee.mappers.CreditProfessionnelMapper;
import com.bellagnech.examjee.mappers.RemboursementMapper;
import com.bellagnech.examjee.repositories.CreditImmobilierRepository;
import com.bellagnech.examjee.repositories.CreditPersonnelRepository;
import com.bellagnech.examjee.repositories.CreditProfessionnelRepository;
import com.bellagnech.examjee.repositories.CreditRepository;
import com.bellagnech.examjee.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implémentation du service pour gérer les opérations liées aux crédits.
 */
@Service
@Transactional
public class CreditServiceImpl implements CreditService {
    
    private final CreditRepository creditRepository;
    private final CreditPersonnelRepository creditPersonnelRepository;
    private final CreditImmobilierRepository creditImmobilierRepository;
    private final CreditProfessionnelRepository creditProfessionnelRepository;
    
    private final CreditMapper creditMapper;
    private final CreditPersonnelMapper creditPersonnelMapper;
    private final CreditImmobilierMapper creditImmobilierMapper;
    private final CreditProfessionnelMapper creditProfessionnelMapper;
    private final RemboursementMapper remboursementMapper;
    
    @Autowired
    public CreditServiceImpl(
            CreditRepository creditRepository,
            CreditPersonnelRepository creditPersonnelRepository,
            CreditImmobilierRepository creditImmobilierRepository,
            CreditProfessionnelRepository creditProfessionnelRepository,
            CreditMapper creditMapper,
            CreditPersonnelMapper creditPersonnelMapper,
            CreditImmobilierMapper creditImmobilierMapper,
            CreditProfessionnelMapper creditProfessionnelMapper,
            RemboursementMapper remboursementMapper) {
        this.creditRepository = creditRepository;
        this.creditPersonnelRepository = creditPersonnelRepository;
        this.creditImmobilierRepository = creditImmobilierRepository;
        this.creditProfessionnelRepository = creditProfessionnelRepository;
        this.creditMapper = creditMapper;
        this.creditPersonnelMapper = creditPersonnelMapper;
        this.creditImmobilierMapper = creditImmobilierMapper;
        this.creditProfessionnelMapper = creditProfessionnelMapper;
        this.remboursementMapper = remboursementMapper;
    }
    
    @Override
    public List<CreditDTO> getAllCredits() {
        return creditRepository.findAll().stream()
                .map(creditMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<CreditDTO> getCreditById(Long id) {
        return creditRepository.findById(id)
                .map(creditMapper::toDTO);
    }
    
    @Override
    public List<CreditDTO> getCreditsByClientId(Long clientId) {
        return creditRepository.findByClientId(clientId).stream()
                .map(creditMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<CreditDTO> getCreditsByStatut(StatutCredit statut) {
        return creditRepository.findByStatut(statut).stream()
                .map(creditMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public CreditDTO createCredit(CreditDTO creditDTO) {
        Credit credit = creditMapper.fromDTO(creditDTO);
        Credit savedCredit = creditRepository.save(credit);
        return creditMapper.toDTO(savedCredit);
    }
    
    @Override
    public CreditPersonnelDTO createCreditPersonnel(CreditPersonnelDTO creditPersonnelDTO) {
        CreditPersonnel creditPersonnel = creditPersonnelMapper.fromDTO(creditPersonnelDTO);
        CreditPersonnel savedCreditPersonnel = creditPersonnelRepository.save(creditPersonnel);
        return creditPersonnelMapper.toDTO(savedCreditPersonnel);
    }
    
    @Override
    public CreditImmobilierDTO createCreditImmobilier(CreditImmobilierDTO creditImmobilierDTO) {
        CreditImmobilier creditImmobilier = creditImmobilierMapper.fromDTO(creditImmobilierDTO);
        CreditImmobilier savedCreditImmobilier = creditImmobilierRepository.save(creditImmobilier);
        return creditImmobilierMapper.toDTO(savedCreditImmobilier);
    }
    
    @Override
    public CreditProfessionnelDTO createCreditProfessionnel(CreditProfessionnelDTO creditProfessionnelDTO) {
        CreditProfessionnel creditProfessionnel = creditProfessionnelMapper.fromDTO(creditProfessionnelDTO);
        CreditProfessionnel savedCreditProfessionnel = creditProfessionnelRepository.save(creditProfessionnel);
        return creditProfessionnelMapper.toDTO(savedCreditProfessionnel);
    }
    
    @Override
    public CreditDTO updateCredit(Long id, CreditDTO creditDTO) {
        // Vérifier si le crédit existe
        Optional<Credit> existingCreditOpt = creditRepository.findById(id);
        if (existingCreditOpt.isPresent()) {
            Credit existingCredit = existingCreditOpt.get();
            
            // Mettre à jour les propriétés du crédit
            existingCredit.setDateDemande(creditDTO.getDateDemande());
            existingCredit.setStatut(creditDTO.getStatut());
            existingCredit.setDateAcception(creditDTO.getDateAcception());
            existingCredit.setMontant(creditDTO.getMontant());
            existingCredit.setDureeRemboursement(creditDTO.getDureeRemboursement());
            existingCredit.setTauxInteret(creditDTO.getTauxInteret());
            
            // Sauvegarder les modifications
            Credit updatedCredit = creditRepository.save(existingCredit);
            return creditMapper.toDTO(updatedCredit);
        } else {
            throw new RuntimeException("Crédit non trouvé avec l'ID: " + id);
        }
    }
    
    @Override
    public void deleteCredit(Long id) {
        // Vérifier si le crédit existe
        if (creditRepository.existsById(id)) {
            creditRepository.deleteById(id);
        } else {
            throw new RuntimeException("Crédit non trouvé avec l'ID: " + id);
        }
    }
    
    @Override
    public List<RemboursementDTO> getCreditRemboursements(Long creditId) {
        // Vérifier si le crédit existe
        Optional<Credit> creditOpt = creditRepository.findById(creditId);
        if (creditOpt.isPresent()) {
            Credit credit = creditOpt.get();
            return credit.getRemboursements().stream()
                    .map(remboursementMapper::toDTO)
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Crédit non trouvé avec l'ID: " + creditId);
        }
    }
    
    @Override
    public Double calculateTotalCreditAmountByClientId(Long clientId) {
        return creditRepository.calculateTotalCreditAmountByClientId(clientId);
    }
    
    @Override
    public List<CreditPersonnelDTO> getAllCreditsPersonnels() {
        return creditPersonnelRepository.findAll().stream()
                .map(creditPersonnelMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<CreditImmobilierDTO> getAllCreditsImmobiliers() {
        return creditImmobilierRepository.findAll().stream()
                .map(creditImmobilierMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<CreditProfessionnelDTO> getAllCreditsProfessionnels() {
        return creditProfessionnelRepository.findAll().stream()
                .map(creditProfessionnelMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<CreditPersonnelDTO> searchCreditsPersonnelsByMotif(String motif) {
        return creditPersonnelRepository.findByMotifContainingIgnoreCase(motif).stream()
                .map(creditPersonnelMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<CreditImmobilierDTO> searchCreditsImmobiliersByTypeBien(TypeBien typeBien) {
        return creditImmobilierRepository.findByTypeBien(typeBien).stream()
                .map(creditImmobilierMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<CreditProfessionnelDTO> searchCreditsProfessionnelsByRaisonSociale(String raisonSociale) {
        return creditProfessionnelRepository.findByRaisonSocialeContainingIgnoreCase(raisonSociale).stream()
                .map(creditProfessionnelMapper::toDTO)
                .collect(Collectors.toList());
    }
}
