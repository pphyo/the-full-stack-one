package tech.codoverse;

@FunctionalInterface
public interface Greetable {
	
	String greet(String who);
	
	@Override
	boolean equals(Object obj);
	
	@Override
	String toString();
	
	@Override
	int hashCode();

}
