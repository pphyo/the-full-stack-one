package com.codoverse.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	String messageBean() {
		return new String("default message");
	}

}
