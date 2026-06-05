package com.codoverse.obs;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject (The publisher)
public class YouTubeChannel implements Subject {
	
	// Keeps track of all subscribers
	private List<Observer> subscribers = new ArrayList<>();
	private String latestVideoTitle;

	@Override
	public void subscribe(Observer observer) {
		subscribers.add(observer);
	}

	@Override
	public void unSubscribe(Observer observer) {
		subscribers.remove(observer);
	}

	// Sends the notification to all registered observers
	@Override
	public void notifyObservers() {
		
		for(Observer observer : subscribers) {
			observer.update(latestVideoTitle);
		}
		
	}
	
	public void uploadVideo(String title) {
		this.latestVideoTitle = title;
		
		IO.println("\n[SYSTEM] --- Channel uploaded a new video: " + title + " ---");
		
		notifyObservers(); // main part
	}

}
