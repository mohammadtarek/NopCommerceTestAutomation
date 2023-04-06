package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
public class SearchProductTest extends TestBase {
	String productName="mac";
	SearchPage searchObject;
	 ProductDetailsPage productDetailsObject;
	
	@Test
	public void userCanSearchProduct()  {
		searchObject=new SearchPage(driver);
		searchObject.productSearch(productName);
		Assert.assertTrue(searchObject.productTitle.getText().contains("Apple MacBook"));
		searchObject.openProductDetails();
		
	}
	@Test 
	public void checkProductDetailsTitle() throws InterruptedException {
	
		
		Thread.sleep(3000);
		productDetailsObject=new ProductDetailsPage(driver); 
		Assert.assertTrue(productDetailsObject.getProductTitle().contains("Apple MacBook"));
		}

}
