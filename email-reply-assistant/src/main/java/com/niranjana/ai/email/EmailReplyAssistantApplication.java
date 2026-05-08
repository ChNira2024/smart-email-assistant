package com.niranjana.ai.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailReplyAssistantApplication {
	private static final Logger log = LoggerFactory.getLogger(EmailReplyAssistantApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmailReplyAssistantApplication.class, args);
		log.info("EmailReplyAssistantApplication is started..........");
	}

}
