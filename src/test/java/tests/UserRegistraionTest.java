package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistraionTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="testData")
	public  Object[][] dataProvider()
	{
		return new Object[][] 
		{
		 {"Mohammad", "Tarek", "mohammadalatrousdaeha7@gmail.com", "123456789"},
		 {"Mo", "Ta", "mohammadalatrousdaeh@gmail.com", "123456789"},
		};
	}
	
	
	
	@Test(priority = 1,alwaysRun = true,dataProvider ="testData")
	public void userCanRegisterSuccessfully(String fName,String lName,String mail,String password) throws InterruptedException  {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fName, lName, mail, password,
				password);
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