package com.codoverse.shop.order;

import java.time.Instant;
import java.util.UUID;

public record OrderPlaced(
		UUID orderId,
		String productCode,
		int quantity,
		String customerEmail,
		Instant placedAt
		) {

}
