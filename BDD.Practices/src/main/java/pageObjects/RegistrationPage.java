package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseClass;

public class RegistrationPage extends BaseClass {

	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "page-heading")
	WebElement createAcountLabel;

	@FindBy(id = "id_gender1")
	WebElement maleGender;

	@FindBy(id = "id_gender2")
	WebElement femaleGender;

	@FindBy(id = "customer_firstname")
	WebElement firstNameTextBox;

	@FindBy(id = "customer_lastname")
	WebElement lastNameTextBox;

	@FindBy(id = "passwd")
	WebElement passwordTextBox;

	@FindBy(id = "address1")
	WebElement addressLine1;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement stateDropDown;

	@FindBy(id = "postcode")
	WebElement zipcode;

	@FindBy(id = "id_country")
	WebElement countryDropdown;

	@FindBy(id = "other")
	WebElement additionalInfo;

	@FindBy(id = "phone_mobile")
	WebElement mobileNo;

	@FindBy(id = "submitAccount")
	WebElement registerButton;

	//Actions to be performed

	public void selectGenderTitle(String title) {
		waitForElement(driver, createAcountLabel, 15);
		if (title.equals("Mr."))
			maleGender.click();
		else
			femaleGender.click();
	}

	public void enterFirstName(String fname) {
		enterText(firstNameTextBox, fname);
	}

	public void enterLastName(String fname) {
		enterText(lastNameTextBox, fname);
	}

	public void enterPasswordForRegistration(String pwd) {
		enterText(passwordTextBox, pwd);
	}

	public void enterAddress(String address) {
		enterText(addressLine1, address);
	}

	public void enterCity(String cityName) {
		enterText(city, cityName);
	}

	public void selectState(String state) {
		selectDropDownByText(driver, stateDropDown, state);
	}

	public void enterZipCode(String zipc) {
		enterText(zipcode, zipc);
	}

	public void selectCountry(String country) {
		selectDropDownByText(driver, countryDropdown, country);
	}

	public void enterAdditionalInfo(String no) {
		enterText(additionalInfo, no);
	}

	public void enterMobileNo(String no) {
		enterText(mobileNo, no);
	}

	public void clickOnRegisterButton() {
		registerButton.click();
	}

}
