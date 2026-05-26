package com.codoverse.pdp;

public class Keyboard implements Cloneable {

	private String name;
	private String color;
	private double price;

	public Keyboard(String name, String color, double price) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public Keyboard clone() {
		return new Keyboard(name, color, price);
	}

}
