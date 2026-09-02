package com.codoverse.jdbc.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Employee {
	
	@Id
	private Long id;
	private String name;

	private Long departmentId;
	
	public Employee(String name) {
		this.name = name;
	}

}
