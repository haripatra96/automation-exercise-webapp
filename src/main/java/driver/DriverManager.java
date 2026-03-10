package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private DriverManager() {}
	
	public static WebDriver getdriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver webDriver) {
		driver.set(webDriver);
	}
	public static void removeDriver() {
		driver.remove();
	}

}
