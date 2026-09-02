package com.codoverse.col.entity;

import java.math.BigDecimal;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "products")
public class Product {
	
	@Id
	private Long id;

	private String name;
	private BigDecimal price;
	

}


// CustomFieldConstructor