package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistraionTestWithDDTAndCSV extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader;

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() throws InterruptedException, CsvValidationException, IOException {

		String csvFile = System.getProperty("user.dir") + "\\src\\test\\java\\data\\exeldata.csv";
		reader = new CSVReader(new FileReader(csvFile));

		String[] csvCell;
		// while be executed till the last value of the file
		while ((csvCell = reader.readNext()) != null) {
			String fName = csvCell[0];
			String lName = csvCell[1];
			String mail = csvCell[2];
			String password = csvCell[3];
			homeObject = new HomePage(driver);
			homeObject.openRegistrationPage();
			registerObject = new UserRegistrationPage(driver);
			registerObject.userRegistration(fName, lName, mail, password, password);
			Thread.sleep(1500);
			Assert.assertTrue(registerObject.result.getText().contains("Your registration completed"));
		}

	}

	@Test(dependsOnMethods = { "userCanRegisterSuccessfully" })
	public void registeredUserCanLogin() throws InterruptedException {
		loginObject = new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.userLogin("mohammadalatrousdaeha7@gmail.com", "123456789");

		Thread.sleep(3000);
	}
}