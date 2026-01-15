package tech.codoverse;

public class ExceptionCallStack {
	
	public void one() {
		two();
	}
	
	public void two() {
		try {
			three();
		} catch(Exception e) {
			IO.println("Handle in two.");
		}
	}
	
	public void three() {
		four();
	}
	
	public void four() {
		IO.println(4 / 0);
	}

}
