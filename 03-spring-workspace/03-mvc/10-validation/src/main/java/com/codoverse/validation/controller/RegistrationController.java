package com.codoverse.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codoverse.validation.model.UserForm;
import com.codoverse.validation.model.UserForm.Gender;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
//	@InitBinder
//	void initBinder(WebDataBinder binder) {
//		binder.addValidators(new UserValidator());
//	}
	
	@GetMapping
	public String handleShowForm(Model model) {
		var form = new UserForm();
		form.setGender(Gender.Male);
		model.addAttribute("userForm", form);
		return "register-form";
	}
	
	@PostMapping
	public String handleSubmitForm(@Validated @ModelAttribute UserForm userForm, BindingResult result) {
		
		if (result.hasErrors()) {
			return "register-form";
		}
		
		IO.println(userForm);
		return "redirect:/register?success";
	}
	
}
