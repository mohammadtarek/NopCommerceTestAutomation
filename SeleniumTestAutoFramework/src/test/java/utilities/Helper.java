package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	// method to take screen shot when test fail
	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		Path dest = Paths.get("./Screenshots", screenshotName + ".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot." + e.getMessage());

		}
	}

}
