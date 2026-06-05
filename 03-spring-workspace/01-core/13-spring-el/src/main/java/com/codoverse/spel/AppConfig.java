package com.codoverse.spel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/el.properties")
public class AppConfig {
	
	@Bean
	SpELBean spel() {
		return new SpELBean();
	}
	
	@Bean
	List<String> systemRoles() {
		return new ArrayList<>(List.of("User", "Admin", "SuperAdmin"));
	}
	
	@Bean
	List<Employee> employees() {
		return new ArrayList<>(List.of(
				new Employee("Alena", 40000),
				new Employee("Zyan", 60000),
				new Employee("Elene", 56000),
				new Employee("Lesley", 50000)
			));
	}

}
