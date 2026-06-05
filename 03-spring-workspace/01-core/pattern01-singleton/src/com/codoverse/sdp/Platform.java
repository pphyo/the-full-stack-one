package com.codoverse.sdp;

public class Platform {
	
	private String name;
	
	private static Platform INSTANCE;
	
	private Platform(String name) {
		this.name = name;
	}
	
	public static Platform getInstance(String name) {
		if(null == INSTANCE) {
			INSTANCE = new Platform(name);
		}
		return INSTANCE;
	}
	
	public String name() {
		return name;
	}

}
