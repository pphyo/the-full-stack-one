package com.codoverse.obs;

public class UserSubscriber implements Observer {
	
	private String userName;

	public UserSubscriber(String userName) {
		super();
		this.userName = userName;
	}

	@Override
	public void update(String videoTitle) {
		IO.println("Hey " + userName + ", new video alert! Go watch: " + videoTitle);
	}

}
