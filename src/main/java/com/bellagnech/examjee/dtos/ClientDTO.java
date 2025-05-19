package com.bellagnech.examjee.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO pour l'entité Client.
 * Ne contient pas les relations inverses pour éviter les cycles JSON.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    
    private Long id;
    
    private String nom;
    
    private String email;
    
    // Liste des IDs des crédits associés au client (pour éviter les cycles)
    private List<Long> creditIds = new ArrayList<>();
}
