package com.codoverse;

import java.util.Optional;

public class OptionalApplication {
	
	void main() {
		run();
	}
	
	void run() {
		Optional<Integer> opt = Optional.ofNullable(11);
		
		IO.println(opt.filter(i -> i > 100).orElseThrow(() -> new IllegalArgumentException("Nothing")));
	}

}
