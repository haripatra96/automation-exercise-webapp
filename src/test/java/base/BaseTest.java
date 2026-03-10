package base;



import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import config.ConfigLoader;
import driver.DriverFactory;
import driver.DriverManager;
import pages.LandingPage;
import reports.ExtentReportManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	
	
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage setup() {
		DriverFactory.initDriver();
		driver = DriverManager.getdriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
				return landingPage;
		
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		if(DriverManager.getdriver() != null) {
			DriverManager.getdriver().quit();
			DriverManager.removeDriver();
			
		}
	}
	
	@BeforeSuite
	public void beforeSuiteActions() {
		ExtentReportManager.initReports();
		ConfigLoader.getInstance();
	}
	
	
	@AfterSuite
	public void afterSuiteActions() {
		ExtentReportManager.flushReport();
		
	}

}
