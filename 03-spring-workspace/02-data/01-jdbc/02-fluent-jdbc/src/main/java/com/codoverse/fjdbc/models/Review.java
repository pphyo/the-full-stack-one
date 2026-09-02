package com.codoverse.fjdbc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("REVIEW")
public record Review(
		@Id
		Long id,
		String reviewerName,
		int rating
	) {

}
