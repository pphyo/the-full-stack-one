package com.codoverse.di;

public class Car {
	
	private final Engine engine;
	
	public Car(final Engine engine) {
		this.engine = engine;
	}
	
	public void move() {
		engine.start();
		IO.print("Car is moving...");
	}

}
