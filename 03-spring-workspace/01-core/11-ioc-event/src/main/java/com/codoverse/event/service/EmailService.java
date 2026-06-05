package com.codoverse.event.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void sendWelcomeEmail(String email) {
		IO.println("[EmailService] Sending email \"Welcome to our system\" to " + email);
	}

}
