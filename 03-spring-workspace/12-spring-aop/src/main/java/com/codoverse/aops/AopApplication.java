package com.codoverse.aops;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.codoverse.aops.service.AspectService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}
	
	@Bean
	@SuppressWarnings("unused")
	CommandLineRunner runner(AspectService service) {
		return args -> {
			try {
//				service.withVoid();
				IO.println(service.withString("Hello"));
			} catch (Exception e) {
				IO.println("Error: " + e.getMessage());
			}
		};
	}

}
