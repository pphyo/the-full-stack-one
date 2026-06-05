package com.cdv.mix.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codoverse.mix.Config;
import com.codoverse.mix.StereoBean;

public class MixConfigTest {
	
	@Test
	void test() {
		
		try(var context = new AnnotationConfigApplicationContext(Config.class)) {
			
			var msgBean = context.getBean(String.class);
			
			var stereoBean = context.getBean("stereoBean", StereoBean.class);
			
			IO.println(msgBean);
			IO.println(stereoBean.getBean());
			
		}
		
	}

}
