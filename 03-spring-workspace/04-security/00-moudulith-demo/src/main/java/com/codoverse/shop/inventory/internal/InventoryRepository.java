package com.codoverse.shop.inventory.internal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {

	Optional<InventoryItem> findByProductCode(String productCode);
	
}
