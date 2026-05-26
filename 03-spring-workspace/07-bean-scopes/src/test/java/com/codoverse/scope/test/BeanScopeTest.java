package com.codoverse.scope.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.csodoverse.scope.AppConfig;
import com.csodoverse.scope.IBean;

public class BeanScopeTest {
	
	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)) {

			var sBean1 = context.getBean("sgtBean", IBean.class);
			var sBean2 = context.getBean("sgtBean", IBean.class);

			assertTrue(isSingleton(sBean1, sBean2));
			
			var pBean1 = context.getBean("pttBean", IBean.class);
			var pBean2 = context.getBean("pttBean", IBean.class);
			
			assertTrue(isPrototype(pBean1, pBean2));
			
		}
	}
	
	private boolean isSingleton(IBean bean1, IBean bean2) {
		return bean1 == bean2;
	}
	
	private boolean isPrototype(IBean bean1, IBean bean2) {
		return bean1 != bean2;
	}

}
