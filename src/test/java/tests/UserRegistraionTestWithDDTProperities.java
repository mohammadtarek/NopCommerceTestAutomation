package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import data.ReadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistraionTestWithDDTProperities extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String  fName=ReadProperties.userData.getProperty("fName");
	String  lName=ReadProperties.userData.getProperty("lName");
	String email=ReadProperties.userData.getProperty("email");
	String password=ReadProperties.userData.getProperty("password");
	

	
	
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException  {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fName, lName, email, password,
				password);
		Thread.sleep(3000);
		Assert.assertTrue(registerObject.result.getText().contains("Your registration completed"));
	}


	@Test (dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void registeredUserCanLogin() throws InterruptedException {
		loginObject =new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.userLogin(email, password);
		
		Thread.sleep(3000);
	}
}