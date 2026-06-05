package com.codoverse.event.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.codoverse.event.UserRegisteredEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final ApplicationEventPublisher publisher;
	
	public void registerUser(String username, String email) {
		IO.println("[UserService] Saveing to DB: " + username);
		
		// create event
		var event = new UserRegisteredEvent(this, username, email);
		
		IO.println("[UserService] Publishing UserRegisteredEvent...");
		
		// publish the event
		publisher.publishEvent(event);
		
		IO.println("[UserService] User registration completed successfully.\n");
	}

}
