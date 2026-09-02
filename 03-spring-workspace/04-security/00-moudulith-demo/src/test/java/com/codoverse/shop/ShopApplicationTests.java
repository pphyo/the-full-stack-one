package com.codoverse.shop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class ShopApplicationTests {

	@Test
	void printModules() {
		ApplicationModules modules = ApplicationModules.of(ShopApplication.class);
		modules.forEach(IO::println);
	}

}
