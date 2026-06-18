package com.codoverse.cf;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api")
public class ProductController {
	
	@GetMapping("profile")
	public String handleConverter(Model model, @RequestParam Product product) {
		model.addAttribute("value", product);
		return "index";
	}
	
	@GetMapping("date")
	public String handleFormatter(Model model, LocalDate today) {
		model.addAttribute("value", today);
		return "index";
	}

}
