package com.bellagnech.examjee.mappers;

import com.bellagnech.examjee.dtos.CreditDTO;
import com.bellagnech.examjee.dtos.CreditProfessionnelDTO;
import com.bellagnech.examjee.entities.CreditProfessionnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper pour convertir entre l'entité CreditProfessionnel et son DTO.
 */
@Component
public class CreditProfessionnelMapper {
    
    private final CreditMapper creditMapper;
    
    @Autowired
    public CreditProfessionnelMapper(CreditMapper creditMapper) {
        this.creditMapper = creditMapper;
    }
    
    /**
     * Convertit une entité CreditProfessionnel en DTO.
     *
     * @param creditProfessionnel L'entité à convertir
     * @return Le DTO correspondant
     */
    public CreditProfessionnelDTO toDTO(CreditProfessionnel creditProfessionnel) {
        if (creditProfessionnel == null) {
            return null;
        }
        
        // Convertir d'abord en CreditDTO
        CreditDTO creditDTO = creditMapper.toDTO(creditProfessionnel);
        
        // Puis créer un CreditProfessionnelDTO avec les propriétés spécifiques
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO(
            creditDTO, 
            creditProfessionnel.getMotif(),
            creditProfessionnel.getRaisonSociale()
        );
        dto.setTypeCredit("PROFESSIONNEL");
        
        return dto;
    }
    
    /**
     * Convertit un DTO CreditProfessionnel en entité.
     *
     * @param dto Le DTO à convertir
     * @return L'entité correspondante
     */
    public CreditProfessionnel fromDTO(CreditProfessionnelDTO dto) {
        if (dto == null) {
            return null;
        }
        
        // Créer d'abord un Credit à partir du DTO
        CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
        
        // Copier les propriétés de base
        creditProfessionnel.setId(dto.getId());
        creditProfessionnel.setDateDemande(dto.getDateDemande());
        creditProfessionnel.setStatut(dto.getStatut());
        creditProfessionnel.setDateAcception(dto.getDateAcception());
        creditProfessionnel.setMontant(dto.getMontant());
        creditProfessionnel.setDureeRemboursement(dto.getDureeRemboursement());
        creditProfessionnel.setTauxInteret(dto.getTauxInteret());
        
        // Définir le client (juste la référence)
        if (dto.getClientId() != null) {
            creditProfessionnel.setClient(new com.bellagnech.examjee.entities.Client());
            creditProfessionnel.getClient().setId(dto.getClientId());
        }
        
        // Ajouter les propriétés spécifiques
        creditProfessionnel.setMotif(dto.getMotif());
        creditProfessionnel.setRaisonSociale(dto.getRaisonSociale());
        
        return creditProfessionnel;
    }
}
