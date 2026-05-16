package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public ConfigReader() {

		prop = new Properties();

		InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");

		if (input == null) {

			throw new RuntimeException("config.properties not found in resources folder");

		}

		try {

			prop.load(input);

		} catch (IOException e) {
			
			e.getMessage();

			e.printStackTrace();

		}

	}

	public static String get(String key) {

		return prop.getProperty(key);

	}

}
