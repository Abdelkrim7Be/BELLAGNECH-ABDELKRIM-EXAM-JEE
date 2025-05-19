package com.bellagnech.examjee.dtos;

import com.bellagnech.examjee.enums.TypeBien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO pour l'entité CreditImmobilier.
 * Étend CreditDTO et ajoute les propriétés spécifiques au crédit immobilier.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilierDTO extends CreditDTO {
    
    private TypeBien typeBien;
    
    // Constructeur qui initialise le type de crédit
    public CreditImmobilierDTO(CreditDTO creditDTO, TypeBien typeBien) {
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
            "IMMOBILIER"
        );
        this.typeBien = typeBien;
    }
}
