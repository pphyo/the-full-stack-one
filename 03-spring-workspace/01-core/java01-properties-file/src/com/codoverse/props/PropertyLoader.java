package com.codoverse.props;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader {
	
	private static Properties props;
	
	static {
		try {
			props = new Properties();
			props.load(new FileInputStream(new File("app.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String propKey) {
		return props.getProperty(propKey);
	}

}
