package com.codoverse.xml;

public class MessageService {
	
	private String message;
	
	public MessageService(String message) {
		this.message = message;
	}
	
	public String say() {
		
		String result = "";
		
		if(null == message || message.isBlank())
			result = "Default message";
		else
			result = message;
		
		return "Hello from " + result;
	}

}
