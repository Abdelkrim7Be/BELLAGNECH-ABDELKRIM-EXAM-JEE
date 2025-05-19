package com.bellagnech.examjee.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Configuration pour la documentation OpenAPI/Swagger.
 */
@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    /**
     * Configure les informations de l'API pour la documentation OpenAPI.
     *
     * @return Une instance OpenAPI configurée
     */
    @Bean
    public OpenAPI customOpenAPI() {
        // Création des exemples pour les tests
        Map<String, Example> clientExamples = createClientExamples();
        Map<String, Example> creditExamples = createCreditExamples();
        Map<String, Example> remboursementExamples = createRemboursementExamples();

        // Création des réponses API communes
        Map<String, ApiResponse> apiResponses = createCommonApiResponses();

        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion de Crédits")
                        .description("API REST pour gérer les clients, les crédits et les remboursements. " +
                                "Cette API permet de créer et gérer des clients, différents types de crédits " +
                                "(personnels, immobiliers, professionnels) et leurs remboursements.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Bellagnech")
                                .email("contact@bellagnech.com")
                                .url("https://www.bellagnech.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Serveur de développement")
                ))
                .components(new Components()
                        .examples(clientExamples)
                        .addExamples("creditPersonnelExample", creditExamples.get("creditPersonnelExample"))
                        .addExamples("creditImmobilierExample", creditExamples.get("creditImmobilierExample"))
                        .addExamples("creditProfessionnelExample", creditExamples.get("creditProfessionnelExample"))
                        .addExamples("remboursementExample", remboursementExamples.get("remboursementExample"))
                        .responses(apiResponses)
                );
    }

    /**
     * Crée des exemples de clients pour les tests.
     *
     * @return Map d'exemples de clients
     */
    private Map<String, Example> createClientExamples() {
        Map<String, Example> examples = new HashMap<>();

        Example clientExample = new Example()
                .value("{\n" +
                        "  \"nom\": \"Dupont Jean\",\n" +
                        "  \"email\": \"jean.dupont@example.com\",\n" +
                        "  \"creditIds\": []\n" +
                        "}");

        examples.put("clientExample", clientExample);
        return examples;
    }

    /**
     * Crée des exemples de crédits pour les tests.
     *
     * @return Map d'exemples de crédits
     */
    private Map<String, Example> createCreditExamples() {
        Map<String, Example> examples = new HashMap<>();

        // Exemple de crédit personnel
        Example creditPersonnelExample = new Example()
                .value("{\n" +
                        "  \"dateDemande\": \"2023-06-15\",\n" +
                        "  \"statut\": \"EN_COURS\",\n" +
                        "  \"montant\": 10000.0,\n" +
                        "  \"dureeRemboursement\": 24,\n" +
                        "  \"tauxInteret\": 3.5,\n" +
                        "  \"clientId\": 1,\n" +
                        "  \"motif\": \"Achat de mobilier\"\n" +
                        "}");
        examples.put("creditPersonnelExample", creditPersonnelExample);

        // Exemple de crédit immobilier
        Example creditImmobilierExample = new Example()
                .value("{\n" +
                        "  \"dateDemande\": \"2023-07-20\",\n" +
                        "  \"statut\": \"EN_COURS\",\n" +
                        "  \"montant\": 200000.0,\n" +
                        "  \"dureeRemboursement\": 240,\n" +
                        "  \"tauxInteret\": 2.1,\n" +
                        "  \"clientId\": 1,\n" +
                        "  \"typeBien\": \"APPARTEMENT\"\n" +
                        "}");
        examples.put("creditImmobilierExample", creditImmobilierExample);

        // Exemple de crédit professionnel
        Example creditProfessionnelExample = new Example()
                .value("{\n" +
                        "  \"dateDemande\": \"2023-08-10\",\n" +
                        "  \"statut\": \"EN_COURS\",\n" +
                        "  \"montant\": 50000.0,\n" +
                        "  \"dureeRemboursement\": 60,\n" +
                        "  \"tauxInteret\": 4.2,\n" +
                        "  \"clientId\": 1,\n" +
                        "  \"motif\": \"Achat de matériel\",\n" +
                        "  \"raisonSociale\": \"SARL Dupont Entreprise\"\n" +
                        "}");
        examples.put("creditProfessionnelExample", creditProfessionnelExample);

        return examples;
    }

    /**
     * Crée des exemples de remboursements pour les tests.
     *
     * @return Map d'exemples de remboursements
     */
    private Map<String, Example> createRemboursementExamples() {
        Map<String, Example> examples = new HashMap<>();

        Example remboursementExample = new Example()
                .value("{\n" +
                        "  \"date\": \"2023-09-15\",\n" +
                        "  \"montant\": 500.0,\n" +
                        "  \"type\": \"MENSUALITE\",\n" +
                        "  \"creditId\": 1\n" +
                        "}");

        examples.put("remboursementExample", remboursementExample);
        return examples;
    }

    /**
     * Crée des réponses API communes pour la documentation.
     *
     * @return Map de réponses API
     */
    private Map<String, ApiResponse> createCommonApiResponses() {
        Map<String, ApiResponse> responses = new HashMap<>();

        ApiResponse badRequestResponse = new ApiResponse()
                .description("Requête invalide")
                .content(new Content().addMediaType("application/json",
                        new MediaType().example("{\n  \"error\": \"Données invalides\",\n  \"message\": \"Veuillez vérifier les données fournies\"\n}")));

        ApiResponse notFoundResponse = new ApiResponse()
                .description("Ressource non trouvée")
                .content(new Content().addMediaType("application/json",
                        new MediaType().example("{\n  \"error\": \"Non trouvé\",\n  \"message\": \"La ressource demandée n'existe pas\"\n}")));

        ApiResponse serverErrorResponse = new ApiResponse()
                .description("Erreur serveur")
                .content(new Content().addMediaType("application/json",
                        new MediaType().example("{\n  \"error\": \"Erreur serveur\",\n  \"message\": \"Une erreur est survenue lors du traitement de la requête\"\n}")));

        responses.put("BadRequest", badRequestResponse);
        responses.put("NotFound", notFoundResponse);
        responses.put("ServerError", serverErrorResponse);

        return responses;
    }
}
