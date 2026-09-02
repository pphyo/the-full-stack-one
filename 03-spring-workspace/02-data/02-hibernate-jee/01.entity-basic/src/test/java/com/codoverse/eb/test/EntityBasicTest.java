package com.codoverse.eb.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class EntityBasicTest {
	
	@Test
	void test() {
		
		Persistence.createEntityManagerFactory("entity-basic").close();
		
	}

}
