package com.bellagnech.examjee.web.restcontrollers;

import com.bellagnech.examjee.dtos.ClientDTO;
import com.bellagnech.examjee.dtos.CreditDTO;
import com.bellagnech.examjee.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations liées aux clients.
 */
@RestController
@RequestMapping("/api/clients")
@Tag(name = "Client", description = "API pour gérer les clients")
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Récupère tous les clients.
     *
     * @return Une liste de tous les clients
     */
    @GetMapping
    @Operation(summary = "Récupérer tous les clients", description = "Retourne une liste de tous les clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    /**
     * Récupère un client par son ID.
     *
     * @param id L'ID du client à récupérer
     * @return Le client s'il existe, sinon 404
     */
    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un client par ID", description = "Retourne un client spécifique par son ID")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Ajoute un nouveau client.
     *
     * @param clientDTO Les données du client à créer
     * @return Le client créé
     */
    @PostMapping
    @Operation(summary = "Ajouter un client", description = "Crée un nouveau client")
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        try {
            ClientDTO createdClient = clientService.createClient(clientDTO);
            return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Met à jour un client existant.
     *
     * @param id L'ID du client à mettre à jour
     * @param clientDTO Les nouvelles données du client
     * @return Le client mis à jour
     */
    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un client", description = "Met à jour un client existant")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        try {
            ClientDTO updatedClient = clientService.updateClient(id, clientDTO);
            return ResponseEntity.ok(updatedClient);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Supprime un client.
     *
     * @param id L'ID du client à supprimer
     * @return 204 si supprimé, 404 si non trouvé
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un client", description = "Supprime un client existant")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Récupère tous les crédits d'un client.
     *
     * @param clientId L'ID du client
     * @return Une liste des crédits du client
     */
    @GetMapping("/{clientId}/credits")
    @Operation(summary = "Récupérer les crédits d'un client", description = "Retourne tous les crédits associés à un client")
    public ResponseEntity<List<CreditDTO>> getClientCredits(@PathVariable Long clientId) {
        try {
            List<CreditDTO> credits = clientService.getClientCredits(clientId);
            return ResponseEntity.ok(credits);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Recherche des clients par nom.
     *
     * @param nom Le nom à rechercher
     * @return Une liste de clients correspondant au critère
     */
    @GetMapping("/search")
    @Operation(summary = "Rechercher des clients par nom", description = "Retourne les clients dont le nom contient la chaîne spécifiée")
    public ResponseEntity<List<ClientDTO>> searchClientsByName(@RequestParam String nom) {
        List<ClientDTO> clients = clientService.searchClientsByName(nom);
        return ResponseEntity.ok(clients);
    }
}
