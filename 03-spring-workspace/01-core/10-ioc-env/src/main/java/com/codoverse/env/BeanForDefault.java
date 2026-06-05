package com.codoverse.env;

import org.springframework.stereotype.Component;

@Component
public class BeanForDefault {
	
	public void run() {
		IO.println("This is bean for default mode.");
	}

}
