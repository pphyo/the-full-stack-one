package com.codoverse.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigApp {
	
	void main() {
		
		// init spring framework(IoC, Context) with xml config file
		var ctx = new ClassPathXmlApplicationContext("application.xml");
		
		// call the bean we want
		var bean = ctx.getBean(MessageService.class);
		IO.println(bean.say());
		
		((AbstractApplicationContext)ctx).close();
		
	}

}
