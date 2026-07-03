package com.codoverse.scope.counter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class ApplicationCounter {
	
	private int count = 0;
	
	public int incrementAndGet() {
		return ++count;
	}

}
