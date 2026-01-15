package tech.codoverse;

public class OverridingException {

}

class SuperException {
	
	public void doException() {
		
	}
	
}

class SubException extends SuperException {
	
	@Override
	public void doException() {
	}
	
}