package com.codoverse.env;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

	private final BeanForDefault bean;
	private final Environment env;

	public Application(BeanForDefault bean, Environment env) {
		this.bean = bean;
		this.env = env;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	@SuppressWarnings("unused")
	ApplicationRunner runner() {
		return (args) -> {
			bean.run();
			IO.println("Name: " + env.getProperty("spring.application.name"));
		};
	}

}
