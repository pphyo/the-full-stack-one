package com.codoverse.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.codoverse.event.service.EmailService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WelcomeEmailListener {
	
	private final EmailService service;
	
	@EventListener
	public void handleUserRegistrationSetupEmail(UserRegisteredEvent event) {
		service.sendWelcomeEmail(event.getEmail());

		IO.println("[EmailListener] Sending Welcome Email to: " + event.getEmail());
		
		IO.println("[EmailListener] Hello " + event.getUsername() + ", welcome to our platform!");
		
	}

}
