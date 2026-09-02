package com.codoverse.fjdbc.models;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCTS")
public record Product(
		@Id
		Long id,
		String name,
		BigDecimal price,

		ProductDetail detail,
		
		@MappedCollection(idColumn = "PRODUCT_ID")
		Set<Review> reviews,
		
		@MappedCollection(idColumn = "PRODUCT_ID")
		Set<ProductTag> tags
	) {

}
