package com.bellagnech.examjee.mappers;

import com.bellagnech.examjee.dtos.RemboursementDTO;
import com.bellagnech.examjee.entities.Credit;
import com.bellagnech.examjee.entities.Remboursement;
import org.springframework.stereotype.Component;

/**
 * Mapper pour convertir entre l'entité Remboursement et son DTO.
 */
@Component
public class RemboursementMapper {
    
    /**
     * Convertit une entité Remboursement en DTO.
     *
     * @param remboursement L'entité à convertir
     * @return Le DTO correspondant
     */
    public RemboursementDTO toDTO(Remboursement remboursement) {
        if (remboursement == null) {
            return null;
        }
        
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(remboursement.getDate());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType());
        
        // Définir l'ID du crédit
        if (remboursement.getCredit() != null) {
            dto.setCreditId(remboursement.getCredit().getId());
        }
        
        return dto;
    }
    
    /**
     * Convertit un DTO Remboursement en entité.
     *
     * @param dto Le DTO à convertir
     * @return L'entité correspondante
     */
    public Remboursement fromDTO(RemboursementDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(dto.getDate());
        remboursement.setMontant(dto.getMontant());
        remboursement.setType(dto.getType());
        
        // Définir le crédit (juste la référence)
        if (dto.getCreditId() != null) {
            Credit credit = new Credit();
            credit.setId(dto.getCreditId());
            remboursement.setCredit(credit);
        }
        
        return remboursement;
    }
}
