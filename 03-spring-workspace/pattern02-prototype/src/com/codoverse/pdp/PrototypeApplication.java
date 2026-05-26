package com.codoverse.pdp;

public class PrototypeApplication {
	
	void main() {
		
		var kb1 = new Keyboard("RGB Flat", "Pale Green", 200);
		var kb2 = kb1.clone();
		var kb3 = kb2.clone();
		
		IO.println(kb1);
		IO.println(kb2);
		IO.println(kb3);
		
	}

}
