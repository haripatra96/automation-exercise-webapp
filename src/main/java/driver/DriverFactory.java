package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//import config.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static void initDriver() {

//		String broswer = ConfigLoader.getInstance().getBrowser(); if we need the browser inform from property
		
		
		String browser = System.getProperty("browser", "chrome"); // passing the browser value through cmd prompt, if no value is passed chrome is the default
		boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));// passing the Headless value through cmd prompt, if no value is passed false is the default
		WebDriver driver;

		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions cHoption = new ChromeOptions(); //creation of Chrome option to pass chrome argument
			if (headless) {
				cHoption.addArguments("--headless=new");
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(cHoption);
			break;
		case "firefox":
			FirefoxOptions ffOption = new FirefoxOptions(); // Firefox argument
			if (headless) {
				ffOption.addArguments("--headless");
			}
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(ffOption);
			break;
		case "edge":
			EdgeOptions eGOptions = new EdgeOptions(); // Edge Argument
			if (headless) {
				eGOptions.addArguments("--headless");
			}
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(eGOptions);
			break;
		default:
			throw new RuntimeException("Give the correct browser name " + browser);

		}

		driver.manage().window().maximize();
		DriverManager.setDriver(driver);
	}

	public static void unload() {
		DriverManager.removeDriver();
	}

}
