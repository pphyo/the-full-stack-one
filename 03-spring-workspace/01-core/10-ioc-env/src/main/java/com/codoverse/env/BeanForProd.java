package com.codoverse.env;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(Constants.PROD)
public class BeanForProd {

	public void run() {
		IO.println("This is bean for production mode.");
	}
	
}
