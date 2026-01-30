package tech.codoverse;

public class BoundedBox<T> {
	
	private T t;
	
	public BoundedBox(T t) {
		this.t = t;
	}
	
	public <U extends Number> void inspect(U u) {
		IO.println(t.getClass().getName());
		IO.println(u.getClass().getName());
	}

}
