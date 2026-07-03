package com.codoverse.scope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codoverse.scope.counter.ApplicationCounter;
import com.codoverse.scope.counter.RequestCounter;
import com.codoverse.scope.counter.SessionCounter;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CounterController {
	
	private final RequestCounter requestCounter;
	private final SessionCounter sessionCounter;
	private final ApplicationCounter applicationCounter;
	
	@GetMapping
	public String index() {
		return "redirect:/counters";
	}

	@GetMapping("/counters")
	public String handleShowcounters(Model model) {
		
		model.addAttribute("requestCounter", requestCounter.incrementAndGet());
		model.addAttribute("sessionCounter", sessionCounter.incrementAndGet());
		model.addAttribute("applicationCounter", applicationCounter.incrementAndGet());
		
		return "counters";
	}
	
}
