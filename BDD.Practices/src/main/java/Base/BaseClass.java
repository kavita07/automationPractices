package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePage;

public class BaseClass {
	
	public WebDriver driver;
	public HomePage homepage;
	public static Logger logger;
	public Properties prop;
	FileInputStream IN;
	PropertiesConfiguration config;
	
	//Generating random email id's
	public static String generateRandomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public void waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void selectDropDownByText(WebDriver driver, WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void enterText(WebElement element, String text){
		element.clear();
		element.sendKeys(text);
	}
	
	public String readPropertiesFile(String filePath,String key) throws IOException {
		IN  = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(IN);		
		return prop.getProperty(key);
	}
	
	public void writeToPropertiesFile(String filePath,String key, String value) throws ConfigurationException {
		config = new PropertiesConfiguration(filePath);
		config.setProperty(key, value);
		config.save();
	}
	
	public void clickUsingJavaSCript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
}
