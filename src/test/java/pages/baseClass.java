package pages;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.lang.reflect.Method;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.*;

public class baseClass {
	public WebDriver driver;
	public excelDataProvider excel;
	public configDataProvider config;
	static ExtentReports report;
	public static ExtentTest logger;
	String methodname="";

	
	@BeforeSuite
	public void setupSuite() {
		excel = new excelDataProvider();
		config = new configDataProvider();
		report = new ExtentReports("./Report/Extent_Rep.html");
	}
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void setup(String browser, String url) {
//		driver =browserFactory.startapp(driver, config.getBrowser(),config.getEsodUrl());
		driver =browserFactory.startapp(driver,"Firefox", "https://www.google.com");
//		driver =browserFactory.startapp(driver, browser,url);
	}
	

	@BeforeMethod
	public void method_name(Method method) { //to get name of method of test
		methodname = method.getName();
		logger = report.startTest(methodname);
	}
	
	@AfterMethod
	public void tear(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,logger.getTest().getName()+" is failed"+ logger.addScreenCapture("./download.jpg"));
		}
		
		if (result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, logger.getTest().getName()+" is passed");
		}
		report.flush();
	}
  @AfterClass
  public void teardown() {
		browserFactory.quitBrowser(driver);

  }
  @AfterSuite
	public void stop_test() {
		  report.endTest(logger);
	}

}
