package com.bellagnech.examjee.services;

import com.bellagnech.examjee.dtos.RemboursementDTO;
import com.bellagnech.examjee.enums.TypeRemboursement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Service pour gérer les opérations liées aux remboursements.
 */
public interface RemboursementService {
    
    /**
     * Récupère tous les remboursements.
     *
     * @return Une liste de tous les remboursements
     */
    List<RemboursementDTO> getAllRemboursements();
    
    /**
     * Récupère un remboursement par son ID.
     *
     * @param id L'ID du remboursement à récupérer
     * @return Un Optional contenant le remboursement s'il existe
     */
    Optional<RemboursementDTO> getRemboursementById(Long id);
    
    /**
     * Récupère tous les remboursements d'un crédit.
     *
     * @param creditId L'ID du crédit
     * @return Une liste des remboursements du crédit
     */
    List<RemboursementDTO> getRemboursementsByCreditId(Long creditId);
    
    /**
     * Récupère tous les remboursements par type.
     *
     * @param type Le type de remboursement
     * @return Une liste des remboursements du type spécifié
     */
    List<RemboursementDTO> getRemboursementsByType(TypeRemboursement type);
    
    /**
     * Récupère tous les remboursements effectués après une date donnée.
     *
     * @param date La date de référence
     * @return Une liste des remboursements effectués après la date spécifiée
     */
    List<RemboursementDTO> getRemboursementsAfterDate(LocalDate date);
    
    /**
     * Crée un nouveau remboursement.
     *
     * @param remboursementDTO Les données du remboursement à créer
     * @return Le remboursement créé
     */
    RemboursementDTO createRemboursement(RemboursementDTO remboursementDTO);
    
    /**
     * Met à jour un remboursement existant.
     *
     * @param id L'ID du remboursement à mettre à jour
     * @param remboursementDTO Les nouvelles données du remboursement
     * @return Le remboursement mis à jour
     */
    RemboursementDTO updateRemboursement(Long id, RemboursementDTO remboursementDTO);
    
    /**
     * Supprime un remboursement par son ID.
     *
     * @param id L'ID du remboursement à supprimer
     */
    void deleteRemboursement(Long id);
    
    /**
     * Calcule le montant total des remboursements pour un crédit.
     *
     * @param creditId L'ID du crédit
     * @return Le montant total des remboursements
     */
    Double calculateTotalRemboursementAmountByCreditId(Long creditId);
    
    /**
     * Compte le nombre de remboursements par type.
     *
     * @param type Le type de remboursement
     * @return Le nombre de remboursements du type spécifié
     */
    long countRemboursementsByType(TypeRemboursement type);
}
