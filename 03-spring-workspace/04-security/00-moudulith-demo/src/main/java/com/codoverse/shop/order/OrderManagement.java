package com.codoverse.shop.order;

import java.util.UUID;

public interface OrderManagement {
	
	UUID placeOrder(String productCode, int quantity, String customerEmail);

}
