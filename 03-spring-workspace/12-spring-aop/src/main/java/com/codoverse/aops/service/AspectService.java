package com.codoverse.aops.service;

import org.springframework.stereotype.Service;

@Service
public class AspectService {

	public void withVoid() {
		IO.println("AspectService => withVoid()");
		throw new IllegalArgumentException("Throwing exception from AspectService");
	}

	public String withString(String string) {

		IO.println("AspectService => withString()");
		
		if(string == null || string.isBlank()) {
			throw new IllegalArgumentException("String is emtpy!");
		}

		return "return value: " + string;
	}

}
