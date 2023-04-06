package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistraionTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException  {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Mohammad", "Tarek", "mohammadalatrousdaeha7@gmail.com", "123456789",
				"123456789");
		Thread.sleep(3000);
		Assert.assertTrue(registerObject.result.getText().contains("Your registration completed"));
	}


	@Test (dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void registeredUserCanLogin() throws InterruptedException {
		loginObject =new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.userLogin("mohammadalatrousdaeha7@gmail.com", "123456789");
		
		Thread.sleep(3000);
	}
}