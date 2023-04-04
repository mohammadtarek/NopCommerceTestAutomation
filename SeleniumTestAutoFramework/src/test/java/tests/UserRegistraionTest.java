package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistraionTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	
	@Test
	public void userCanRegisterSuccessfully() throws InterruptedException {
		
		homeObject =new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject =new UserRegistrationPage(driver);
		registerObject.userRegistration("Mohammad", "Tarek", "mohammadalatroush1@gmail.com", "123456789", "123456789");
		Thread.sleep(2000);
		Assert.assertTrue(registerObject.result.getText().contains("Your registration completed"));
	}

}
