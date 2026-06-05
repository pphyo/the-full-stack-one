package com.codoverse.pos.model;

public class Product {

	private Integer id;
	private String name;
	private Double price;
	private String category;

	public Product() {
	}

	public Product(Integer id, String name, Double price, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
