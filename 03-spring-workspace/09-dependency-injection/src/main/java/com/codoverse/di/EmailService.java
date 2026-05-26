package com.codoverse.di;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailService implements MessageService {
	
	public void send(String message) {
		log.info("Sending by email: " + message);
	}

}
