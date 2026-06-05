package com.codoverse.anno.bean;

import org.springframework.stereotype.Controller;

@Controller
public class ControllerBean {
	
	public String getController() {
		return "Hello from controller bean";
	}

}
