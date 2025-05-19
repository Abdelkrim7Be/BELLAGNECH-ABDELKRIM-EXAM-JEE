package com.bellagnech.examjee.config;

import com.bellagnech.examjee.entities.*;
import com.bellagnech.examjee.enums.StatutCredit;
import com.bellagnech.examjee.enums.TypeBien;
import com.bellagnech.examjee.enums.TypeRemboursement;
import com.bellagnech.examjee.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Classe pour initialiser des données de test pour l'API.
 * Cette classe est activée uniquement avec les profils "dev" ou "h2".
 */
@Configuration
@Profile({"dev", "h2"})
public class TestDataInitializer {

    /**
     * Initialise des données de test pour l'API.
     *
     * @param clientRepository Le repository des clients
     * @param creditRepository Le repository des crédits
     * @param creditPersonnelRepository Le repository des crédits personnels
     * @param creditImmobilierRepository Le repository des crédits immobiliers
     * @param creditProfessionnelRepository Le repository des crédits professionnels
     * @param remboursementRepository Le repository des remboursements
     * @return Un CommandLineRunner qui initialise les données
     */
    @Bean
    public CommandLineRunner initData(
            ClientRepository clientRepository,
            CreditRepository creditRepository,
            CreditPersonnelRepository creditPersonnelRepository,
            CreditImmobilierRepository creditImmobilierRepository,
            CreditProfessionnelRepository creditProfessionnelRepository,
            RemboursementRepository remboursementRepository) {

        return args -> {
            // Vérifier si des données existent déjà
            if (clientRepository.count() > 0) {
                return; // Ne pas initialiser si des données existent déjà
            }

            // Créer des clients
            Client client1 = new Client();
            client1.setNom("Dupont Jean");
            client1.setEmail("jean.dupont@example.com");

            Client client2 = new Client();
            client2.setNom("Martin Sophie");
            client2.setEmail("sophie.martin@example.com");

            // Sauvegarder les clients
            clientRepository.saveAll(Arrays.asList(client1, client2));

            // Créer des crédits personnels
            CreditPersonnel creditPersonnel = new CreditPersonnel();
            creditPersonnel.setClient(client1);
            creditPersonnel.setDateDemande(LocalDate.now().minusMonths(2));
            creditPersonnel.setStatut(StatutCredit.ACCEPTE);
            creditPersonnel.setDateAcception(LocalDate.now().minusMonths(1));
            creditPersonnel.setMontant(10000.0);
            creditPersonnel.setDureeRemboursement(24);
            creditPersonnel.setTauxInteret(3.5);
            creditPersonnel.setMotif("Achat de mobilier");

            // Créer des crédits immobiliers
            CreditImmobilier creditImmobilier = new CreditImmobilier();
            creditImmobilier.setClient(client1);
            creditImmobilier.setDateDemande(LocalDate.now().minusMonths(3));
            creditImmobilier.setStatut(StatutCredit.ACCEPTE);
            creditImmobilier.setDateAcception(LocalDate.now().minusMonths(2));
            creditImmobilier.setMontant(200000.0);
            creditImmobilier.setDureeRemboursement(240);
            creditImmobilier.setTauxInteret(2.1);
            creditImmobilier.setTypeBien(TypeBien.APPARTEMENT);

            // Créer des crédits professionnels
            CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
            creditProfessionnel.setClient(client2);
            creditProfessionnel.setDateDemande(LocalDate.now().minusMonths(1));
            creditProfessionnel.setStatut(StatutCredit.EN_COURS);
            creditProfessionnel.setMontant(50000.0);
            creditProfessionnel.setDureeRemboursement(60);
            creditProfessionnel.setTauxInteret(4.2);
            creditProfessionnel.setMotif("Achat de matériel");
            creditProfessionnel.setRaisonSociale("SARL Martin Entreprise");

            // Sauvegarder les crédits
            creditPersonnelRepository.save(creditPersonnel);
            creditImmobilierRepository.save(creditImmobilier);
            creditProfessionnelRepository.save(creditProfessionnel);

            // Créer des remboursements
            Remboursement remboursement1 = new Remboursement();
            remboursement1.setCredit(creditPersonnel);
            remboursement1.setDate(LocalDate.now().minusDays(15));
            remboursement1.setMontant(500.0);
            remboursement1.setType(TypeRemboursement.MENSUALITE);

            Remboursement remboursement2 = new Remboursement();
            remboursement2.setCredit(creditImmobilier);
            remboursement2.setDate(LocalDate.now().minusDays(10));
            remboursement2.setMontant(800.0);
            remboursement2.setType(TypeRemboursement.MENSUALITE);

            // Sauvegarder les remboursements
            remboursementRepository.saveAll(Arrays.asList(remboursement1, remboursement2));

            System.out.println("Données de test initialisées avec succès !");
        };
    }
}
