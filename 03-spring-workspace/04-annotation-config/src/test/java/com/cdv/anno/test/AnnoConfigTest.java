package com.cdv.anno.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codoverse.anno.AnnoConfig;
import com.codoverse.anno.bean.ControllerBean;
import com.codoverse.anno.bean.RepositoryBean;
import com.codoverse.anno.bean.ServiceBean;
import com.codoverse.anno.generic.ComponentBean;
import com.codoverse.anno.generic.DefaultBean;

public class AnnoConfigTest {
	
	@Test
	void test3() {
		
		try(var ctx = new AnnotationConfigApplicationContext(AnnoConfig.class)) {
			
			assertEquals("Hello from component bean", ctx.getBean(comp).getComponent());
			
			assertThrows(NoSuchBeanDefinitionException.class, 
					() -> ctx.getBean(def));
			
			assertEquals("Hello from service bean", ctx.getBean(serv).getService());
			
			assertEquals("Hello from controller bean", 
						ctx.getBean(cont).getController());
			
			assertEquals("Hello from repository bean", 
					ctx.getBean(repo).getRepository());
		}
		
	}
	
	@Test
	@Disabled
	void test2() {
		
		try(var ctx = new AnnotationConfigApplicationContext("com.codoverse.anno.generic")) {
			
			assertEquals("Hello from component bean", ctx.getBean(comp).getComponent());
			
			assertEquals("Hello from default bean", 
					ctx.getBean(def).getDefault());
			
			assertThrows(NoSuchBeanDefinitionException.class, 
					() -> ctx.getBean(cont));
			
			assertThrows(NoSuchBeanDefinitionException.class, 
					() -> ctx.getBean(repo));
			
			assertThrows(NoSuchBeanDefinitionException.class, 
					() -> ctx.getBean(serv));
		}
		
	}
	
	@Test
	@Disabled
	void test1() {
		
		try(var ctx = new AnnotationConfigApplicationContext("com.codoverse.anno.bean")) {
			
			assertEquals("Hello from service bean", ctx.getBean(serv).getService());
			
			assertEquals("Hello from controller bean", 
						ctx.getBean(cont).getController());
			
			assertEquals("Hello from repository bean", 
					ctx.getBean(repo).getRepository());
			
			assertThrows(NoSuchBeanDefinitionException.class, 
					() -> ctx.getBean(def));
			
			assertThrows(NoSuchBeanDefinitionException.class, 
					() -> ctx.getBean(comp));
		}
		
	}
	
	static Class<ComponentBean> comp = ComponentBean.class;
	static Class<ControllerBean> cont = ControllerBean.class;
	static Class<RepositoryBean> repo = RepositoryBean.class;
	static Class<ServiceBean> serv = ServiceBean.class;
	static Class<DefaultBean> def = DefaultBean.class;

}
