package com.bellagnech.examjee.repositories;

import com.bellagnech.examjee.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité Client.
 * Fournit les opérations CRUD de base et des méthodes personnalisées.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    /**
     * Trouve un client par son email.
     *
     * @param email L'email du client à rechercher
     * @return Un Optional contenant le client s'il existe
     */
    Optional<Client> findByEmail(String email);

    /**
     * Trouve des clients dont le nom contient la chaîne spécifiée (insensible à la casse).
     *
     * @param nom La chaîne à rechercher dans le nom des clients
     * @return Une liste de clients correspondant au critère
     */
    List<Client> findByNomContainingIgnoreCase(String nom);
}
