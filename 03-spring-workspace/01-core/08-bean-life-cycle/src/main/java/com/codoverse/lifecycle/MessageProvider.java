package com.codoverse.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MessageProvider implements BeanPostProcessor, InitializingBean, DisposableBean {
	
	public MessageProvider() {
		IO.println("Constructor is called.");
	}
	
	public void send(String message, String who) {
		IO.println("%s is sending to %who".formatted(message, who));
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		IO.println("MessageProvider's postProcessBeforeInitialization()");
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		IO.println("MessageProvider's postProcessAfterInitialization()");
		return bean;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		IO.println("afterPropertiesSet()");
	}
		
	public void initLifecycle() {
		IO.println("custom init method");
	}
	
	@PostConstruct
	public void postConstruct() {
		IO.println("@PostConstruct's init");
	}
	
	@Override
	public void destroy() throws Exception {
		IO.println("DisposableBean's destroy");
	}
	
	public void destroyLifecycle() {
		IO.println("custom destroy method");
	}
	
	@PreDestroy
	public void preDestroy() {
		IO.println("@PreDestroy's destroy");
	}

}
