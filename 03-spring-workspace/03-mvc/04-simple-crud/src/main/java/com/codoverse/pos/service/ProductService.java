package com.codoverse.pos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codoverse.pos.model.Product;

@Service
public class ProductService {
	
	private List<Product> pList = new ArrayList<>();
	private int idCounter = 1;
	
	public ProductService() {
		pList.add(new Product(idCounter++, "MacBook Air", 1000.0, "Electronics"));
		pList.add(new Product(idCounter++, "T-Shirt", 15.0, "Clothing"));
		pList.add(new Product(idCounter++, "Coffee Beans", 12.0, "Food"));
	}
	
	public void save(Product product) {
		if(product.getId() ==  null || product.getId() == 0) {
			product.setId(idCounter ++);
			pList.add(product);
		} else {
			var existingProduct = findById(product.getId());
			if(existingProduct != null) {
				existingProduct.setName(product.getName());
				existingProduct.setPrice(product.getPrice());
				existingProduct.setCategory(product.getCategory());
			}
		}
	}
	
	public void delete(Integer id) {
		pList.removeIf(p -> p.getId().equals(id));
	}
	
	public List<Product> search(String keyword) {
		if(keyword == null || keyword.trim().isBlank()) {
			return findAll();
		}
		
		String lower = keyword.toLowerCase();
		return pList.stream()
				.filter(p -> p.getName().toLowerCase().contains(lower) || p.getCategory().toLowerCase().contains(lower))
				.collect(Collectors.toList());
	}
	
	public List<Product> findAll() {
		return new ArrayList<>(pList);
	}
	
	public Product findById(Integer id) {
		return pList.stream()
					.filter(p -> p.getId().equals(id))
					.findFirst()
					.orElse(null);
	}

}
