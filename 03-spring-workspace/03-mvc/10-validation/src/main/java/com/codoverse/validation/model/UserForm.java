package com.codoverse.validation.model;

import com.codoverse.validation.validator.PasswordMatch;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatch
@GroupSequence({UserForm.class, UserForm.AdvancedCheck.class})
public class UserForm {

	@NotBlank(message = "Email is required!")
	@Email(message = "Please enter correct email format!")
	private String email;

	@NotEmpty(message = "Password is required!")
	@Size(min = 6, message = "Password must be at least 6 characters long!", groups = AdvancedCheck.class)
	private String password;
	
	private String confirmPassword;

	@NotEmpty(message = "Bio is required!")
	@Size(max = 100, message = "Bio cannot exceed 100 characters!")
	private String bio;

	private Gender gender;
	
	@NotEmpty(message = "Please select country!")
	private String country;

	private boolean subscribe;

	public enum Gender {
		Male, Female
	}
	
	public interface AdvancedCheck {}

}
