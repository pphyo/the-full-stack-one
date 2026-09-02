package com.codoverse.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.codoverse.auth.entity.AppUser;
import com.codoverse.auth.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.count() == 0) {
			AppUser user = new AppUser();
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("Admin@123"));
			user.setRole("ROLE_ADMIN");
			userRepository.save(user);
		}
		
	}

}
