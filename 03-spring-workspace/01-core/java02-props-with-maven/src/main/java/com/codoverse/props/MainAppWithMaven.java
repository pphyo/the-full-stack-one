package com.codoverse.props;

import static com.codoverse.props.PropertyLoader.get;

public class MainAppWithMaven {
	
	void main() {
		IO.println(get("app.version"));
	}

}
