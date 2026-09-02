package com.codoverse.fjdbc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.simple.JdbcClient;

import com.codoverse.fjdbc.models.Product;
import com.codoverse.fjdbc.repositories.ProductRepository;
import com.codoverse.fjdbc.services.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository repository;
	
	@Mock
	private JdbcClient jdbcClient;
	
	@InjectMocks
	private ProductService service;
	
	@Test
	void shouldSaveProductSuccessfully() {
		
		Product newProduct = new Product(null, "Keyboard", BigDecimal.valueOf(50), null, Collections.emptySet(), Collections.emptySet());
		Product savedProduct = new Product(10L, "Keyboard", BigDecimal.valueOf(50), null, Collections.emptySet(), Collections.emptySet());
		
		when(repository.save(newProduct)).thenReturn(savedProduct);
		
		Product result = service.saveProduct(newProduct);
		
		assertThat(result.id()).isEqualTo(10L);
		assertThat(result.name()).isEqualTo("Keyboard");
		verify(repository, times(1)).save(newProduct);
		
	}
	
}
