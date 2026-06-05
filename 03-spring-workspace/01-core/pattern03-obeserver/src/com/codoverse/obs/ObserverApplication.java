package com.codoverse.obs;

public class ObserverApplication {
	
	void main() {
		
		YouTubeChannel javaChannel = new YouTubeChannel();
		YouTubeChannel jsChannel = new YouTubeChannel();
		YouTubeChannel pyChannel = new YouTubeChannel();
		
		Observer user1 = new UserSubscriber("Aung Aung");
		Observer user2 = new UserSubscriber("Mg Mg");
		Observer user3 = new UserSubscriber("Su Su");
		
		javaChannel.subscribe(user1);
		javaChannel.subscribe(user2);
		
		jsChannel.subscribe(user1);
		jsChannel.subscribe(user3);
		
		pyChannel.subscribe(user1);
		pyChannel.subscribe(user3);
		
		javaChannel.uploadVideo("Java 25 new features");
		
		jsChannel.uploadVideo("Sugar feautres of DOM");
		
		javaChannel.unSubscribe(user2);
		
		javaChannel.uploadVideo("Amazing Virtual Thread");
		
	}

}
