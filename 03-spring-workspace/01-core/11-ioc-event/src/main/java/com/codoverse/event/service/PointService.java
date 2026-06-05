package com.codoverse.event.service;

import org.springframework.stereotype.Service;

@Service
public class PointService {
	
	public void addWelcomePoints(String username) {
		IO.println("[PointService] Adding welcome point to your account, " + username);
	}

}
