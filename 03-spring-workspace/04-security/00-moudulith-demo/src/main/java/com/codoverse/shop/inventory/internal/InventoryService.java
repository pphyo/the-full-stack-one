package com.codoverse.shop.inventory.internal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codoverse.shop.inventory.InventoryManagement;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class InventoryService implements InventoryManagement {
	
	private final InventoryRepository repository;

	@Override
	@Transactional
	public void reserve(String productCode, int quantity) {
		var item = repository.findByProductCode(productCode)
							.orElseThrow(() -> new IllegalArgumentException("Product not found!"));
		
		item.reserve(quantity);
	}

}
