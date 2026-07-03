package com.codoverse.scope.counter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestCounter {

	private int count = 0;
	
	public int incrementAndGet() {
		return ++count;
	}
	
}
