package com.codoverse.anno.bean;

import org.springframework.stereotype.Service;

@Service
public class ServiceBean {
	
	public String getService() {
		return "Hello from service bean";
	}

}
