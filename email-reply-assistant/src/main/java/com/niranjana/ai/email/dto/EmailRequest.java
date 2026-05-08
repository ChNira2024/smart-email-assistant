package com.niranjana.ai.email.dto;
import jakarta.validation.constraints.NotBlank;

public class EmailRequest {

    @NotBlank(message = "Email content is required")
    private String emailContent;

    private String tone;

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getTone() {
		return tone;
	}

	public void setTone(String tone) {
		this.tone = tone;
	}

	public EmailRequest(@NotBlank(message = "Email content is required") String emailContent, String tone) {
		super();
		this.emailContent = emailContent;
		this.tone = tone;
	}

	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmailRequest [emailContent=" + emailContent + ", tone=" + tone + "]";
	}
    
    
    
}