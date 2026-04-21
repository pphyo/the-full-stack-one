package com.codoverse.ts;

public class MutableCounter {
	
	private int count = 0; // Mutable state
	
	public void increment() {
		count ++;
	}
	
	public int getCount() {
		return count;
	}

}
