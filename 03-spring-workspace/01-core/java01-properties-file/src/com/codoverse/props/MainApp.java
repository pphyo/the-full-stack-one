package com.codoverse.props;

import java.time.LocalDate;

public class MainApp {
	
	void main() {
		String releaseDateStr = PropertyLoader.get("app.release.date");
		LocalDate ld = LocalDate.parse(releaseDateStr);
		IO.println(ld);
	}

}
