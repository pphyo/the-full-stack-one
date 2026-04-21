package com.codoverse;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MultiLangagueApp {
	
	void main() {
		var mmLocale = new Locale.Builder()
						.setRegion("MM")
						.setLanguage("my")
						.build();
		
//		var caLocale = new Locale.Builder()
//						.setRegion("CA")
//						.setLanguage("fr")
//						.build();

		ResourceBundle rb = ResourceBundle.getBundle("messages", mmLocale);
		
		IO.println(MessageFormat.format(rb.getString("greeting"), "Mg Mg"));
	}

}
