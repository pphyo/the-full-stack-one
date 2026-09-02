package com.codoverse.fjdbc.models;

import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCT_DETAILS")
public record ProductDetail(
		String remark,
		String sku
	) {

}
