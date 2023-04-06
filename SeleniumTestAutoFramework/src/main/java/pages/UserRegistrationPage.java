package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends BaseClass {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;

	@FindBy(id = "FirstName")
	WebElement fNameTxtbox;

	@FindBy(id = "LastName")
	WebElement lNameTxtbox;

	@FindBy(id = "Email")
	WebElement emailTxtbox;

	@FindBy(id = "Password")
	WebElement passTxtbox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassTxtbox;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = "div.result")
	public WebElement result;

	@FindBy (linkText = "Log out")
	WebElement logoutLink;
	public void userRegistration(String fName, String lName, String email, String password, String confirmPassword) {
		clickButton(genderRdoBtn);
		setTxtElementTxt(fNameTxtbox, fName);
		setTxtElementTxt(lNameTxtbox, lName);
		setTxtElementTxt(emailTxtbox, email);
		setTxtElementTxt(passTxtbox, password);
		setTxtElementTxt(confirmPassTxtbox, confirmPassword);
		clickButton(registerBtn);

	}

	

}
