package com.codoverse.sdp;

public class SingletonApplication {
	
	void main() {
		var pf1 = Platform.getInstance("ios");
		var pf2 = Platform.getInstance("ios");
		var pf3 = Platform.getInstance("android");
		
		IO.println(pf1);
		IO.println(pf2);
		IO.println(pf1 == pf3);
	}

}
