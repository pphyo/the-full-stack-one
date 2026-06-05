package com.codoverse.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.codoverse.event.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@SuppressWarnings("unused")
	@Bean
	CommandLineRunner runner(UserService service) {
		return args -> {
			IO.println("======= Starting Registration Process ========");
			
			service.registerUser("pphyo", "pyaephyo@gmail.com");
		};
	}

}
