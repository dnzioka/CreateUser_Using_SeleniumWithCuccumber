package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customersmenu;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customersitem;

	@FindBy(linkText = "Add new")
	WebElement addnew;

	@FindBy(css = "a[class='btn btn-primary']")
	WebElement addnewbutton;

	@FindBy(id = "Email")
	WebElement useremail;

	@FindBy(id = "Password")
	WebElement userpassword;

	@FindBy(css = "#FirstName")
	WebElement firstname;

	@FindBy(name = "LastName")
	WebElement lastName;

	@FindBy(id = "Gender_Male")
	WebElement gendermale;

	@FindBy(id = "Gender_Female")
	WebElement genderfemale;

	// locator for Date of birth
	By Dob = By.id("DateOfBirth");

	@FindBy(css = "#Company")
	WebElement company;

	@FindBy(name = "IsTaxExempt")
	WebElement IsTaxExempt;
	// locator for Newsletter we use select class
	// locator for customer roles we use select class
	@FindBy(css = "#Active")
	WebElement Active;

	@FindBy(id = "AdminComment")
	WebElement AdminComment;

	@FindBy(css = "button[name='save']")
	WebElement save;

	// Action methods
	public String getPageTitle() {
		String dashboardTitle = driver.getTitle();
		return dashboardTitle;
	}

	public void clickOnCustomersMenu() {
		customersmenu.click();
	}

	public void clickOnCustomersItem() {
		customersitem.click();
	}

	public void clickOnAddnewbutton() {
		addnew.click();
	}

	public void setEmail(String email) {
		useremail.sendKeys(email);
	}

	public void setPassword(String password) {
		userpassword.sendKeys(password);
	}

	public void setFirstName(String fname) {
		firstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void setGender(String gender) {

		if (gender.equals("Male")) {
			gendermale.click();
		} else if (gender.equals("Female")) {
			genderfemale.click();
		} else {
			gendermale.click(); // default gender
		}
	}

	public void setDob(String dob) {
		driver.findElement(Dob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		company.sendKeys(comname);
	}

	public void setIsTaxExempt() {
		IsTaxExempt.click();
	}

	public void setNewsletter(String newsletter) {
		WebElement selectdown = driver.findElement(By.id("SelectedNewsletterSubscriptionStoreIds"));
		Select drp = new Select(selectdown);
		drp.selectByVisibleText(newsletter);

	}

	public void setCustomerRoles(String role) {
		WebElement staticDropdown = driver.findElement(By.id("SelectedCustomerRoleIds"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(role);

	}

	public void setManagerOfVendor(String vendor) {
		WebElement selectdropdown = driver.findElement(By.id("VendorId"));
		Select drp = new Select(selectdropdown);
		drp.selectByVisibleText(vendor);
	}

	public void setIsActive() {
		Active.click();
	}

	public void setAdminComment(String comment) {
		AdminComment.sendKeys(comment);
	}

	public void clickOnSave() {
		save.click();
	}

}
