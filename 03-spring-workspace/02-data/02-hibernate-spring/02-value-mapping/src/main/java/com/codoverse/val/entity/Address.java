package com.codoverse.val.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 50)
	private String street;
	
	@Column(nullable = false, length = 50)
	private String state;
	
	@Column(nullable = false, length = 50)
	private String country;
	
	@Column(nullable = false, length = 20)
	private String postalCode;

}
