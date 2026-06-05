package com.codoverse.event;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private final String username;
	private final String email;

	public UserRegisteredEvent(Object source, String username, String email) {
		super(source);
		this.username = username;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}

}
