package com.codoverse.url;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wildcard")
public class WildcardController {
	
	@GetMapping("string/{strVal}")
	public String handleString(Model model, @PathVariable String strVal) {
		return addAndReturn(model, strVal);
	}
	
	@GetMapping("spring-web/{symbolicName:[a-z\\-]+}-{version:\\d{1}\\.\\d{1}\\.\\d{1}}{extension:\\.[a-z]+}")
	public String handleRegularExpression(Model model, @PathVariable("symbolicName") String extension) {
		return addAndReturn(model, extension);
	}
	
	@GetMapping({"suffix/*.dmg", "suffix/*.pkg", "suffix/*.sh", "suffix/*.exe"})
	public String handleInstaller(Model model) {
		return addAndReturn(model, "The installer handler");
	}
	
	@GetMapping("asterisk/*/sub")
	public String handleOne(Model model) {
		return addAndReturn(model, "One asterik");
	}
	
	@GetMapping("asterisk/**")
	public String handleTwo(Model model) {
		return addAndReturn(model, "Two asterik");
	}
	
	private String addAndReturn(Model model, Object obj) {
		model.addAttribute("value", obj);
		return "index";
	}

}
