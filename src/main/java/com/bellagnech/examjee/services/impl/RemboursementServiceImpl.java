package com.bellagnech.examjee.services.impl;

import com.bellagnech.examjee.dtos.RemboursementDTO;
import com.bellagnech.examjee.entities.Credit;
import com.bellagnech.examjee.entities.Remboursement;
import com.bellagnech.examjee.enums.TypeRemboursement;
import com.bellagnech.examjee.mappers.RemboursementMapper;
import com.bellagnech.examjee.repositories.CreditRepository;
import com.bellagnech.examjee.repositories.RemboursementRepository;
import com.bellagnech.examjee.services.RemboursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implémentation du service pour gérer les opérations liées aux remboursements.
 */
@Service
@Transactional
public class RemboursementServiceImpl implements RemboursementService {
    
    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final RemboursementMapper remboursementMapper;
    
    @Autowired
    public RemboursementServiceImpl(
            RemboursementRepository remboursementRepository,
            CreditRepository creditRepository,
            RemboursementMapper remboursementMapper) {
        this.remboursementRepository = remboursementRepository;
        this.creditRepository = creditRepository;
        this.remboursementMapper = remboursementMapper;
    }
    
    @Override
    public List<RemboursementDTO> getAllRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(remboursementMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<RemboursementDTO> getRemboursementById(Long id) {
        return remboursementRepository.findById(id)
                .map(remboursementMapper::toDTO);
    }
    
    @Override
    public List<RemboursementDTO> getRemboursementsByCreditId(Long creditId) {
        return remboursementRepository.findByCreditId(creditId).stream()
                .map(remboursementMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<RemboursementDTO> getRemboursementsByType(TypeRemboursement type) {
        return remboursementRepository.findByType(type).stream()
                .map(remboursementMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<RemboursementDTO> getRemboursementsAfterDate(LocalDate date) {
        return remboursementRepository.findByDateAfter(date).stream()
                .map(remboursementMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public RemboursementDTO createRemboursement(RemboursementDTO remboursementDTO) {
        // Vérifier si le crédit existe
        if (remboursementDTO.getCreditId() != null) {
            Optional<Credit> creditOpt = creditRepository.findById(remboursementDTO.getCreditId());
            if (creditOpt.isEmpty()) {
                throw new RuntimeException("Crédit non trouvé avec l'ID: " + remboursementDTO.getCreditId());
            }
        }
        
        Remboursement remboursement = remboursementMapper.fromDTO(remboursementDTO);
        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.toDTO(savedRemboursement);
    }
    
    @Override
    public RemboursementDTO updateRemboursement(Long id, RemboursementDTO remboursementDTO) {
        // Vérifier si le remboursement existe
        Optional<Remboursement> existingRemboursementOpt = remboursementRepository.findById(id);
        if (existingRemboursementOpt.isPresent()) {
            Remboursement existingRemboursement = existingRemboursementOpt.get();
            
            // Mettre à jour les propriétés du remboursement
            existingRemboursement.setDate(remboursementDTO.getDate());
            existingRemboursement.setMontant(remboursementDTO.getMontant());
            existingRemboursement.setType(remboursementDTO.getType());
            
            // Mettre à jour le crédit si nécessaire
            if (remboursementDTO.getCreditId() != null &&
                    (existingRemboursement.getCredit() == null || 
                     !existingRemboursement.getCredit().getId().equals(remboursementDTO.getCreditId()))) {
                
                Optional<Credit> creditOpt = creditRepository.findById(remboursementDTO.getCreditId());
                if (creditOpt.isPresent()) {
                    existingRemboursement.setCredit(creditOpt.get());
                } else {
                    throw new RuntimeException("Crédit non trouvé avec l'ID: " + remboursementDTO.getCreditId());
                }
            }
            
            // Sauvegarder les modifications
            Remboursement updatedRemboursement = remboursementRepository.save(existingRemboursement);
            return remboursementMapper.toDTO(updatedRemboursement);
        } else {
            throw new RuntimeException("Remboursement non trouvé avec l'ID: " + id);
        }
    }
    
    @Override
    public void deleteRemboursement(Long id) {
        // Vérifier si le remboursement existe
        if (remboursementRepository.existsById(id)) {
            remboursementRepository.deleteById(id);
        } else {
            throw new RuntimeException("Remboursement non trouvé avec l'ID: " + id);
        }
    }
    
    @Override
    public Double calculateTotalRemboursementAmountByCreditId(Long creditId) {
        return remboursementRepository.calculateTotalRemboursementAmountByCreditId(creditId);
    }
    
    @Override
    public long countRemboursementsByType(TypeRemboursement type) {
        return remboursementRepository.countByType(type);
    }
}
