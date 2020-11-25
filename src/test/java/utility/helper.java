package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class helper {
	
	public static void screeShot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			org.openqa.selenium.io.FileHandler.copy(src, new File("./Screenshot/Login.png"));
		} catch (IOException e) {
			System.out.println("Unable to take screenshot"+e.getMessage());
		}
	}
//	public static String getDateTime() {
//		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
//		Date currentdate = new Date();
//		customFormat.format(currentdate);
//	}

}
