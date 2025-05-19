package com.bellagnech.examjee.mappers;

import com.bellagnech.examjee.dtos.CreditDTO;
import com.bellagnech.examjee.entities.Client;
import com.bellagnech.examjee.entities.Credit;
import com.bellagnech.examjee.entities.Remboursement;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Mapper pour convertir entre l'entité Credit et son DTO.
 */
@Component
public class CreditMapper {
    
    /**
     * Convertit une entité Credit en DTO.
     *
     * @param credit L'entité à convertir
     * @return Le DTO correspondant
     */
    public CreditDTO toDTO(Credit credit) {
        if (credit == null) {
            return null;
        }
        
        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcception(credit.getDateAcception());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());
        
        // Définir l'ID du client
        if (credit.getClient() != null) {
            dto.setClientId(credit.getClient().getId());
        }
        
        // Convertir la liste des remboursements en liste d'IDs
        if (credit.getRemboursements() != null) {
            dto.setRemboursementIds(credit.getRemboursements().stream()
                .map(Remboursement::getId)
                .collect(Collectors.toList()));
        }
        
        return dto;
    }
    
    /**
     * Convertit un DTO Credit en entité.
     *
     * @param dto Le DTO à convertir
     * @return L'entité correspondante
     */
    public Credit fromDTO(CreditDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Credit credit = new Credit();
        credit.setId(dto.getId());
        credit.setDateDemande(dto.getDateDemande());
        credit.setStatut(dto.getStatut());
        credit.setDateAcception(dto.getDateAcception());
        credit.setMontant(dto.getMontant());
        credit.setDureeRemboursement(dto.getDureeRemboursement());
        credit.setTauxInteret(dto.getTauxInteret());
        
        // Définir le client (juste la référence)
        if (dto.getClientId() != null) {
            Client client = new Client();
            client.setId(dto.getClientId());
            credit.setClient(client);
        }
        
        // Les remboursements seront gérés par le service
        
        return credit;
    }
}
