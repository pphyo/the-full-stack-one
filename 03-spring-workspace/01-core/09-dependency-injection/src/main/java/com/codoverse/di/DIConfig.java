package com.codoverse.di;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DIConfig {
	
	@Bean
	OrderService orderService(MessageService messageService) {
		return new OrderService(messageService);
	}
	
	@Bean
	@Primary
	MessageService emailService() {
		return new EmailService();
	}

	@Bean
	MessageService smsService() {
		return new SmsService();
	}
	
	@Bean
	MessageGateway messageGateway(List<MessageService> list) {
		return new MessageGateway(list);
	}

}
