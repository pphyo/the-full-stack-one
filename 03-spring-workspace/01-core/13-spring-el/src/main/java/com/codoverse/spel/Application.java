package com.codoverse.spel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	@Value("#{ '*' * (T(java.lang.Math).random() * 100).intValue() }")
	private String stars;
	
	@Value("#{ {1, 2, 3, 4, 5} }")
	private List<Integer> numbers;
	
	@Value("#{ {'name':'John', 'role':'Admin'} }")
    private Map<String, String> userMap;
	
	@Value("#{ systemRoles[1] }")
	private String secondRole;
	
	@Value("#{ employees.?[salary > 50000] }")
	private List<Employee> highEarner;
	
	@Value("#{ employees.![name] }")
	private List<String> empNames;
	
	@Value("${app.title}")
	private String appTitle;
	
	@Bean
	@SuppressWarnings("unused")
	CommandLineRunner runner(SpELBean spel) {
		return args -> {
			IO.println(spel.message());
			IO.println(stars);
			IO.println(numbers);
			IO.println(userMap);
			IO.println(secondRole);
			IO.println(highEarner);
			IO.println(empNames);
			IO.println(appTitle);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
