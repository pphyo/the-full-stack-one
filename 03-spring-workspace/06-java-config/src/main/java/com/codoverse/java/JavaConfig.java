package com.codoverse.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.codoverse.java.bean.ServiceBean;

@Configuration
@ComponentScan
public class JavaConfig {
	
	@Bean
	String messageBean() {
		return new String("default message");
	}
	
	@Bean
	ServiceBean serviceBean() {
		return new ServiceBean();
	}

}
