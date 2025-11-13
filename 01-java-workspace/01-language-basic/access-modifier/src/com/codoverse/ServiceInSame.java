package com.codoverse;

public class ServiceInSame {

	public void runPublic() {
		IO.println(getClass().getName() + " runPublic().");
	}

	protected void runProtected() {
		IO.println(getClass().getName() + " runProtected().");
	}

	void runPackagePrivate() {
		IO.println(getClass().getName() + " runPackagePrivate().");
	}

	private void runPrivate() {
		IO.println(getClass().getName() + " runPrivate().");
	}

}