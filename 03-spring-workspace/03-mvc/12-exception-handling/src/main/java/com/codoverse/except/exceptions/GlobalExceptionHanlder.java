package com.codoverse.except.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHanlder {

	@ExceptionHandler(DuplicateProductException.class)
	public String handleDuplicationProductException(DuplicateProductException ex, Model model) {
		model.addAttribute("errorTitle", "Duplicate Error");
		model.addAttribute("errorMessage", ex.getMessage());
		return "error-page";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleGeneralException(Exception ex, Model model) {
		ex.printStackTrace();
		model.addAttribute("errorTitle", "System Error");
		model.addAttribute("errorMessage", "An unexpected error occurred: " + ex.getMessage());
		return "error-page";
	}
	
}
