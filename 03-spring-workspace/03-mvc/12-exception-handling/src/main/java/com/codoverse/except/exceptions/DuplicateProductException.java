package com.codoverse.except.exceptions;

@SuppressWarnings("serial")
public class DuplicateProductException extends RuntimeException {
	
	public DuplicateProductException(String message) {
		super(message);
	}

}
