package com.niranjana.ai.email.service;

import com.niranjana.ai.email.dto.EmailRequest;

public interface EmailGeneratorService{
	
	public String generateEmailReply(EmailRequest emailRequest);
}