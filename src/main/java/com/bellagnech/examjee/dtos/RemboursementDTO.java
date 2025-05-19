package com.bellagnech.examjee.dtos;

import com.bellagnech.examjee.enums.TypeRemboursement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * DTO pour l'entité Remboursement.
 * Ne contient pas les relations inverses pour éviter les cycles JSON.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemboursementDTO {
    
    private Long id;
    
    private LocalDate date;
    
    private Double montant;
    
    private TypeRemboursement type;
    
    // ID du crédit associé (pour éviter les cycles)
    private Long creditId;
}
