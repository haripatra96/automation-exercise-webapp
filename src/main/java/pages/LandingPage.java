package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.ConfigLoader;

public class LandingPage extends BasePage{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(.,'Home')]")
	private WebElement homeButtn;
	
	@FindBy(xpath="//a[contains(.,'Products')]")
	private WebElement products;
	
	@FindBy(xpath = "//a[contains(.,' Signup / Login')]")
	public WebElement signUp;
	
	
	public void goTo() {
		driver.get(ConfigLoader.getInstance().getUrl());
	}
	
	public LoginPage clickLogin() {
		signUp.click();
		return new LoginPage(driver);
	
	}
	
	public ProductPage clickProducts() {
		products.click();
		return new ProductPage(driver);
	}
}
