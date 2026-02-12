package com.codoverse;

public enum Operator {
	
	ADDITION('+'),
	SUBSTRACTION('-'),
	MULTIPLICATION('\u00D7'),
	DIVISION('\u00F7');
	
	private final char sign;
	
	private Operator(final char sign) {
		this.sign = sign;
	}
	
	public final char sign() {
		return sign;
	}

}
