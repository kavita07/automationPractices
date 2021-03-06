package stepDefinations;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import Base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class StepDef extends BaseClass {

	HomePage homepage;
	RegistrationPage register;
	AddToCartPage addToCartPage;
	String emailId;
	String configFilePath = ".//config.properties";

	@Before
	public void setUp() throws IOException {
		logger = Logger.getLogger("BDD.Practices");
		
		launchApp();
		
		homepage = new HomePage();
		register = new RegistrationPage();
		addToCartPage = new AddToCartPage();
	}

	@When("User opens URL in appropriate browser")
	public void User_opens_URL() throws Throwable {
		Assert.assertEquals(navigateToURL(), readPropertiesFile(configFilePath, "title"));
	}

	@And("User clicks on Signin on landing page")
	public void User_clicks_on_Signin_on_landing_page() throws Throwable {
		homepage.clickSignin();
	}

	@When("User enters unique email id")
	public void User_enters_email_id() throws Throwable {
		emailId = homepage.enterNewEmail();
	}

	@And("User clicks on create account button")
	public void clicks_on_create_account_button() throws Throwable {
		homepage.clickCreateAccount();
	}

	@And("User selects title as {string}")
	public void User_selects_title_as(String string) throws Throwable {
		register.selectGenderTitle(string);
	}

	@And("User enters first name as {string}")
	public void User_enters_first_name_as(String string) throws Throwable {
		register.enterFirstName(string);
	}

	@And("User enters last name as {string}")
	public void User_enters_last_name_as(String string) throws Throwable {
		register.enterLastName(string);
	}

	@And("User enters password")
	public void User_enters_password_as() throws Throwable {
		// prop.load(configFileIn);
		register.enterPasswordForRegistration(readPropertiesFile(configFilePath, "password"));
	}

	@And("User enters address line1 as {string}")
	public void User_enters_address_line1_as(String string) throws Throwable {
		register.enterAddress(string);
	}

	@And("User enters city as {string}")
	public void User_enters_city_as(String string) throws Throwable {
		register.enterCity(string);
	}

	@And("User enters state as {string}")
	public void User_enters_state_as(String state) throws Throwable {
		register.selectState(state);
	}

	@And("User enters zipcode as {string}")
	public void User_enters_zipcode_as(String zipc) throws Throwable {
		register.enterZipCode(zipc);
	}

	@And("User enters country as {string}")
	public void User_enters_country_as(String country) throws Throwable {
		register.selectCountry(country);
	}

	@And("User enters additional phone no as {string}")
	public void User_enters_additional_info_as(String info) throws Throwable {
		register.enterAdditionalInfo(info);
	}

	@And("User enters mobile no {string}")
	public void User_enters_mobile_no(String mobileNo) throws Throwable {
		register.enterMobileNo(mobileNo);
	}

	@And("User clicks on Register button")
	public void User_clicks_on_register_button() throws Throwable {
		register.clickOnRegisterButton();
	}

	@And("User verifies on landing screen correct {string} and {string} is displayed")
	public void User_verifies_on_landing_screen_correct_name_surename(String fname, String lname) throws Throwable {
		Assert.assertEquals(fname + " " + lname, homepage.verifyUserHeader());
		writeToPropertiesFile(configFilePath, "generatedemailid", emailId);
		logger.info("********** USER REGISTERED SUCCESSFULLY **********");

	}

	@And("User logout from application")
	public void User_logout_from_application() {
		Assert.assertTrue(homepage.signOut());
	}

	@When("User enters registered email id")
	public void User_enters_registered_email_id() throws IOException {
		homepage.enterRegisteredEmailId(readPropertiesFile(configFilePath, "generatedemailid"));
	}

	@And("User enters password for login")
	public void User_enters_password() throws IOException {
		homepage.enterPasswordForLogin(readPropertiesFile(configFilePath, "password"));
	}

	@And("User clicks on SignIn button")
	public void User_clicks_on_SignIn_button() {
		Assert.assertTrue(homepage.loginToApp());
		logger.info("********** REGISTERED USER SUCCESSFULLY LOGGED IN **********");
	}

	@And("User selects product catagory as {string}")
	public void User_selects_product_catagory_as_(String catagory) {

		if (catagory.equals("T-shirt"))
			Assert.assertTrue(addToCartPage.selectT_shirtCatagory());

	}

	@And("User selects first product")
	public void User_selects_first_product() {
		addToCartPage.openProduct();
	}

	@And("User adds the product to cart")
	public void User_adds_the_product_to_cart() {
		addToCartPage.addToCart();
		logger.info("********** PRODUCT ADDED TO CART **********");
	}

	@And("User clicks on proceed to checkout button")
	public void User_clicks_on_proceed_to_checkout_button() {
		addToCartPage.getCartProductDetails();
		addToCartPage.proceedToCheckOutOnCart();
	}

	@Then("User verifies the product details")
	public void User_verifies_the_product_details() {
		Assert.assertTrue(addToCartPage.verifyProductDetails());
		logger.info("********** PRODUCT DETAILS ARE SAME ON THE PAGES CART DETAIL AND PAYMENT DETAILS **********");
	}

	@After
	public void tearDown() throws IOException {
		logger.info("********** CLOSING BROWSER **********");
		driver.quit();
	}
}
