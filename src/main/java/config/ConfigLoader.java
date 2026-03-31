package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FrameworkConstants;

public class ConfigLoader {
	private static Properties prop;
	private static ConfigLoader configLoad;

	private ConfigLoader() { //To avoid creation of multiple instances of Configloader in real time framework, Same config shared across the whole framework

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_Path);
			prop.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load the config file", e);
		}
	}

	public static ConfigLoader getInstance() { // when it is called, instance will be created only once, next time onwards if we call getInstance(), we will use the same reference of configloader 

		if (configLoad == null) {
			configLoad = new ConfigLoader();
		}
		return configLoad;
	}
	public String getUrl() {
		return prop.getProperty("URL");
	}
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getValue(String key) {
		return prop.getProperty(key);
	}

}



//class ends
