package com.bellagnech.examjee.repositories;

import com.bellagnech.examjee.entities.CreditProfessionnel;
import com.bellagnech.examjee.enums.StatutCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour l'entité CreditProfessionnel.
 * Fournit les opérations CRUD de base et des méthodes personnalisées.
 */
@Repository
public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
    /**
     * Trouve des crédits professionnels dont le motif contient la chaîne spécifiée (insensible à la casse).
     *
     * @param motif La chaîne à rechercher dans le motif des crédits
     * @return Une liste de crédits professionnels
     */
    List<CreditProfessionnel> findByMotifContainingIgnoreCase(String motif);

    /**
     * Trouve des crédits professionnels dont la raison sociale contient la chaîne spécifiée (insensible à la casse).
     *
     * @param raisonSociale La chaîne à rechercher dans la raison sociale
     * @return Une liste de crédits professionnels
     */
    List<CreditProfessionnel> findByRaisonSocialeContainingIgnoreCase(String raisonSociale);

    /**
     * Trouve des crédits professionnels par statut et raison sociale.
     *
     * @param statut Le statut des crédits à rechercher
     * @param raisonSociale La chaîne à rechercher dans la raison sociale
     * @return Une liste de crédits professionnels
     */
    List<CreditProfessionnel> findByStatutAndRaisonSocialeContainingIgnoreCase(StatutCredit statut, String raisonSociale);

    /**
     * Calcule le montant moyen des crédits professionnels.
     *
     * @return Le montant moyen des crédits professionnels
     */
    @Query("SELECT AVG(cp.montant) FROM CreditProfessionnel cp")
    Double calculateAverageCreditAmount();

    /**
     * Trouve les crédits professionnels d'un client.
     *
     * @param clientId L'identifiant du client
     * @return Une liste de crédits professionnels
     */
    List<CreditProfessionnel> findByClientId(Long clientId);
}
