package com.codoverse.cors.entity;

import java.time.LocalDate;

public class Player {

	private int id;
	private String name;
	private LocalDate dob;
	private double wage;
	private double height;
	private int shirt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getShirt() {
		return shirt;
	}

	public void setShirt(int shirt) {
		this.shirt = shirt;
	}

}
