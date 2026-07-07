package com.codoverse.except.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductForm {
	
	@NotBlank(message = "Product name is required!")
	private String name;
	
	@Min(value = 100, message = "Price must be at least 100.")
	private BigDecimal price;

}
