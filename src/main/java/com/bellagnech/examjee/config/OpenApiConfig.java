package com.bellagnech.examjee.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration pour la documentation OpenAPI/Swagger.
 */
@Configuration
public class OpenApiConfig {
    
    /**
     * Configure les informations de l'API pour la documentation OpenAPI.
     *
     * @return Une instance OpenAPI configurée
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion de Crédits")
                        .description("API REST pour gérer les clients, les crédits et les remboursements")
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
                ));
    }
}
