package tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class TestBase {

	public static WebDriver driver;

	@BeforeSuite
	public void startDriver() {
		driver = new FirefoxDriver();
				driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}


	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}
}