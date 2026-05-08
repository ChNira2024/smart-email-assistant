package com.niranjana.ai.email.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/api/**")
//                        .allowedOrigins(
//                                "http://localhost:5173",     // React local
//                                "https://your-frontend.com"  // Production UI
//                        )
                        .allowedOrigins("https://mail.google.com") //Since request comes for gmail
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("Authorization", "Content-Type")//not using Authorization concept
                        .allowCredentials(true)
                        .maxAge(3600);//keep backend/cors cache for 1hr in browser.
            }
        };
    }
}