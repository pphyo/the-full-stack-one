package com.codoverse.service;

public class ServiceFromDiff {

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