package tests;



import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccoutTest extends TestBase {

	LoginPage loginobject;
	HomePage homeobject;		
	MyAccountPage myaccobject;

	@Test(priority = 1, alwaysRun = true)
	public void userCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.userLogin("abcdefg@gmail.com", "sssssa");
		homeobject.openMyaccountPage();
	}

	@Test(dependsOnMethods = { "userCanLoginSuccessfully" })
	public void changepassword() throws InterruptedException {
		myaccobject = new MyAccountPage(driver);
		Thread.sleep(3000);
		myaccobject.clickChagePasswordLink();
		myaccobject.changePassword("sssssa", "aaaaaa", "aaaaaa");
		Thread.sleep(3000);
		//Assert.assertTrue(myaccobject.resultLable.getText().contains("was changed"));

	}

}
