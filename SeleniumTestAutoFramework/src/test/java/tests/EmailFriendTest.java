package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	ProductDetailsPage productDetailsObject;
	SearchPage searchPageObject;
	EmailFriendPage emailFriendObject;

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Mohammad", "Tarek", "mohammadtarek@gmail.com", "123456789", "123456789");
		// Thread.sleep(3000);
		Assert.assertTrue(registerObject.result.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void testSearchForProductUsingAutoSuggest() throws InterruptedException {
		try {
			productDetailsObject = new ProductDetailsPage(driver);
			searchPageObject = new SearchPage(driver);
			searchPageObject.productSearchUsingAutoSuggest("mac");
			Assert.assertTrue(productDetailsObject.getProductTitle().contains("Apple MacBook"));

		} catch (Exception e) {
			System.out.println("Error Ocurred !" + e.getMessage());
		}

	}

	@Test(priority = 3)
	public void testEmailFriend() throws InterruptedException {
		loginObject = new LoginPage(driver);
		emailFriendObject = new EmailFriendPage(driver);
		homeObject.openLoginPage();
		loginObject.userLogin("mohammadtarek@gmail.com", "123456789");
		productDetailsObject.enterEmailFriendPage();
		emailFriendObject.emailFriendFieldArea("moha@gmail.com", "check this please");
		Assert.assertTrue(emailFriendObject.result.getText().contains("Your message has been sent."));

	}
}
