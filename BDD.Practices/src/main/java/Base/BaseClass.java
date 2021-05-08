package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePage;

public class BaseClass {

	public static WebDriver driver;
	public HomePage homepage;
	public static Logger logger;
	public static Properties prop;
	static FileInputStream IN;
	static PropertiesConfiguration config;
	static String configFilePath = ".//config.properties";

	// Generating random email id's
	public static String generateRandomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public static void launchApp() throws IOException {
		// WebDriverManager.chromedriver.setup();
		String browserType = readPropertiesFile(configFilePath, "browser");
		logger.info("browser type :" + browserType);
		
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readPropertiesFile(configFilePath, "chromepath"));
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", readPropertiesFile(configFilePath, "iepath"));
			driver = new InternetExplorerDriver();
		}
		logger.info("********** LOUNCHING BROWSER **********");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static String navigateToURL() throws IOException {
		logger.info("********** OPENING URL **********");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(readPropertiesFile(configFilePath, "url"));
		return driver.getTitle();
	}

	public static void click(WebDriver driver, WebElement element) {
		try {
			element.click();
		} catch (StaleElementReferenceException e) {
			element.click();
		}
	}

	public static boolean isDisplayed(WebDriver driver, WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void selectDropDownByText(WebDriver driver, WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void type(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static String readPropertiesFile(String filePath, String key) throws IOException {
		IN = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(IN);
		return prop.getProperty(key);
	}

	public static void writeToPropertiesFile(String filePath, String key, String value) throws ConfigurationException {
		config = new PropertiesConfiguration(filePath);
		config.setProperty(key, value);
		config.save();
	}

	public static void clickUsingJavaSCript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

}
