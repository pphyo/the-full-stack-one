package tech.codoverse;

public class MyResource implements AutoCloseable {
	
	public void read() throws MyException {
		throw new MyException("Error while reading data(Primary)");
	}
	
	@Override
	public void close() throws MyException {
		throw new MyException("Error while closing resource(Suppressed)");
	}

}
