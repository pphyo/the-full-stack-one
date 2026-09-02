package com.codoverse.shop.inventory.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InventoryItem {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String productCode;
	private int availableQuantity;
	
	InventoryItem(String productCode, int availableQuantity) {
		super();
		this.productCode = productCode;
		this.availableQuantity = availableQuantity;
	}
	
	void reserve(int quantity) {
		if(quantity <= 0 ) {
			throw new IllegalArgumentException("Quantity must be grater than zero!");
		}
		
		if(availableQuantity < quantity) {
			throw new IllegalArgumentException("Insufficent inventory!");
		}
		
		availableQuantity -= quantity;
	}

}
