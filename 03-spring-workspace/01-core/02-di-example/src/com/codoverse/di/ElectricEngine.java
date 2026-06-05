package com.codoverse.di;

public class ElectricEngine implements Engine {

	@Override
	public void start() {
		IO.println("Electric engine is started.");
	}

}
