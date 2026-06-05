package com.codoverse.di.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codoverse.di.DIConfig;
import com.codoverse.di.MessageGateway;
import com.codoverse.di.OrderService;

public class DITest {
	
	@Test
	void test_for_annotation_base() {
		try(var context = new AnnotationConfigApplicationContext(DIConfig.class)) {
			var bean = context.getBean(OrderService.class);
			bean.completeOrder();
			
			var gateway = context.getBean(MessageGateway.class);
			gateway.showBean();
		}
	}

}
