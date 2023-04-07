package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BaseClass {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "strong.current-item")
	public WebElement productDetailsTitle;

	@FindBy (css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy (id="price-value-4")
	public WebElement currencyIcon;
	
	public String getProductTitle() {
	
		return productDetailsTitle.getText();
	}
	public void enterEmailFriendPage() {
		clickButton(emailFriendBtn);
	}
}
