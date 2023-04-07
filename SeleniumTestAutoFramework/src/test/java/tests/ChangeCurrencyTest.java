package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

	HomePage homeObject;
	ProductDetailsPage productDetailsObject;
	SearchPage searchObject;
	@Test
	public void changeCurrencyTest() throws InterruptedException {
		homeObject=new HomePage(driver);
		productDetailsObject =new ProductDetailsPage(driver);
		searchObject=new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest("mac");
		homeObject.changeCurrency();
		Assert.assertTrue(productDetailsObject.currencyIcon.getText().contains("€"));
		
	}
		
	
}
