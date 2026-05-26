package com.codoverse.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfig {
	
	@Bean(initMethod = "initLifecycle", destroyMethod = "destroyLifecycle")
	public static MessageProvider messageProvider() {
		return new MessageProvider();
	}

}
