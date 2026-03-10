package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait webWait;
	
	protected BasePage() {
		this.driver = DriverManager.getdriver();
		this.webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
		
	}
	
	public void waitForApperElement(WebElement byLocator) {
		webWait.until(ExpectedConditions.visibilityOf(byLocator));
	}
	
}
