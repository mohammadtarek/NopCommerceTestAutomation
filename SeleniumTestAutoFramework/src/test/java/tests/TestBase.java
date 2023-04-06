package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase {

	public static WebDriver driver;

	@BeforeSuite
	@Parameters({ "browser" })
	
	public void startDriver(@Optional("Firefox") String browserName)
	{
		if (browserName.equalsIgnoreCase("Chrome")) 
		{
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}

		driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failed1 !");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}