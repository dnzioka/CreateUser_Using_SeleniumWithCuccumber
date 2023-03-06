package testComponents;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage customerPage;
	
	//Generate unique Email for every customer
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
}
