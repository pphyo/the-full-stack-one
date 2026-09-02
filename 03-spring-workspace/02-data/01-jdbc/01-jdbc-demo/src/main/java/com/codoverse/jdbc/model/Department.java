package com.codoverse.jdbc.model;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Department {
	
	@Id
	private Long id;
	private String name;

	public Department(String name) {
		this.name = name;
	}

}
