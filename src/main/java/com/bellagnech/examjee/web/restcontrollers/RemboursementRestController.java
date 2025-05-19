package com.bellagnech.examjee.web.restcontrollers;

import com.bellagnech.examjee.dtos.RemboursementDTO;
import com.bellagnech.examjee.enums.TypeRemboursement;
import com.bellagnech.examjee.services.RemboursementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations liées aux remboursements.
 */
@RestController
@RequestMapping("/api/remboursements")
@Tag(name = "Remboursement", description = "API pour gérer les remboursements")
public class RemboursementRestController {
    
    private final RemboursementService remboursementService;
    
    @Autowired
    public RemboursementRestController(RemboursementService remboursementService) {
        this.remboursementService = remboursementService;
    }
    
    /**
     * Récupère tous les remboursements.
     *
     * @return Une liste de tous les remboursements
     */
    @GetMapping
    @Operation(summary = "Récupérer tous les remboursements", description = "Retourne une liste de tous les remboursements")
    public ResponseEntity<List<RemboursementDTO>> getAllRemboursements() {
        return ResponseEntity.ok(remboursementService.getAllRemboursements());
    }
    
    /**
     * Récupère un remboursement par son ID.
     *
     * @param id L'ID du remboursement à récupérer
     * @return Le remboursement s'il existe, sinon 404
     */
    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un remboursement par ID", description = "Retourne un remboursement spécifique par son ID")
    public ResponseEntity<RemboursementDTO> getRemboursementById(@PathVariable Long id) {
        return remboursementService.getRemboursementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Ajoute un nouveau remboursement à un crédit.
     *
     * @param remboursementDTO Les données du remboursement à créer
     * @return Le remboursement créé
     */
    @PostMapping
    @Operation(summary = "Ajouter un remboursement", description = "Crée un nouveau remboursement pour un crédit")
    public ResponseEntity<RemboursementDTO> addRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        try {
            RemboursementDTO createdRemboursement = remboursementService.createRemboursement(remboursementDTO);
            return new ResponseEntity<>(createdRemboursement, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Met à jour un remboursement existant.
     *
     * @param id L'ID du remboursement à mettre à jour
     * @param remboursementDTO Les nouvelles données du remboursement
     * @return Le remboursement mis à jour
     */
    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un remboursement", description = "Met à jour un remboursement existant")
    public ResponseEntity<RemboursementDTO> updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDTO remboursementDTO) {
        try {
            RemboursementDTO updatedRemboursement = remboursementService.updateRemboursement(id, remboursementDTO);
            return ResponseEntity.ok(updatedRemboursement);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Supprime un remboursement.
     *
     * @param id L'ID du remboursement à supprimer
     * @return 204 si supprimé, 404 si non trouvé
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un remboursement", description = "Supprime un remboursement existant")
    public ResponseEntity<Void> deleteRemboursement(@PathVariable Long id) {
        try {
            remboursementService.deleteRemboursement(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Récupère tous les remboursements d'un crédit.
     *
     * @param creditId L'ID du crédit
     * @return Une liste des remboursements du crédit
     */
    @GetMapping("/credit/{creditId}")
    @Operation(summary = "Récupérer les remboursements d'un crédit", description = "Retourne tous les remboursements associés à un crédit")
    public ResponseEntity<List<RemboursementDTO>> getRemboursementsByCreditId(@PathVariable Long creditId) {
        List<RemboursementDTO> remboursements = remboursementService.getRemboursementsByCreditId(creditId);
        return ResponseEntity.ok(remboursements);
    }
    
    /**
     * Récupère tous les remboursements par type.
     *
     * @param type Le type de remboursement
     * @return Une liste des remboursements du type spécifié
     */
    @GetMapping("/type/{type}")
    @Operation(summary = "Récupérer les remboursements par type", description = "Retourne tous les remboursements d'un type spécifique")
    public ResponseEntity<List<RemboursementDTO>> getRemboursementsByType(@PathVariable TypeRemboursement type) {
        List<RemboursementDTO> remboursements = remboursementService.getRemboursementsByType(type);
        return ResponseEntity.ok(remboursements);
    }
    
    /**
     * Récupère tous les remboursements effectués après une date donnée.
     *
     * @param date La date de référence
     * @return Une liste des remboursements effectués après la date spécifiée
     */
    @GetMapping("/after")
    @Operation(summary = "Récupérer les remboursements après une date", description = "Retourne tous les remboursements effectués après la date spécifiée")
    public ResponseEntity<List<RemboursementDTO>> getRemboursementsAfterDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<RemboursementDTO> remboursements = remboursementService.getRemboursementsAfterDate(date);
        return ResponseEntity.ok(remboursements);
    }
    
    /**
     * Calcule le montant total des remboursements pour un crédit.
     *
     * @param creditId L'ID du crédit
     * @return Le montant total des remboursements
     */
    @GetMapping("/credit/{creditId}/total")
    @Operation(summary = "Calculer le montant total des remboursements", description = "Retourne le montant total des remboursements pour un crédit")
    public ResponseEntity<Double> calculateTotalRemboursementAmount(@PathVariable Long creditId) {
        Double totalAmount = remboursementService.calculateTotalRemboursementAmountByCreditId(creditId);
        return ResponseEntity.ok(totalAmount != null ? totalAmount : 0.0);
    }
}
