package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactusPage;

public class ContactusTest extends TestBase{
ContactusPage contactusPageObject;

@Test
public void testContactusForm() {
	contactusPageObject=new  ContactusPage(driver);
	contactusPageObject.fillContactusForm("mohammad", "testexample@gmail.com", "Test if contact us is working correctly");
	Assert.assertTrue(contactusPageObject.result.getText().contains("Your enquiry has been successfully sent to the store owner."));
}
}
