package com.codoverse.validation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.codoverse.validation.model.UserForm;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForm form = (UserForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bio", "error.bio", "Bio is required.");
		
		// ""
		if (!form.getPassword().isBlank() &&  form.getPassword().strip().length() < 6) {
			errors.rejectValue("password", "error.password.length", "Password must be at least 6 characters long.");
		}
		
		if (form.getCountry() == null || form.getCountry().isBlank()) {
			errors.rejectValue("country", "error.country", "Please select your country.");
		}
		
		if (!form.getBio().isBlank() && form.getBio().length() > 100) {
			errors.rejectValue("bio", "error.bio.length", "Bio cannot exceed 100 characters.");
		}
	}

}
