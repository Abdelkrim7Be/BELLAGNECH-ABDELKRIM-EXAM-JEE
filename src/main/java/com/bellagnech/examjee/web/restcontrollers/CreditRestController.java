package com.bellagnech.examjee.web.restcontrollers;

import com.bellagnech.examjee.dtos.*;
import com.bellagnech.examjee.enums.StatutCredit;
import com.bellagnech.examjee.enums.TypeBien;
import com.bellagnech.examjee.services.CreditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations liées aux crédits.
 */
@RestController
@RequestMapping("/api/credits")
@Tag(name = "Credit", description = "API pour gérer les crédits")
public class CreditRestController {
    
    private final CreditService creditService;
    
    @Autowired
    public CreditRestController(CreditService creditService) {
        this.creditService = creditService;
    }
    
    /**
     * Récupère tous les crédits.
     *
     * @return Une liste de tous les crédits
     */
    @GetMapping
    @Operation(summary = "Récupérer tous les crédits", description = "Retourne une liste de tous les crédits")
    public ResponseEntity<List<CreditDTO>> getAllCredits() {
        return ResponseEntity.ok(creditService.getAllCredits());
    }
    
    /**
     * Récupère un crédit par son ID.
     *
     * @param id L'ID du crédit à récupérer
     * @return Le crédit s'il existe, sinon 404
     */
    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un crédit par ID", description = "Retourne un crédit spécifique par son ID")
    public ResponseEntity<CreditDTO> getCreditById(@PathVariable Long id) {
        return creditService.getCreditById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Ajoute un nouveau crédit personnel.
     *
     * @param creditDTO Les données du crédit à créer
     * @return Le crédit créé
     */
    @PostMapping("/personnel")
    @Operation(summary = "Ajouter un crédit personnel", description = "Crée un nouveau crédit personnel")
    public ResponseEntity<CreditPersonnelDTO> addCreditPersonnel(@RequestBody CreditPersonnelDTO creditDTO) {
        try {
            CreditPersonnelDTO createdCredit = creditService.createCreditPersonnel(creditDTO);
            return new ResponseEntity<>(createdCredit, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Ajoute un nouveau crédit immobilier.
     *
     * @param creditDTO Les données du crédit à créer
     * @return Le crédit créé
     */
    @PostMapping("/immobilier")
    @Operation(summary = "Ajouter un crédit immobilier", description = "Crée un nouveau crédit immobilier")
    public ResponseEntity<CreditImmobilierDTO> addCreditImmobilier(@RequestBody CreditImmobilierDTO creditDTO) {
        try {
            CreditImmobilierDTO createdCredit = creditService.createCreditImmobilier(creditDTO);
            return new ResponseEntity<>(createdCredit, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Ajoute un nouveau crédit professionnel.
     *
     * @param creditDTO Les données du crédit à créer
     * @return Le crédit créé
     */
    @PostMapping("/professionnel")
    @Operation(summary = "Ajouter un crédit professionnel", description = "Crée un nouveau crédit professionnel")
    public ResponseEntity<CreditProfessionnelDTO> addCreditProfessionnel(@RequestBody CreditProfessionnelDTO creditDTO) {
        try {
            CreditProfessionnelDTO createdCredit = creditService.createCreditProfessionnel(creditDTO);
            return new ResponseEntity<>(createdCredit, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Met à jour un crédit existant.
     *
     * @param id L'ID du crédit à mettre à jour
     * @param creditDTO Les nouvelles données du crédit
     * @return Le crédit mis à jour
     */
    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un crédit", description = "Met à jour un crédit existant")
    public ResponseEntity<CreditDTO> updateCredit(@PathVariable Long id, @RequestBody CreditDTO creditDTO) {
        try {
            CreditDTO updatedCredit = creditService.updateCredit(id, creditDTO);
            return ResponseEntity.ok(updatedCredit);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Supprime un crédit.
     *
     * @param id L'ID du crédit à supprimer
     * @return 204 si supprimé, 404 si non trouvé
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un crédit", description = "Supprime un crédit existant")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
        try {
            creditService.deleteCredit(id);
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
    @GetMapping("/{creditId}/remboursements")
    @Operation(summary = "Récupérer les remboursements d'un crédit", description = "Retourne tous les remboursements associés à un crédit")
    public ResponseEntity<List<RemboursementDTO>> getCreditRemboursements(@PathVariable Long creditId) {
        try {
            List<RemboursementDTO> remboursements = creditService.getCreditRemboursements(creditId);
            return ResponseEntity.ok(remboursements);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Récupère tous les crédits personnels.
     *
     * @return Une liste de tous les crédits personnels
     */
    @GetMapping("/personnels")
    @Operation(summary = "Récupérer tous les crédits personnels", description = "Retourne une liste de tous les crédits personnels")
    public ResponseEntity<List<CreditPersonnelDTO>> getAllCreditsPersonnels() {
        return ResponseEntity.ok(creditService.getAllCreditsPersonnels());
    }
    
    /**
     * Récupère tous les crédits immobiliers.
     *
     * @return Une liste de tous les crédits immobiliers
     */
    @GetMapping("/immobiliers")
    @Operation(summary = "Récupérer tous les crédits immobiliers", description = "Retourne une liste de tous les crédits immobiliers")
    public ResponseEntity<List<CreditImmobilierDTO>> getAllCreditsImmobiliers() {
        return ResponseEntity.ok(creditService.getAllCreditsImmobiliers());
    }
    
    /**
     * Récupère tous les crédits professionnels.
     *
     * @return Une liste de tous les crédits professionnels
     */
    @GetMapping("/professionnels")
    @Operation(summary = "Récupérer tous les crédits professionnels", description = "Retourne une liste de tous les crédits professionnels")
    public ResponseEntity<List<CreditProfessionnelDTO>> getAllCreditsProfessionnels() {
        return ResponseEntity.ok(creditService.getAllCreditsProfessionnels());
    }
    
    /**
     * Recherche des crédits personnels par motif.
     *
     * @param motif Le motif à rechercher
     * @return Une liste de crédits personnels correspondant au critère
     */
    @GetMapping("/personnels/search")
    @Operation(summary = "Rechercher des crédits personnels par motif", description = "Retourne les crédits personnels dont le motif contient la chaîne spécifiée")
    public ResponseEntity<List<CreditPersonnelDTO>> searchCreditsPersonnelsByMotif(@RequestParam String motif) {
        return ResponseEntity.ok(creditService.searchCreditsPersonnelsByMotif(motif));
    }
    
    /**
     * Recherche des crédits immobiliers par type de bien.
     *
     * @param typeBien Le type de bien à rechercher
     * @return Une liste de crédits immobiliers correspondant au critère
     */
    @GetMapping("/immobiliers/search")
    @Operation(summary = "Rechercher des crédits immobiliers par type de bien", description = "Retourne les crédits immobiliers du type de bien spécifié")
    public ResponseEntity<List<CreditImmobilierDTO>> searchCreditsImmobiliersByTypeBien(@RequestParam TypeBien typeBien) {
        return ResponseEntity.ok(creditService.searchCreditsImmobiliersByTypeBien(typeBien));
    }
}
