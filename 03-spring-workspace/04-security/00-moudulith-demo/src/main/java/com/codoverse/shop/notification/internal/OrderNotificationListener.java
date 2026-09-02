package com.codoverse.shop.notification.internal;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import com.codoverse.shop.order.OrderPlaced;

@Component
class OrderNotificationListener {
	
	@ApplicationModuleListener
	void on(OrderPlaced event) {
		IO.println("Send order confirmation to %s for order %s.".formatted(event.customerEmail(), event.orderId()));
	}

}
