package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy (id = "customerCurrency")
	WebElement currencyDropDownList;

	public void openRegistrationPage() {
		clickButton(registerlink);

	}

	public void openLoginPage() {
		clickButton(loginLink);
	}
	public void openMyaccountPage() {
		clickButton(myaccountLink);
	}
	public void changeCurrency() {
		select=new Select(currencyDropDownList);
		select.selectByVisibleText("Euro");
	}

}
