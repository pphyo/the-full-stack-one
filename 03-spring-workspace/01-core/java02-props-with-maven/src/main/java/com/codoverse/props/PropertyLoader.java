package com.codoverse.props;

import java.util.Properties;

public class PropertyLoader {
	
	private static Properties props;
	
	static {
		try {
			props = new Properties();
			props.load(PropertyLoader.class.getResourceAsStream("app.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String propKey) {
		return props.getProperty(propKey);
	}

}
