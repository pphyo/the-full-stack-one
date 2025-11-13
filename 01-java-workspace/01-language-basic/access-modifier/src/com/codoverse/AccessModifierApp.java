package com.codoverse;

import com.codoverse.service.ServiceFromDiff;

public class AccessModifierApp extends ServiceFromDiff {

	void main() {
		var sameService = new ServiceInSame();
		sameService.runPublic();
		sameService.runProtected();
		sameService.runPackagePrivate();
		// sameService.runPrivate();

		IO.println();

		// var diffService = new ServiceFromDiff();
		runPublic();
		runProtected();
		// runPackagePrivate();
		// runPrivate();

	}

}