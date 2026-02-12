package tech.codoverse;

public class Reference {
	
	public Reference() {
		IO.println("Constructor reference");
	}
	
	public static int executeStatic(int a, int b) {
		return a + b;
	}
	
	public String hello(String name) {
		return "Hello " + name;
	}

}
