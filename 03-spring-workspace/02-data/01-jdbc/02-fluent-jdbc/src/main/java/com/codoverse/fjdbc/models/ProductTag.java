package com.codoverse.fjdbc.models;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCT_TAGS")
public record ProductTag(
		AggregateReference<Tag, Long> tagId
	) {
}
