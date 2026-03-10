package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	
	@FindBy (xpath="//label[text()='Title']/following-sibling::div//input[@value='Mr']")
	WebElement Mr_title;
	@FindBy (xpath="//label[text()='Title']/following-sibling::div//input[@value='Mrs']")
	WebElement Mrs_title;
	@FindBy (id="password")
	WebElement passwordTxt;
	
	@FindBy (id ="first_name")
	WebElement firstNameTxt;
	
	@FindBy (id ="last_name")
	WebElement lastElementTxt;
	
	@FindBy (id ="address1")
	WebElement addressTxt;
	
	@FindBy (id ="state")
	WebElement statetxt;
	
	@FindBy (id ="city")
	WebElement CityTxt;
	
	@FindBy (id ="zipcode")
	WebElement zipTxt;
	
	@FindBy (id ="mobile_number")
	WebElement mobileNmbrTxt;
	
	@FindBy (xpath="//button[@type='submit' and @data-qa ='create-account']")
	WebElement create_account_Btn;
	
	@FindBy (xpath="//h2[@data-qa='account-created']")
	WebElement account_created;

	
	public String succesFulSignup(String gender,
			String password, String firstName, String lastName,
			String Address, String state, String city, String zipcode, String mobile) {
		
		if(gender.equalsIgnoreCase("Male")) {
			Mr_title.click();
		} else {
			Mrs_title.click();
		}
		passwordTxt.sendKeys(password);
		firstNameTxt.sendKeys(firstName);
		lastElementTxt.sendKeys(lastName);
		addressTxt.sendKeys(Address);
		statetxt.sendKeys(state);
		CityTxt.sendKeys(city);
		zipTxt.sendKeys(zipcode);
		mobileNmbrTxt.sendKeys(mobile);
		create_account_Btn.click();
		
		return account_created.getText();
		
		
	}
}
