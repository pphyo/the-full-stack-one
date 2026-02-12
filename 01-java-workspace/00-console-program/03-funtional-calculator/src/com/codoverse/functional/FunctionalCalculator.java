package com.codoverse.functional;

import java.util.function.BinaryOperator;
import java.util.function.Function;

import com.codoverse.Operator;

public class FunctionalCalculator {
	
	public Function<Operator, BinaryOperator<Double>> operate() {
		// (a, b) -> a + b is BinaryOperator's lambda
		// this is Function interface lambda
		return ope -> switch(ope) {
			case ADDITION -> (a, b) -> a + b;
			case SUBSTRACTION -> (a, b) -> a - b;
			case MULTIPLICATION -> (a, b) -> a * b;
			case DIVISION -> (a, b) -> a / b;
			default -> throw new IllegalArgumentException();
		};
	}

}
