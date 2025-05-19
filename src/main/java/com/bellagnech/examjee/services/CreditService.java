package com.bellagnech.examjee.services;

import com.bellagnech.examjee.dtos.CreditDTO;
import com.bellagnech.examjee.dtos.CreditImmobilierDTO;
import com.bellagnech.examjee.dtos.CreditPersonnelDTO;
import com.bellagnech.examjee.dtos.CreditProfessionnelDTO;
import com.bellagnech.examjee.dtos.RemboursementDTO;
import com.bellagnech.examjee.enums.StatutCredit;
import com.bellagnech.examjee.enums.TypeBien;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Service pour gérer les opérations liées aux crédits.
 */
public interface CreditService {
    
    /**
     * Récupère tous les crédits.
     *
     * @return Une liste de tous les crédits
     */
    List<CreditDTO> getAllCredits();
    
    /**
     * Récupère un crédit par son ID.
     *
     * @param id L'ID du crédit à récupérer
     * @return Un Optional contenant le crédit s'il existe
     */
    Optional<CreditDTO> getCreditById(Long id);
    
    /**
     * Récupère tous les crédits d'un client.
     *
     * @param clientId L'ID du client
     * @return Une liste des crédits du client
     */
    List<CreditDTO> getCreditsByClientId(Long clientId);
    
    /**
     * Récupère tous les crédits ayant un statut spécifique.
     *
     * @param statut Le statut des crédits à rechercher
     * @return Une liste de crédits
     */
    List<CreditDTO> getCreditsByStatut(StatutCredit statut);
    
    /**
     * Crée un nouveau crédit.
     *
     * @param creditDTO Les données du crédit à créer
     * @return Le crédit créé
     */
    CreditDTO createCredit(CreditDTO creditDTO);
    
    /**
     * Crée un nouveau crédit personnel.
     *
     * @param creditPersonnelDTO Les données du crédit personnel à créer
     * @return Le crédit personnel créé
     */
    CreditPersonnelDTO createCreditPersonnel(CreditPersonnelDTO creditPersonnelDTO);
    
    /**
     * Crée un nouveau crédit immobilier.
     *
     * @param creditImmobilierDTO Les données du crédit immobilier à créer
     * @return Le crédit immobilier créé
     */
    CreditImmobilierDTO createCreditImmobilier(CreditImmobilierDTO creditImmobilierDTO);
    
    /**
     * Crée un nouveau crédit professionnel.
     *
     * @param creditProfessionnelDTO Les données du crédit professionnel à créer
     * @return Le crédit professionnel créé
     */
    CreditProfessionnelDTO createCreditProfessionnel(CreditProfessionnelDTO creditProfessionnelDTO);
    
    /**
     * Met à jour un crédit existant.
     *
     * @param id L'ID du crédit à mettre à jour
     * @param creditDTO Les nouvelles données du crédit
     * @return Le crédit mis à jour
     */
    CreditDTO updateCredit(Long id, CreditDTO creditDTO);
    
    /**
     * Supprime un crédit par son ID.
     *
     * @param id L'ID du crédit à supprimer
     */
    void deleteCredit(Long id);
    
    /**
     * Récupère tous les remboursements d'un crédit.
     *
     * @param creditId L'ID du crédit
     * @return Une liste des remboursements du crédit
     */
    List<RemboursementDTO> getCreditRemboursements(Long creditId);
    
    /**
     * Calcule le montant total des crédits pour un client.
     *
     * @param clientId L'ID du client
     * @return Le montant total des crédits
     */
    Double calculateTotalCreditAmountByClientId(Long clientId);
    
    /**
     * Récupère tous les crédits personnels.
     *
     * @return Une liste de tous les crédits personnels
     */
    List<CreditPersonnelDTO> getAllCreditsPersonnels();
    
    /**
     * Récupère tous les crédits immobiliers.
     *
     * @return Une liste de tous les crédits immobiliers
     */
    List<CreditImmobilierDTO> getAllCreditsImmobiliers();
    
    /**
     * Récupère tous les crédits professionnels.
     *
     * @return Une liste de tous les crédits professionnels
     */
    List<CreditProfessionnelDTO> getAllCreditsProfessionnels();
    
    /**
     * Recherche des crédits personnels par motif.
     *
     * @param motif Le motif à rechercher
     * @return Une liste de crédits personnels
     */
    List<CreditPersonnelDTO> searchCreditsPersonnelsByMotif(String motif);
    
    /**
     * Recherche des crédits immobiliers par type de bien.
     *
     * @param typeBien Le type de bien à rechercher
     * @return Une liste de crédits immobiliers
     */
    List<CreditImmobilierDTO> searchCreditsImmobiliersByTypeBien(TypeBien typeBien);
    
    /**
     * Recherche des crédits professionnels par raison sociale.
     *
     * @param raisonSociale La raison sociale à rechercher
     * @return Une liste de crédits professionnels
     */
    List<CreditProfessionnelDTO> searchCreditsProfessionnelsByRaisonSociale(String raisonSociale);
}
