package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement loginEmail;
	
	@FindBy (xpath="//input[@data-qa='login-password']")
	WebElement loginPassword;
	
	@FindBy (xpath="//button[@data-qa='login-button']")
	WebElement loginBttn;
	
	@FindBy (xpath= "//p[text()='Your email or password is incorrect!']")
	WebElement errorMsg;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement signUpEmail;
	
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement signUpName;
	
	@FindBy (xpath="//button[@data-qa='singup-button']")
	WebElement signUpBttn;
	
	public void login(String username, String password) {
		loginEmail.sendKeys(username);
		loginPassword.sendKeys(password);
		loginBttn.click();
	}
	
	public void logininvalid(String username, String password) {
		loginEmail.sendKeys(username);
		loginPassword.sendKeys(password);
		loginBttn.click();
	}
	public String isFailed() {
			return errorMsg.getText();
	}
	public SignUpPage signUp(String name, String email) {
		signUpName.sendKeys(name);
		signUpEmail.sendKeys(email);
		signUpBttn.click();
		return new SignUpPage();
	}
}
