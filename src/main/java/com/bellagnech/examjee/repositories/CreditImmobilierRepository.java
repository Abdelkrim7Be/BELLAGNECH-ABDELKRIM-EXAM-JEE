package com.bellagnech.examjee.repositories;

import com.bellagnech.examjee.entities.CreditImmobilier;
import com.bellagnech.examjee.enums.StatutCredit;
import com.bellagnech.examjee.enums.TypeBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour l'entité CreditImmobilier.
 * Fournit les opérations CRUD de base et des méthodes personnalisées.
 */
@Repository
public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
    /**
     * Trouve des crédits immobiliers par type de bien.
     *
     * @param typeBien Le type de bien immobilier
     * @return Une liste de crédits immobiliers
     */
    List<CreditImmobilier> findByTypeBien(TypeBien typeBien);

    /**
     * Trouve des crédits immobiliers par statut et type de bien.
     *
     * @param statut Le statut des crédits à rechercher
     * @param typeBien Le type de bien immobilier
     * @return Une liste de crédits immobiliers
     */
    List<CreditImmobilier> findByStatutAndTypeBien(StatutCredit statut, TypeBien typeBien);

    /**
     * Compte le nombre de crédits immobiliers par type de bien.
     *
     * @param typeBien Le type de bien immobilier
     * @return Le nombre de crédits immobiliers
     */
    long countByTypeBien(TypeBien typeBien);

    /**
     * Calcule le montant moyen des crédits immobiliers par type de bien.
     *
     * @param typeBien Le type de bien immobilier
     * @return Le montant moyen des crédits immobiliers
     */
    @Query("SELECT AVG(ci.montant) FROM CreditImmobilier ci WHERE ci.typeBien = ?1")
    Double calculateAverageCreditAmountByTypeBien(TypeBien typeBien);

    /**
     * Trouve les crédits immobiliers d'un client.
     *
     * @param clientId L'identifiant du client
     * @return Une liste de crédits immobiliers
     */
    List<CreditImmobilier> findByClientId(Long clientId);
}
