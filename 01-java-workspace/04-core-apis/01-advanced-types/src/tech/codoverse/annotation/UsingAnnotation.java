package tech.codoverse.annotation;

public class UsingAnnotation {
	
	@Info("Value One")
	private String valueOne;
	
	@Info
	private String valueTwo;
	
	private String nothing;

	public String getValueOne() {
		return valueOne;
	}

	public String getValueTwo() {
		return valueTwo;
	}

	public String getNothing() {
		return nothing;
	}

}
