package com.codoverse.di;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsService implements MessageService {
	
	@Override
	public void send(String message) {
		log.info("Sending by SMS: " + message);
	}

}
