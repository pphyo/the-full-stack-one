package com.codoverse.shop.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.PublishedEvents;
import org.springframework.modulith.test.PublishedEvents.TypedPublishedEvents;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.codoverse.shop.inventory.InventoryManagement;

@ApplicationModuleTest
public class OrderModuleTests {

	@Autowired
	OrderManagement orderManagement;
	
	@MockitoBean
	InventoryManagement inventoryManagement;
	
	@Test
	void publishesOrderPlacedEvent(PublishedEvents events) {
		UUID orderId = orderManagement.placeOrder("IPHONE-001", 2, "customer@example.com");
		
		TypedPublishedEvents<OrderPlaced> matchingEvents = events.ofType(OrderPlaced.class)
								.matchingValue(OrderPlaced::orderId, orderId);
		
		assertThat(matchingEvents).hasSize(1);
	}
	
}
