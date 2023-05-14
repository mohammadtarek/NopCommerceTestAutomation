package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistraionTestWithDDTAndJsonFile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	JsonDataReader jsonReader=new JsonDataReader();
	
	
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException  {
		//jsonReader=new  JsonDataReader();
		
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		System.out.println(jsonReader.email+"******************************************************fsasdsdaadsf****##");
		registerObject.userRegistration(jsonReader.fName, jsonReader.lName, jsonReader.email,jsonReader.password,
				jsonReader.password);
		Thread.sleep(3000);
		Assert.assertTrue(registerObject.result.getText().contains("Your registration completed"));
	}


//	@Test (dependsOnMethods = {"userCanRegisterSuccessfully"})
//	public void registeredUserCanLogin() throws InterruptedException {
//		loginObject =new LoginPage(driver);
//		homeObject.openLoginPage();
//		loginObject.userLogin("mohammadalatrousdaeha7@gmail.com", "123456789");
//		
//		Thread.sleep(3000);
//	}
}