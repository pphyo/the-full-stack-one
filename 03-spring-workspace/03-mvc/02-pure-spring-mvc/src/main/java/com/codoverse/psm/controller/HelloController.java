package com.codoverse.psm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String sayHello(Model model) {
		model.addAttribute("message", "Welcome Spring MVC without Boot.");
		return "hello"; // WEB-INF/views/hello.jsp
	}

}
