package com.epam.liavitskaya.main.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.epam.liavitskaya.main.dao.worker.PropertyLoader;

public class ConfigUtil {
	private static ConfigUtil instance = null;
	private Properties properties;

	private ConfigUtil() throws IOException {
		properties = new Properties();
		InputStream input = new PropertyLoader().getClass().getClassLoader()
				.getResourceAsStream("library_db.properties");
		try {
			properties.load(input);
		} catch (IOException e) {
			// log
			e.printStackTrace();
		}

	}

	public static ConfigUtil getInstance() {
		if (instance == null) {
			try {
				instance = new ConfigUtil();
			} catch (IOException e) {
				throw new RuntimeException("Problems occured during loading DB Properties!");
			}
		}
		return instance;
	}

	public Properties getPropertiesValues() {
		return properties;
	}
}
// package com.pctrade.price.utils;
//
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.Properties;
//
// public class ConfigUtils {
// public static Properties loadDbProperties() {
// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
// InputStream is = classLoader.getResourceAsStream("app.properties");
// Properties properties = new Properties();
// try {
// properties.load(is);
// } catch (IOException e) {
// throw new RuntimeException("Problems occured during loading DB Properties!");
// }
// return properties;
// }
// }
