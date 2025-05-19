package com.bellagnech.examjee.mappers;

import com.bellagnech.examjee.dtos.CreditDTO;
import com.bellagnech.examjee.dtos.CreditImmobilierDTO;
import com.bellagnech.examjee.entities.CreditImmobilier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper pour convertir entre l'entité CreditImmobilier et son DTO.
 */
@Component
public class CreditImmobilierMapper {
    
    private final CreditMapper creditMapper;
    
    @Autowired
    public CreditImmobilierMapper(CreditMapper creditMapper) {
        this.creditMapper = creditMapper;
    }
    
    /**
     * Convertit une entité CreditImmobilier en DTO.
     *
     * @param creditImmobilier L'entité à convertir
     * @return Le DTO correspondant
     */
    public CreditImmobilierDTO toDTO(CreditImmobilier creditImmobilier) {
        if (creditImmobilier == null) {
            return null;
        }
        
        // Convertir d'abord en CreditDTO
        CreditDTO creditDTO = creditMapper.toDTO(creditImmobilier);
        
        // Puis créer un CreditImmobilierDTO avec les propriétés spécifiques
        CreditImmobilierDTO dto = new CreditImmobilierDTO(creditDTO, creditImmobilier.getTypeBien());
        dto.setTypeCredit("IMMOBILIER");
        
        return dto;
    }
    
    /**
     * Convertit un DTO CreditImmobilier en entité.
     *
     * @param dto Le DTO à convertir
     * @return L'entité correspondante
     */
    public CreditImmobilier fromDTO(CreditImmobilierDTO dto) {
        if (dto == null) {
            return null;
        }
        
        // Créer d'abord un Credit à partir du DTO
        CreditImmobilier creditImmobilier = new CreditImmobilier();
        
        // Copier les propriétés de base
        creditImmobilier.setId(dto.getId());
        creditImmobilier.setDateDemande(dto.getDateDemande());
        creditImmobilier.setStatut(dto.getStatut());
        creditImmobilier.setDateAcception(dto.getDateAcception());
        creditImmobilier.setMontant(dto.getMontant());
        creditImmobilier.setDureeRemboursement(dto.getDureeRemboursement());
        creditImmobilier.setTauxInteret(dto.getTauxInteret());
        
        // Définir le client (juste la référence)
        if (dto.getClientId() != null) {
            creditImmobilier.setClient(new com.bellagnech.examjee.entities.Client());
            creditImmobilier.getClient().setId(dto.getClientId());
        }
        
        // Ajouter les propriétés spécifiques
        creditImmobilier.setTypeBien(dto.getTypeBien());
        
        return creditImmobilier;
    }
}
