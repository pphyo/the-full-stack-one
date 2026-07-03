package com.codoverse.validation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordMatchValidator.class)
public @interface PasswordMatch {

	String message() default "Password and Confirm Password do not match!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
