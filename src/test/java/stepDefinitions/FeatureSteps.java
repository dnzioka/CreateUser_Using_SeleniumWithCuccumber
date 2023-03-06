package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import testComponents.BaseTest;

public class FeatureSteps extends BaseTest {

	@Given("User launches Chrome browser")
	public void user_launches_chrome_browser() {
		System.setProperty("webdriver.chrome.drive", "user.dir" + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);

	}

	@When("User enters Email as {string} and Password {string}")
	public void user_enters_email_as_and_password(String email, String password) {
		lp.setUsername(email);
		lp.setPassword(password);

	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(1000);
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(1000);

	}
	@Then("close browser")
	public void close_browser() {
		driver.close();

	}
	// Customer Feature steps definitions

	@Then("User can view Dashboard page")
	public void user_can_view_dashboard_page() {
		customerPage = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", customerPage.getPageTitle());

	}

	@When("User clicks on customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		customerPage.clickOnCustomersMenu();

	}

	@When("Click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		customerPage.clickOnCustomersItem();
		

	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		customerPage.clickOnAddnewbutton();
		Thread.sleep(3000);

	}

	@Then("User can view Add a new customer page")
	public void user_can_view_add_a_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", customerPage.getPageTitle());
	}

	@When("User enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		String Uemail= randomString()+"@gmail.com";
		customerPage.setEmail(Uemail);
		customerPage.setPassword("test12345");
		customerPage.setFirstName("Flavia");
		customerPage.setLastName("Anyango");
		customerPage.setGender("Female");
		customerPage.setDob("7/05/1985");//format: DD/MM/YYYY
		customerPage.setCompanyName("Toqio Fintech S.L.U");
		customerPage.setIsTaxExempt();
		Thread.sleep(3000);
		//customerPage.setNewsletter("Test store 2");
		//Registered by default
		//customerPage.setCustomerRoles("Administrators");
		customerPage.setManagerOfVendor("Vendor 2");
		customerPage.setIsActive();
		customerPage.setAdminComment("This is for QA testing by:"+ randomString()+"@gmail.com");
		
	}

	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {
		customerPage.clickOnSave();
		Thread.sleep(3000);

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String confirmationMessage) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(confirmationMessage));

	}
	
	

	
	
}
