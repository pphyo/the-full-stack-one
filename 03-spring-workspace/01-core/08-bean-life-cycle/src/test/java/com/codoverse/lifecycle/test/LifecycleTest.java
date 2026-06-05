package com.codoverse.lifecycle.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codoverse.lifecycle.LifecycleConfig;

public class LifecycleTest {
	
	@Test
	void test() {
		var context = new AnnotationConfigApplicationContext(LifecycleConfig.class);
			
		context.close();
	}

}
