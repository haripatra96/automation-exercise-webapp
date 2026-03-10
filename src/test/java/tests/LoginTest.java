package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigLoader;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	
	
	@Test
	public void validLogin() {
		LoginPage loP =landingPage.clickLogin();
		loP.login(ConfigLoader.getInstance().getValue("username"), ConfigLoader.getInstance().getValue("password"));
		landingPage.clickProducts();
	}
	
	@Test(alwaysRun = false)
	public void invalidLogin() {
		LoginPage loP =landingPage.clickLogin();
		loP.login("jshdk@gmail.com", "dkfsdkfkd");
//		landingPage.clickProducts();
		String failed = loP.isFailed();
		Assert.assertEquals("Your email or password is incorrect!", failed);
	}

}
