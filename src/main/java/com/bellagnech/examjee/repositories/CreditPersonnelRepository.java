package com.bellagnech.examjee.repositories;

import com.bellagnech.examjee.entities.CreditPersonnel;
import com.bellagnech.examjee.enums.StatutCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour l'entité CreditPersonnel.
 * Fournit les opérations CRUD de base et des méthodes personnalisées.
 */
@Repository
public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
    /**
     * Trouve des crédits personnels dont le motif contient la chaîne spécifiée (insensible à la casse).
     *
     * @param motif La chaîne à rechercher dans le motif des crédits
     * @return Une liste de crédits personnels
     */
    List<CreditPersonnel> findByMotifContainingIgnoreCase(String motif);

    /**
     * Trouve des crédits personnels par statut et motif.
     *
     * @param statut Le statut des crédits à rechercher
     * @param motif La chaîne à rechercher dans le motif des crédits
     * @return Une liste de crédits personnels
     */
    List<CreditPersonnel> findByStatutAndMotifContainingIgnoreCase(StatutCredit statut, String motif);

    /**
     * Calcule le montant moyen des crédits personnels.
     *
     * @return Le montant moyen des crédits personnels
     */
    @Query("SELECT AVG(cp.montant) FROM CreditPersonnel cp")
    Double calculateAverageCreditAmount();

    /**
     * Trouve les crédits personnels d'un client.
     *
     * @param clientId L'identifiant du client
     * @return Une liste de crédits personnels
     */
    List<CreditPersonnel> findByClientId(Long clientId);
}
