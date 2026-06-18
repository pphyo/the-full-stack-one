package com.codoverse.cf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	@Bean
	StringToProductConverter converter() {
		return new StringToProductConverter();
	}
	
	@Bean
	DateFormatter formatter() {
		return new DateFormatter();
	}

}
