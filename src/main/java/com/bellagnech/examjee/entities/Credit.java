package com.bellagnech.examjee.entities;

import com.bellagnech.examjee.enums.StatutCredit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entité représentant un crédit.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_credit")
public class Credit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate dateDemande;
    
    @Enumerated(EnumType.STRING)
    private StatutCredit statut;
    
    private LocalDate dateAcception;
    
    private Double montant;
    
    private Integer dureeRemboursement;
    
    private Double tauxInteret;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Remboursement> remboursements = new ArrayList<>();
}
