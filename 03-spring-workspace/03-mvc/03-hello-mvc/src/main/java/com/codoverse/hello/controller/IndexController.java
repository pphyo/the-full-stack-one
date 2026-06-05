package com.codoverse.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping
	public String index(ModelMap map) {
		
		map.put("indexTitle", "Thymeleaf: Home Page");
		map.put("pageTitle", "Hello Thymeleaf!");
		
		return "index";
	}
	
}
