package com.codoverse.shop.order.internal;

import java.time.Instant;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codoverse.shop.inventory.InventoryManagement;
import com.codoverse.shop.order.OrderManagement;
import com.codoverse.shop.order.OrderPlaced;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class OrderService implements OrderManagement {
	
	private final OrderRepository orderRepository;
	private final InventoryManagement inventory;
	private final ApplicationEventPublisher eventPublisher;
	

	@Override
	@Transactional
	public UUID placeOrder(String productCode, int quantity, String customerEmail) {
		
		inventory.reserve(productCode, quantity);
		
		OrderEntity order = new OrderEntity(productCode, quantity, customerEmail);
		
		orderRepository.save(order);
		
		eventPublisher.publishEvent(new OrderPlaced(
					order.getId(),
					productCode,
					quantity,
					customerEmail,
					Instant.now()));
		
		return order.getId();
		
	}

}
