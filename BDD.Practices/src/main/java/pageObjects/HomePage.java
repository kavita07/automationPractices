package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;
import utilities.Helper;

public class HomePage extends BaseClass{

WebDriver driver;
String emailId;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
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
	
	
	
	public void clickSignin() {
		signin.click();
	}
	
	public String enterNewEmail(){
		emailId = generateRandomString() + "@gmail.com";
		enterText(newEmailAddressTextBox, emailId);
		return emailId;
	}
	
	public void clickCreateAccount() {
		waitForElement(driver, createAC, 15);
		createAC.click();
	}
	
	public String verifyUserHeader() {
		return headerUserInfo.getText();
	}
	
	public boolean signOut() {
		signOut.click();
		return signin.isDisplayed();
	}
	
	public void enterRegisteredEmailId(String email) {
		enterText(registeredEmailAddressTextBox, email);
	}
	
	public void enterPasswordForLogin(String pwd) {
		enterText(passwordTextBox, pwd);
	}
	
	public boolean loginToApp() {
		logInButton.click();
		return myAccount.isDisplayed();
	}
}
