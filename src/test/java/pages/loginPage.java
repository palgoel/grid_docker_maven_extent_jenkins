package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	WebDriver driver;
	public loginPage(WebDriver ldriver) {
		this.driver = ldriver;
		
		
	}
	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//span[contains(.,'Log In')]") WebElement loginButton;
	@FindBy(xpath="//button[text()='Login']") WebElement loginButtonSubmit;


public void loginActionOnCrm(String username, String pwd) {
	loginButton.click();
	uname.sendKeys(username);
	pass.sendKeys(pwd);
	loginButtonSubmit.click();
	
}







}