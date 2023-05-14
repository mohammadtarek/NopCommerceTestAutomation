package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase {

	ProductDetailsPage productDetailsObject;
	SearchPage searchPageObject;
	
	@Test
	public void testSearchForProductUsingAutoSuggest()throws InterruptedException{
		try {
			productDetailsObject=new ProductDetailsPage(driver);
			searchPageObject=new SearchPage(driver);
			searchPageObject.productSearchUsingAutoSuggest("mac");
			Assert.assertTrue(productDetailsObject.getProductTitle().contains("Apple MacBook"));

			
		} catch (Exception e) {
			System.out.println("Error Ocurred !"+e.getMessage());
		}
		
			}
	
}
