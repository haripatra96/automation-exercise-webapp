package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SignUpPage;
import utils.FramworkUtility;

public class SucceFulSignUpTest extends BaseTest{
	
	@Test(retryAnalyzer = listeners.Retry.class)
	public void successfulSignup() {
		String email = FramworkUtility.getRandomEmail();
		String name = FramworkUtility.getRandomName();
		LoginPage lp = landingPage.clickLogin();
		SignUpPage suP = lp.signUp(name, email);
		String confirmationMsg = suP.succesFulSignup("Male", "Test1232", "MyTest_FirstName", "MyTest_last_name",
							"Test Addess", "Test State", "Test City", "125335", "92106435645");
		
		Assert.assertEquals(confirmationMsg, "Account Created!");
		
	}

}
