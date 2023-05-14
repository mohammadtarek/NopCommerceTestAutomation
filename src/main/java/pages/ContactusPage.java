package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage extends BaseClass {

	public ContactusPage(WebDriver driver) {
		super(driver);

	}
	@FindBy (linkText = "Contact us")
	private WebElement contactusLink;
	
	@FindBy(id="FullName")
	private WebElement fullNameTxtBox;
	
	@FindBy (id="Email")
	private WebElement emailTxtBox;
	
	@FindBy(id = "Enquiry")
	private WebElement enquiryTextArea;
	
	@FindBy (name = "send-email")
	private WebElement submitForm;
	
	@FindBy (css = "div.result")
	public WebElement result;
	public void fillContactusForm(String fullName, String email, String enquiry) {
		
		clickButton(contactusLink);
		setTxtElementTxt(fullNameTxtBox, fullName);
		setTxtElementTxt(emailTxtBox, email);
		setTxtElementTxt(enquiryTextArea, enquiry);
		clickButton(submitForm);
	}

}
