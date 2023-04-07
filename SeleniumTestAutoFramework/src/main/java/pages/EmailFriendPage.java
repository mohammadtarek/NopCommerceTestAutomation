package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends BaseClass{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(name="FriendEmail")
	WebElement friendEmailTxtBox;
	
	@FindBy (id="YourEmailAddress")
	WebElement yourEmailTxtBoxp;
	
	@FindBy (id="PersonalMessage")
	WebElement personalMessageTxtBox;
	
	@FindBy (name="send-email")
	WebElement sendEmailBtn;
	
	@FindBy (css="div.result")
	public WebElement result;
	
	public void emailFriendFieldArea(String friendEmail, String message) throws InterruptedException {
		setTxtElementTxt(friendEmailTxtBox, friendEmail);
		//setTxtElementTxt(yourEmailTxtBoxp, yourEmail);
		setTxtElementTxt(personalMessageTxtBox, message);
		clickButton(sendEmailBtn);
	
	}

}
