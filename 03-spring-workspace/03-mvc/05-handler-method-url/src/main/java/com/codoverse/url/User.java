package com.codoverse.url;

public class User {
	
	private String name;
	private Gender gender;
	private int age;
	
	public User(String name, Gender gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

	public enum Gender {
		Male, Female
	}

}
