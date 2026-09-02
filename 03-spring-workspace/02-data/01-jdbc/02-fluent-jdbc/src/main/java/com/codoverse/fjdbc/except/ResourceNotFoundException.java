package com.codoverse.fjdbc.except;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private ResourceNotFoundException(String message) {
		super(message);
	}
	
	public static ResourceNotFoundException notFound(Long id) {
		return new ResourceNotFoundException("Resource not found with ID: " + id);
	}

}
