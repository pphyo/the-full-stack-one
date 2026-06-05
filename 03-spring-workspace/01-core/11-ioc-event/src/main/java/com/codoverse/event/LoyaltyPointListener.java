package com.codoverse.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.codoverse.event.service.PointService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoyaltyPointListener {
	
	private final PointService service;

	@EventListener
	public void allocateWelcomePoints(UserRegisteredEvent event) {
		
		IO.println("[PointListener] Allocating 100 Welcome points to user: " + event.getUsername());
		
		service.addWelcomePoints(event.getUsername());
		
	}
	
}
