package com.codoverse.scope.counter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionCounter {

	private int count = 0;
	
	public int incrementAndGet() {
		return ++count;
	}

}
