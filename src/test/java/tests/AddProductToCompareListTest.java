package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareListTest extends TestBase {

	ProductDetailsPage productDetailsObject;
	SearchPage searchPageObject;
	CompareListPage compareListObject;
String firstProductName="Mac";
String secoundProductName="Asu";
	
	@Test(alwaysRun = true, priority = 1)
	public void testSearchForProductUsingAutoSuggest() throws InterruptedException {
		try {
			productDetailsObject = new ProductDetailsPage(driver);
			searchPageObject = new SearchPage(driver);
			searchPageObject.productSearchUsingAutoSuggest("mac");
			productDetailsObject.addProductToCompareList();
			searchPageObject.productSearchUsingAutoSuggest("asu");
			productDetailsObject.addProductToCompareList();
			//Assert.assertTrue(productDetailsObject.getProductTitle().contains("Asus"));
			productDetailsObject.openComparePage();

		} catch (Exception e) {
			System.out.println("Error Ocurred !" + e.getMessage());
		}

	}
	@Test(priority =  2)
	public void testSecoundItem() {
		compareListObject=new CompareListPage(driver);
		Assert.assertTrue(compareListObject.firstProductName.getText().contains(secoundProductName));
		
	}
	@Test(priority = 2)
	public void testFirstitem() {
		Assert.assertTrue(compareListObject.secoundProductName.getText().contains(firstProductName));
		
	}

}
