package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseClass{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath   = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(css  = "p.content")
	public WebElement resultLable;
	public void clickChagePasswordLink() {
		clickButton(changePasswordLink);
	}
	public void changePassword(String oldPass, String newPass, String confirmPass) {
		setTxtElementTxt(oldPasswordTxt, oldPass);
		setTxtElementTxt(newPasswordTxt, newPass);
		setTxtElementTxt(confirmPasswordTxt, confirmPass);
		clickButton(changePasswordLink);
	}
}
