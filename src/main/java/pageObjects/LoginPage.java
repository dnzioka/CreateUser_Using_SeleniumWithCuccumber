package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement username;
	
	@FindBy(css="#Password")
	WebElement password;
	
	@FindBy(css="button[type='submit']")
	WebElement login;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	
	public void setUsername(String uname) {
		username.clear();
		username.sendKeys(uname);	
	}
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);	
	}
	
	public void clickLogin() {
		login.click();	
	}
	public void clickLogout() {
		logout.click();	
	}
	

}
