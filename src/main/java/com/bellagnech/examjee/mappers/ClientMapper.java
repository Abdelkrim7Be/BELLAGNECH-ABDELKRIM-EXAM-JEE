package com.bellagnech.examjee.mappers;

import com.bellagnech.examjee.dtos.ClientDTO;
import com.bellagnech.examjee.entities.Client;
import com.bellagnech.examjee.entities.Credit;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Mapper pour convertir entre l'entité Client et son DTO.
 */
@Component
public class ClientMapper {
    
    /**
     * Convertit une entité Client en DTO.
     *
     * @param client L'entité à convertir
     * @return Le DTO correspondant
     */
    public ClientDTO toDTO(Client client) {
        if (client == null) {
            return null;
        }
        
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());
        
        // Convertir la liste des crédits en liste d'IDs
        if (client.getCredits() != null) {
            dto.setCreditIds(client.getCredits().stream()
                .map(Credit::getId)
                .collect(Collectors.toList()));
        }
        
        return dto;
    }
    
    /**
     * Convertit un DTO Client en entité.
     *
     * @param dto Le DTO à convertir
     * @return L'entité correspondante
     */
    public Client fromDTO(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        
        // Les relations seront gérées par le service
        
        return client;
    }
}
