package com.codoverse.obs;

// Publisher
public interface Subject {
	
	void subscribe(Observer observer);
	
	void unSubscribe(Observer observer);

	void notifyObservers();

}
