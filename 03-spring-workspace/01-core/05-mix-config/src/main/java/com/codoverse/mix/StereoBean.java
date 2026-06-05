package com.codoverse.mix;

import org.springframework.stereotype.Component;

@Component
public class StereoBean {

	private String message;

	public StereoBean(String message) {
		this.message = message;
	}

	public String getBean() {
		return "Hey this is " + message;
	}

}
