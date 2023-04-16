package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;


public class UserRegisration extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
	    homeObject =new HomePage(driver);
	    homeObject.openRegistrationPage();
	}
	@When("I click on register link")
	public void i_click_on_register_link() {
	 Assert.assertTrue(driver.getCurrentUrl().contains("register")); 
	}
	@When("I entered the user data")
	public void i_entered_the_user_data() {
	   registerObject=new UserRegistrationPage(driver);
	   registerObject.userRegistration("mohammad", "tarek", "momo@gmail.com", "123456789", "123456789");
	}
	@Then("The regiseration page displayed successfully")
	public void the_regiseration_page_displayed_successfully() {
	    System.out.println("logout");
	}
}
