package com.bellagnech.examjee.entities;

import com.bellagnech.examjee.enums.TypeRemboursement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entité représentant un remboursement.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Remboursement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate date;
    
    private Double montant;
    
    @Enumerated(EnumType.STRING)
    private TypeRemboursement type;
    
    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
}
