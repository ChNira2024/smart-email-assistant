package com.niranjana.ai.email.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niranjana.ai.email.dto.EmailRequest;
import com.niranjana.ai.email.service.EmailGeneratorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/email")
@Tag(name = "Email Generator API", description = "Generate AI-based email replies")
public class EmailGeneratorController {
	private static final Logger log = LoggerFactory.getLogger(EmailGeneratorController.class);
	
    private final EmailGeneratorService emailGeneratorService;

    public EmailGeneratorController(EmailGeneratorService emailGeneratorService) {
		this.emailGeneratorService = emailGeneratorService;
	}



	@Operation(summary = "Generate email reply using AI")
    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@Valid @RequestBody EmailRequest emailRequest) {

        log.info("Received request to generate email. Tone: {}", emailRequest.getTone());

        String response = emailGeneratorService.generateEmailReply(emailRequest);

        log.info("Email generated successfully");

        return ResponseEntity.ok(response);
    }
}