package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {
	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText = "Register")
	WebElement registerlink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(linkText = "My account")
	WebElement myaccountLink;

	public void openRegistrationPage() {
		clickButton(registerlink);

	}

	public void openLoginPage() {
		clickButton(loginLink);
	}
	public void openMyaccountPage() {
		clickButton(myaccountLink);
	}

}
