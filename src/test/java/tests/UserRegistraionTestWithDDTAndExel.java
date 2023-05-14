package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistraionTestWithDDTAndExel extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="exelData")
	public  Object[][] userRegisterData() throws IOException
	{
		//get data form exel
		ExelReader er=new ExelReader();
		return  er.getExelData();
		
	}
	
	
	
	@Test(priority = 1,alwaysRun = true,dataProvider="exelData")
	public void userCanRegisterSuccessfully(String fName,String lName,String mail,String password) throws InterruptedException  {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fName, lName, mail, password,password);
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