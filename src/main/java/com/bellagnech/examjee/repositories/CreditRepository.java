package com.bellagnech.examjee.repositories;

import com.bellagnech.examjee.entities.Credit;
import com.bellagnech.examjee.enums.StatutCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository pour l'entité Credit.
 * Fournit les opérations CRUD de base et des méthodes personnalisées.
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    /**
     * Trouve tous les crédits associés à un client.
     *
     * @param clientId L'identifiant du client
     * @return Une liste de crédits
     */
    List<Credit> findByClientId(Long clientId);

    /**
     * Trouve tous les crédits ayant un statut spécifique.
     *
     * @param statut Le statut des crédits à rechercher
     * @return Une liste de crédits
     */
    List<Credit> findByStatut(StatutCredit statut);

    /**
     * Trouve tous les crédits dont la date de demande est comprise dans une plage.
     *
     * @param dateDebut La date de début de la plage
     * @param dateFin La date de fin de la plage
     * @return Une liste de crédits
     */
    List<Credit> findByDateDemandeBetween(LocalDate dateDebut, LocalDate dateFin);

    /**
     * Trouve tous les crédits dont le montant est compris dans une plage.
     *
     * @param montantMin Le montant minimum
     * @param montantMax Le montant maximum
     * @return Une liste de crédits
     */
    List<Credit> findByMontantBetween(Double montantMin, Double montantMax);

    /**
     * Compte le nombre de crédits par statut.
     *
     * @param statut Le statut des crédits à compter
     * @return Le nombre de crédits
     */
    long countByStatut(StatutCredit statut);

    /**
     * Trouve les crédits dont la date d'acceptation est postérieure à une date donnée.
     *
     * @param date La date de référence
     * @return Une liste de crédits
     */
    List<Credit> findByDateAcceptionAfter(LocalDate date);

    /**
     * Calcule le montant total des crédits pour un client.
     *
     * @param clientId L'identifiant du client
     * @return Le montant total des crédits
     */
    @Query("SELECT SUM(c.montant) FROM Credit c WHERE c.client.id = :clientId")
    Double calculateTotalCreditAmountByClientId(@Param("clientId") Long clientId);
}
