package com.bellagnech.examjee.repositories;

import com.bellagnech.examjee.entities.Remboursement;
import com.bellagnech.examjee.enums.TypeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository pour l'entité Remboursement.
 * Fournit les opérations CRUD de base et des méthodes personnalisées.
 */
@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    /**
     * Trouve tous les remboursements associés à un crédit.
     *
     * @param creditId L'identifiant du crédit
     * @return Une liste de remboursements
     */
    List<Remboursement> findByCreditId(Long creditId);

    /**
     * Trouve tous les remboursements dont la date est comprise dans une plage.
     *
     * @param dateDebut La date de début de la plage
     * @param dateFin La date de fin de la plage
     * @return Une liste de remboursements
     */
    List<Remboursement> findByDateBetween(LocalDate dateDebut, LocalDate dateFin);

    /**
     * Trouve tous les remboursements d'un type spécifique.
     *
     * @param type Le type de remboursement à rechercher
     * @return Une liste de remboursements
     */
    List<Remboursement> findByType(TypeRemboursement type);

    /**
     * Trouve tous les remboursements d'un crédit et d'un type spécifique.
     *
     * @param creditId L'identifiant du crédit
     * @param type Le type de remboursement à rechercher
     * @return Une liste de remboursements
     */
    List<Remboursement> findByCreditIdAndType(Long creditId, TypeRemboursement type);

    /**
     * Calcule le montant total des remboursements pour un crédit.
     *
     * @param creditId L'identifiant du crédit
     * @return Le montant total des remboursements
     */
    @Query("SELECT SUM(r.montant) FROM Remboursement r WHERE r.credit.id = :creditId")
    Double calculateTotalRemboursementAmountByCreditId(@Param("creditId") Long creditId);

    /**
     * Compte le nombre de remboursements par type.
     *
     * @param type Le type de remboursement à compter
     * @return Le nombre de remboursements
     */
    long countByType(TypeRemboursement type);

    /**
     * Trouve les remboursements dont la date est postérieure à une date donnée.
     *
     * @param date La date de référence
     * @return Une liste de remboursements
     */
    List<Remboursement> findByDateAfter(LocalDate date);
}
