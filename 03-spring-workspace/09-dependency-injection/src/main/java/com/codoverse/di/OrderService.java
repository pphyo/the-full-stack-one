package com.codoverse.di;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderService {

	private final MessageService messageService;

	@Autowired
	public OrderService(@Sms MessageService messageService) {
		this.messageService = messageService;
	}

	public void completeOrder() {
		log.info("Order complete");
		messageService.send("To customer...");
	}

}
