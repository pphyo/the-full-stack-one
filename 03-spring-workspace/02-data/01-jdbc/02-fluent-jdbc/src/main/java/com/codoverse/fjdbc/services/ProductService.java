package com.codoverse.fjdbc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codoverse.fjdbc.except.ResourceNotFoundException;
import com.codoverse.fjdbc.models.Product;
import com.codoverse.fjdbc.models.dto.ProductSummaryDto;
import com.codoverse.fjdbc.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository repo;
	
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public List<Product> findAllProduct() {
		return repo.findAll();
	}
	
	public Product findById(Long id) {
		return repo.findById(id).orElseThrow(() -> ResourceNotFoundException.notFound(id));
	}
	
	public List<ProductSummaryDto> findProductSummaries() {
		return repo.findSummaries();
	}

}
