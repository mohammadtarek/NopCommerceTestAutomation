package pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BaseClass {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "small-searchterms")
	WebElement searchBar;

	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(id = "ui-id-1")
	List< WebElement> productList;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
	public WebElement productTitle;

	public void productSearch(String productName) {
		setTxtElementTxt(searchBar, productName);
		clickButton(searchBtn);
	}

	public void openProductDetails() {
		clickButton(productTitle);
	}

	public void productSearchUsingAutoSuggest(String prductName) throws InterruptedException {
		
		setTxtElementTxt(searchBar, prductName);
		Thread.sleep(3000);
		productList.get(0).click();
		
	}
}
