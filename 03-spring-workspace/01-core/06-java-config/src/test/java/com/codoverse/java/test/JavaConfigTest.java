package com.codoverse.java.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codoverse.java.JavaConfig;
import com.codoverse.java.bean.ControllerBean;
import com.codoverse.java.bean.ServiceBean;

public class JavaConfigTest {
	
	@Test
	void test() {
		
		try(var ctx = new AnnotationConfigApplicationContext(JavaConfig.class)) {
			
			assertEquals("default message", ctx.getBean("messageBean", String.class));
			
			ctx.getBean("controllerBean", ControllerBean.class).runController();
			
			ctx.getBean("serviceBean", ServiceBean.class).runService();
			
		}
		
	}

}
