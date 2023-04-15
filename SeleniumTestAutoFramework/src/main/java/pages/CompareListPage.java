package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends BaseClass{

	public CompareListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a")
	public WebElement firstProductName;
	
	@FindBy (xpath =  "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]/a")
	public WebElement secoundProductName;
	

}
