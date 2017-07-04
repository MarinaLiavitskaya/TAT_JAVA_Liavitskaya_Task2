package com.epam.liavitskaya.main.dao.worker;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	
	static Properties properties;
	static InputStream input = null;

	public static Properties getProperties(String propertyFileName) {
		properties = new Properties();
		input = new PropertyLoader().getClass().getClassLoader().getResourceAsStream(propertyFileName);
		try {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("PropertyLoader - IOException");
		}
		System.out.println(properties.getProperty("url"));
		return properties;
	}
}
