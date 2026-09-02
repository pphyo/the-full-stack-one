package com.codoverse.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJdbcRepositories(basePackages = "com.codoverse.jdbc")
public class Application {
	
	final ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return _ -> {
			IO.println(java.util.Arrays.toString(context.getBeanDefinitionNames()));
		};
	};

}
