package com.bellagnech.examjee.dtos;

import com.bellagnech.examjee.enums.StatutCredit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO pour l'entité Credit.
 * Ne contient pas les relations inverses pour éviter les cycles JSON.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditDTO {
    
    private Long id;
    
    private LocalDate dateDemande;
    
    private StatutCredit statut;
    
    private LocalDate dateAcception;
    
    private Double montant;
    
    private Integer dureeRemboursement;
    
    private Double tauxInteret;
    
    // ID du client associé (pour éviter les cycles)
    private Long clientId;
    
    // Liste des IDs des remboursements associés au crédit (pour éviter les cycles)
    private List<Long> remboursementIds = new ArrayList<>();
    
    // Type de crédit pour la sérialisation/désérialisation
    private String typeCredit;
}
