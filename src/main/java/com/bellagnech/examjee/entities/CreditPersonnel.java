package com.bellagnech.examjee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entité représentant un crédit personnel.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PERSONNEL")
public class CreditPersonnel extends Credit {
    
    private String motif;
}
