package com.codoverse.validation.validator;

import com.codoverse.validation.model.UserForm;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserForm> {

	@Override
	public boolean isValid(UserForm form, ConstraintValidatorContext context) {
		
		var result = form.getPassword().equals(form.getConfirmPassword());
		
		if(!result) {
			
			context.disableDefaultConstraintViolation();
			
			context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
				   .addPropertyNode("confirmPassword")
				   .addConstraintViolation();
			
		}

		return result;
	}

}
