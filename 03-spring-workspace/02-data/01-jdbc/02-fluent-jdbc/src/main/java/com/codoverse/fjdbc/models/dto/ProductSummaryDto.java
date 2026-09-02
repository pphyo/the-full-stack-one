package com.codoverse.fjdbc.models.dto;

import java.math.BigDecimal;

public record ProductSummaryDto(
		Long id,
		String name,
		BigDecimal price,
		String sku
	) {

}
