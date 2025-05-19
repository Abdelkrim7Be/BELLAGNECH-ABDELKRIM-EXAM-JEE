package com.bellagnech.examjee.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO pour l'entité CreditPersonnel.
 * Étend CreditDTO et ajoute les propriétés spécifiques au crédit personnel.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnelDTO extends CreditDTO {
    
    private String motif;
    
    // Constructeur qui initialise le type de crédit
    public CreditPersonnelDTO(CreditDTO creditDTO, String motif) {
        super(
            creditDTO.getId(),
            creditDTO.getDateDemande(),
            creditDTO.getStatut(),
            creditDTO.getDateAcception(),
            creditDTO.getMontant(),
            creditDTO.getDureeRemboursement(),
            creditDTO.getTauxInteret(),
            creditDTO.getClientId(),
            creditDTO.getRemboursementIds(),
            "PERSONNEL"
        );
        this.motif = motif;
    }
}
