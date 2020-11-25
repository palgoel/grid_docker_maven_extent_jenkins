package testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.baseClass;
import pages.loginPage;

public class loginTest extends baseClass {
	
	@Test
	public void testurl() {
		logger.setDescription("This test is to check the current URL");
		String cururl= driver.getCurrentUrl();
		assertTrue(cururl.contains("google"));
	}
	@Test
	public void testtitle() {
		logger.setDescription("This test is to check the page title");
		String title= driver.getTitle();
		assertTrue(title.contains("Google"));
	}
}
