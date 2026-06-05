package com.codoverse.aops;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.codoverse.aops.service.OrderService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}
	
	@Bean
	@SuppressWarnings("unused")
	CommandLineRunner runner(OrderService service) {
		return args -> {
			service.processComplexOrder();
			service.loadSimpleTask();
		};
	}

}
