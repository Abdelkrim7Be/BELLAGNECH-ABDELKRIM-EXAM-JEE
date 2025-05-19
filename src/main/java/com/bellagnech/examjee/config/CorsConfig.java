package com.bellagnech.examjee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Configuration CORS pour autoriser les requêtes du frontend Angular.
 */
@Configuration
public class CorsConfig {
    
    /**
     * Configure le filtre CORS pour autoriser les requêtes du frontend.
     *
     * @return Un filtre CORS configuré
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Autoriser les origines
        config.addAllowedOrigin("*"); // Pour le développement, à restreindre en production
        
        // Autoriser les en-têtes
        config.addAllowedHeader("*");
        
        // Autoriser les méthodes HTTP
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        
        // Autoriser les cookies
        config.setAllowCredentials(false);
        
        // Appliquer cette configuration à tous les chemins
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}
