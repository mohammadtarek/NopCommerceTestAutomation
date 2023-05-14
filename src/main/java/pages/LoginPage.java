package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy (id = "Email")
	WebElement emailTxtField;
	
	@FindBy(id = "Password")
	WebElement passwordTxtField;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;	
	@FindBy(linkText = "My account")
	 WebElement myaccountLink;

public void userLogin(String email, String password) {
	
	setTxtElementTxt(emailTxtField, email);
	setTxtElementTxt(passwordTxtField, password);
	clickButton(loginBtn);
}

public void openMyaccountPage() {
	clickButton(myaccountLink);
}

}
