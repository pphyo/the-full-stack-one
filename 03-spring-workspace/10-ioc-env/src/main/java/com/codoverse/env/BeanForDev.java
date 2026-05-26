package com.codoverse.env;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(Constants.DEV)
public class BeanForDev {
	
	public void run() {
		IO.println("This is bean for development mode.");
	}

}
