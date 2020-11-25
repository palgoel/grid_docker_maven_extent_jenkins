package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserFactory {
	WebDriver driver;
	public static WebDriver startapp(WebDriver driver,String browsername,String urlname) {
		if (browsername=="Firefox") {
//			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
//			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//            capabilities.setCapability("marionette", true);
//			driver = new FirefoxDriver(capabilities);
			WebDriverManager.firefoxdriver().setup(); //using webdriver manager to install the driver path automatically
			driver = new FirefoxDriver();
		}
		if (browsername=="Chrome") {
//			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}			
			driver.manage().window().maximize();
			driver.get(urlname);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    return driver;
	}
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
