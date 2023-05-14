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

	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;

	@FindBy(id = "price-value-4")
	public WebElement currencyIcon;

	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;

	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
	WebElement linkToComparePage;
	
	public
	String getProductTitle() {

		return productDetailsTitle.getText();
	}

	public void enterEmailFriendPage() {
		clickButton(emailFriendBtn);
	}
	public void addProductToCompareList() {
		clickButton(addToCompareListBtn);
	}
	public void openComparePage() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(linkToComparePage);
	}
}
