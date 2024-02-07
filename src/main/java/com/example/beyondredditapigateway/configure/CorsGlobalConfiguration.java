package com.example.beyondredditapigateway.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;
import org.springframework.web.cors.reactive.CorsWebFilter;

@Configuration
public class CorsGlobalConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOrigin("*"); // Customize according to your requirements
        corsConfig.addAllowedOriginPattern("*");
        corsConfig.addAllowedMethod("*"); // Or specify "GET", "POST", etc.
        corsConfig.addAllowedHeader("*"); // Or specify actual headers
        corsConfig.setAllowCredentials(true); // If needed
        corsConfig.setMaxAge(3600L); // Adjust as necessary

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", corsConfig); // Apply to all routes

        return new CorsWebFilter(source);
    }
}

