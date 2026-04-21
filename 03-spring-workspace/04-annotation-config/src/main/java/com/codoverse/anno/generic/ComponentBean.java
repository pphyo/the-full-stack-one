package com.codoverse.anno.generic;

import org.springframework.stereotype.Component;

@Component
public class ComponentBean {
	
	public String getComponent() {
		return "Hello from component bean";
	}

}
