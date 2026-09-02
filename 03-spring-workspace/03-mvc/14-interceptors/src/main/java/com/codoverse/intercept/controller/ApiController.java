package com.codoverse.intercept.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/secure-data")
	public String handleGetSecureData() {
		IO.println("Controller: Executing getSecureData()...");
		return "Here is your highly secure data!";
	}
	
	@GetMapping("/public/info")
	public String handleGetPublicData() {
		return "This is public information.";
	}
	
}
