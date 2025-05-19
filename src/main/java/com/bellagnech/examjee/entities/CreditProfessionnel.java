package com.bellagnech.examjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entité représentant un crédit professionnel.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PROFESSIONNEL")
public class CreditProfessionnel extends Credit {
    
    private String motif;
    
    private String raisonSociale;
}
