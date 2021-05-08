package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		@FindBy(id = "header_logo")
		WebELement headerLogo;
		
		@FindBy(xpath = "//a[@class='login']")
		WebElement signin;
		
		@FindBy(id = "email_create")
		WebElement emailAddress;
		
	}
}
