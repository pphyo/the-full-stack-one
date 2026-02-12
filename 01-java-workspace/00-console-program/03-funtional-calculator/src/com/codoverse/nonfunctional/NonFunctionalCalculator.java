package com.codoverse.nonfunctional;

import com.codoverse.Operator;

public class NonFunctionalCalculator {
	
	public double operate(double a, double b, Operator operator) {
		return switch(operator) {
			case ADDITION -> add(a, b);
			case SUBSTRACTION -> substract(a, b);
			case MULTIPLICATION -> multiply(a, b);
			case DIVISION -> divide(a, b);
			default -> throw new IllegalArgumentException();
		};
	}
	
	private double add(double a, double b) {
		return a + b;
	}

	private double substract(double a, double b) {
		return a - b;
	}

	private double multiply(double a, double b) {
		return a * b;
	}

	private double divide(double a, double b) {
		return a / b;
	}
}
