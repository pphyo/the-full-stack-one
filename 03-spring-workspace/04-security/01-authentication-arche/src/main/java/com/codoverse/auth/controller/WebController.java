package com.codoverse.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String handleLoginPage() {
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String handleDashboard(Authentication authentication, Model model) {
		model.addAttribute("username", authentication.getName());
		return "dashboard";
	}
	
}
