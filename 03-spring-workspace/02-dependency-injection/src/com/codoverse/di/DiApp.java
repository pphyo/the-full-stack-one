package com.codoverse.di;

public class DiApp {
	
	void main() {
		Car car = new Car(new ElectricEngine());
		car.move();
	}

}
