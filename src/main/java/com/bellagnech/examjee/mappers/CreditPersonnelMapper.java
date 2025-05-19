package com.bellagnech.examjee.mappers;

import com.bellagnech.examjee.dtos.CreditDTO;
import com.bellagnech.examjee.dtos.CreditPersonnelDTO;
import com.bellagnech.examjee.entities.CreditPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper pour convertir entre l'entité CreditPersonnel et son DTO.
 */
@Component
public class CreditPersonnelMapper {
    
    private final CreditMapper creditMapper;
    
    @Autowired
    public CreditPersonnelMapper(CreditMapper creditMapper) {
        this.creditMapper = creditMapper;
    }
    
    /**
     * Convertit une entité CreditPersonnel en DTO.
     *
     * @param creditPersonnel L'entité à convertir
     * @return Le DTO correspondant
     */
    public CreditPersonnelDTO toDTO(CreditPersonnel creditPersonnel) {
        if (creditPersonnel == null) {
            return null;
        }
        
        // Convertir d'abord en CreditDTO
        CreditDTO creditDTO = creditMapper.toDTO(creditPersonnel);
        
        // Puis créer un CreditPersonnelDTO avec les propriétés spécifiques
        CreditPersonnelDTO dto = new CreditPersonnelDTO(creditDTO, creditPersonnel.getMotif());
        dto.setTypeCredit("PERSONNEL");
        
        return dto;
    }
    
    /**
     * Convertit un DTO CreditPersonnel en entité.
     *
     * @param dto Le DTO à convertir
     * @return L'entité correspondante
     */
    public CreditPersonnel fromDTO(CreditPersonnelDTO dto) {
        if (dto == null) {
            return null;
        }
        
        // Créer d'abord un Credit à partir du DTO
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        
        // Copier les propriétés de base
        creditPersonnel.setId(dto.getId());
        creditPersonnel.setDateDemande(dto.getDateDemande());
        creditPersonnel.setStatut(dto.getStatut());
        creditPersonnel.setDateAcception(dto.getDateAcception());
        creditPersonnel.setMontant(dto.getMontant());
        creditPersonnel.setDureeRemboursement(dto.getDureeRemboursement());
        creditPersonnel.setTauxInteret(dto.getTauxInteret());
        
        // Définir le client (juste la référence)
        if (dto.getClientId() != null) {
            creditPersonnel.setClient(new com.bellagnech.examjee.entities.Client());
            creditPersonnel.getClient().setId(dto.getClientId());
        }
        
        // Ajouter les propriétés spécifiques
        creditPersonnel.setMotif(dto.getMotif());
        
        return creditPersonnel;
    }
}
