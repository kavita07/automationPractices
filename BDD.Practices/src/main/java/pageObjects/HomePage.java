package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseClass;

public class HomePage extends BaseClass {

	String emailId;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "header_logo")
	WebElement headerLogo;

	@FindBy(xpath = "//a[@class='login']")
	WebElement signin;

	@FindBy(id = "email_create")
	WebElement newEmailAddressTextBox;

	@FindBy(id = "email")
	WebElement registeredEmailAddressTextBox;

	@FindBy(id = "SubmitCreate")
	WebElement createAC;

	@FindBy(xpath = "//a[@class='account']/span")
	WebElement headerUserInfo;

	@FindBy(className = "page-heading")
	WebElement myAccount;

	@FindBy(className = "logout")
	WebElement signOut;

	@FindBy(id = "SubmitLogin")
	WebElement logInButton;

	@FindBy(id = "passwd")
	WebElement passwordTextBox;
	
	// Actions to be performed

	public void clickSignin() {
		waitForElement(driver, signin, 20);
		click(driver, signin);
	}

	public String enterNewEmail() {
		emailId = generateRandomString() + "@gmail.com";
		type(newEmailAddressTextBox, emailId);
		return emailId;
	}

	public void clickCreateAccount() {
		waitForElement(driver, createAC, 15);
		click(driver, createAC);
	}

	public String verifyUserHeader() {
		return headerUserInfo.getText();
	}

	public boolean signOut() {
		click(driver, signOut);
		return isDisplayed(driver, signin);
	}

	public void enterRegisteredEmailId(String email) {
		type(registeredEmailAddressTextBox, email);
	}

	public void enterPasswordForLogin(String pwd) {
		type(passwordTextBox, pwd);
	}

	public boolean loginToApp() {
		click(driver, logInButton);
		return isDisplayed(driver, myAccount);
	}
}
