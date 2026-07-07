package com.codoverse.except.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codoverse.except.dto.ProductForm;
import com.codoverse.except.exceptions.DuplicateProductException;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping
	public String handleShowForm(Model model) {
		model.addAttribute("productForm", new ProductForm());
		return "product-form";
	}
	
	@PostMapping
	public String handleSubmitForm(@Validated @ModelAttribute("productForm") ProductForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "product-form";
		}
		
		if("Apple".equalsIgnoreCase(form.getName())) {
			throw new DuplicateProductException("Product 'Apple' is already registered in the system!");
		}
		
		if("Error".equalsIgnoreCase(form.getName())) {
			throw new IllegalArgumentException("You used a restricted keyword!");
		}
		
		return "redirect:/products/new?success";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleLocalException(IllegalArgumentException ex, Model model) {
		model.addAttribute("errorTitle", "Invalid Input Error");
		model.addAttribute("errorMessage", "Local Handler caught: " + ex.getMessage());
		return "error-page";
	}

}
