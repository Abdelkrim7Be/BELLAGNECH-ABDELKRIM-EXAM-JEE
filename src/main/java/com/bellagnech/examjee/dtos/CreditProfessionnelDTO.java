package com.bellagnech.examjee.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO pour l'entité CreditProfessionnel.
 * Étend CreditDTO et ajoute les propriétés spécifiques au crédit professionnel.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditProfessionnelDTO extends CreditDTO {
    
    private String motif;
    
    private String raisonSociale;
    
    // Constructeur qui initialise le type de crédit
    public CreditProfessionnelDTO(CreditDTO creditDTO, String motif, String raisonSociale) {
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
            "PROFESSIONNEL"
        );
        this.motif = motif;
        this.raisonSociale = raisonSociale;
    }
}
