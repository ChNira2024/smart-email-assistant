package com.niranjana.ai.email.service.impl;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niranjana.ai.email.dto.EmailRequest;
import com.niranjana.ai.email.exception.EmailGenerationException;
import com.niranjana.ai.email.service.EmailGeneratorService;

@Service
public class EmailGeneratorServiceImpl implements EmailGeneratorService {
	private static final Logger log = LoggerFactory.getLogger(EmailGeneratorServiceImpl.class);
		
    private final WebClient webClient;

    @Value("${gemini.api.base-url}")
    private String baseUrl;

    @Value("${gemini.api.model}")
    private String model;

    @Value("${gemini.api.key}")
    private String apiKey;

    public EmailGeneratorServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String generateEmailReply(EmailRequest emailRequest) {

        String prompt = buildPrompt(emailRequest);
        log.info("Generated Prompt: {}", prompt);
        
        String url = baseUrl + "/" + model + ":generateContent?key=" + apiKey;

        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );

        try {
            String response = webClient.post()
                    .uri(url)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            log.debug("Full Gemini API Response: {}", response);

            String parsedResponse = extractResponseContent(response);

            log.info("Generated Email parsedResponse: {}", parsedResponse);

            return parsedResponse;

        } catch (Exception e) {
            log.error("Error calling Gemini API", e);
            throw new EmailGenerationException("Failed to generate email response");
        }
    }
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    private String extractResponseContent(String response) {
        try {
            JsonNode rootNode = objectMapper.readTree(response);

            JsonNode textNode = rootNode.path("candidates")
                    .path(0)
                    .path("content")
                    .path("parts")
                    .path(0)
                    .path("text");

            //validation
            if (textNode.isMissingNode() || textNode.asText().trim().isEmpty()) {
                log.error("Invalid Gemini response structure: {}", response);
                throw new EmailGenerationException("Invalid response from AI");
            }
            return textNode.asText().trim();
            
        } catch (Exception e) {
            log.error("Error parsing Gemini response", e);
            throw new EmailGenerationException("Error parsing AI response");
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("You are an AI assistant that writes professional email replies.\n");
        prompt.append("Generate a clear and concise reply to the following email.\n");
        prompt.append("Do NOT include a subject line.\n");
        prompt.append("Do NOT add any explanation outside the email.\n");

        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("Use a ")
                  .append(emailRequest.getTone())
                  .append(" and polite tone.\n");
        }

        prompt.append("\nOriginal email:\n")
              .append(emailRequest.getEmailContent())
              .append("\n\nReply:");

        return prompt.toString();
    }
}