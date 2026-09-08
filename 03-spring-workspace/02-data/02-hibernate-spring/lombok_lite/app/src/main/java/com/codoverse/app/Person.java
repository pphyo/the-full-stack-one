package com.codoverse.app;

import com.codoverse.asm.annotations.CustomArgsConstructor;
import com.codoverse.asm.annotations.OfConstructor;

@CustomArgsConstructor
public class Person {

	@OfConstructor(order = 0)
	private String name;

	@OfConstructor(order = 1)
	private int age;

	@OfConstructor(order = 2)
	private double heightMeters;

	private boolean active;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getHeightMeters() {
		return heightMeters;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Person{name='%s', age=%d, heightMeters=%.2f, active=%b".formatted(name, age, heightMeters, active);
	}

}
