package com.bellagnech.examjee.entities;

import com.bellagnech.examjee.enums.TypeBien;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entité représentant un crédit immobilier.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {
    
    @Enumerated(EnumType.STRING)
    private TypeBien typeBien;
}
