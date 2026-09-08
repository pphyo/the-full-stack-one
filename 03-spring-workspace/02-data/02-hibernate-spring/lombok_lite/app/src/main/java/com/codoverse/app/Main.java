package com.codoverse.app;

public class Main {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Declared constructors on Person.class: ");
		
		for(var ctor : Person.class.getDeclaredConstructors()) {
			System.out.println("  " + ctor);
		}
		
		var allArgsCtor = Person.class.getDeclaredConstructor(String.class, int.class, double.class);
		
		Person p = allArgsCtor.newInstance("Ada Lovelace", 20, 1.68);
		p.setActive(true);
		
		System.out.println();
		System.out.println("Instantiated via the woven constructor:");
		System.out.println("  " + p);
	}

}
