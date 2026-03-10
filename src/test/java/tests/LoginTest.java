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
	
	@Test
	public void invalidLogin() {
		LoginPage loP =landingPage.clickLogin();
		loP.login(ConfigLoader.getInstance().getValue("username"), "dkfsdkfkd");
//		landingPage.clickProducts();
		Assert.assertEquals("Your email or password is incorrect!", loP.isFailed());
	}

}
