package tech.codoverse;

public class Card {
	
	public <E> Card(E element) {
		System.out.println(element.getClass().getName());
	}

}
