package com.codoverse;

import com.codoverse.functional.FunctionalCalculator;
import com.codoverse.nonfunctional.NonFunctionalCalculator;

public class CalculatorApplication {
	
	void main() {
		runForFunctional();
	}
	
	void runForFunctional() {
		double x = 10;
		double y = 4;
		Operator ope = Operator.SUBSTRACTION;
		
		double result = new FunctionalCalculator().operate().apply(ope).apply(x, y);
		IO.println("%.2f %s %.2f = %.2f".formatted(x, ope.sign(), y, result));
	}
	
	void runForNonFunctional() {
		double x = 10;
		double y = 4;
		Operator ope = Operator.ADDITION;
		
		double result = new NonFunctionalCalculator().operate(x, y, ope);
		
		IO.println("%.2f %s %.2f = %.2f".formatted(x, ope.sign(), y, result));
	}

}
