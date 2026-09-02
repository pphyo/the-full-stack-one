package com.codoverse.shop.order.internal;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

	@Id
	private UUID id;

	private String productCode;
	private int quantity;
	private String customerEmail;

	OrderEntity(String productCode, int quantity, String customerEmail) {
		id = UUID.randomUUID();
		this.productCode = productCode;
		this.quantity = quantity;
		this.customerEmail = customerEmail;
	}

}
