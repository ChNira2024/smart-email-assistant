package com.niranjana.ai.email.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Smart Email Assistant API")
                        .version("1.0")
                        .description("AI-powered email reply generator using Gemini API"));
    }
}