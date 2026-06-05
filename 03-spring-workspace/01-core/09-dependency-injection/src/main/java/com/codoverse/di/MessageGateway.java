package com.codoverse.di;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageGateway {
	
	private List<MessageService> messageServices;

	public MessageGateway(List<MessageService> messageServices) {
		super();
		this.messageServices = messageServices;
	}
	
	public void showBean() {
		log.info("Bean count: " + messageServices.size());
	}

}
