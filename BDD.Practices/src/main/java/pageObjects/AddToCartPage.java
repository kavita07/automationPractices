package pageObjects;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	public WebDriver driver;
	HashMap<String, String> cartPageMap;
	HashMap<String, String> paymentPageMap;
	String ProductName;
	String ProductColor;
	String ProductSize;
	String ProductQuantity;
	String ProductPrice;
	String ProductShippingCost;
	String ProductTotalCost;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		cartPageMap = new HashMap<String, String>();	
		paymentPageMap = new HashMap<String, String>();
	}
	
	@FindBy(xpath = "//li[a[@title='Tops']]/ul/li/a[text()='T-shirts']")
	WebElement t_shirt_catagory;

	@FindBy(xpath = "//span[contains(text(),'T-shirt')]")
	WebElement tshirtLabel;

	@FindBy(className = "quick-view")
	List<WebElement> quickView;

	@FindBy(xpath = "//p[@id='add_to_cart']/button")
	WebElement addToCartButton;

	@FindBy(id = "layer_cart_product_title")
	WebElement cartProductName;

	@FindBy(id = "layer_cart_product_quantity")
	WebElement cartProductQuantity;

	@FindBy(id = "layer_cart_product_price")
	WebElement cartProductPrice;

	@FindBy(className = "ajax_cart_shipping_cost")
	WebElement cartProductShippingCost;

	@FindBy(id = "layer_cart_product_attributes")
	WebElement cartProductColorAndSize;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	List<WebElement> proceedToCheckout;

	@FindBy(name = "processAddress")
	WebElement proceedToCheckoutAddress;

	@FindBy(name = "processCarrier")
	WebElement proceedToCheckoutCarrier;

	@FindBy(id = "cgv")
	WebElement termsAndConditionsCheckBox;

	@FindBy(xpath = "//p[@class='product-name']/a")
	WebElement productName;

	@FindBy(xpath = "//small/a")
	WebElement productColorAndSize;
	
	
	@FindBy(css = ".cart_quantity.text-center span")
	WebElement productQuantity;

	@FindBy(id = "total_product")
	WebElement productPrice;

	@FindBy(id = "total_shipping")
	WebElement productTotalShipping;

	@FindBy(id = "total_price")
	WebElement productTotalPrice;
	
	public boolean selectT_shirtCatagory(){
		clickUsingJavaSCript(driver, t_shirt_catagory);
		return tshirtLabel.isDisplayed();
	}

	public void openProduct(){
		//waitForElement(driver, quickView.get(0), 15);
		//quickView.get(0).click();
		clickUsingJavaSCript(driver, quickView.get(0));
	}

	public void addToCart(){
		waitForElement(driver, addToCartButton, 15);
		addToCartButton.click();
	}

	public void getCartProductDetails(){
		waitForElement(driver,cartProductName, 15);
		cartPageMap.put(ProductName, cartProductName.getText().trim());

		String arr[] = cartProductColorAndSize.getText().split(",");
		String color = arr[0];
		String size = arr[1].trim();
		cartPageMap.put(ProductColor, color.trim());
		cartPageMap.put(ProductSize, size.trim());
		cartPageMap.put(ProductQuantity, cartProductQuantity.getText().trim());
		cartPageMap.put(ProductPrice, cartProductPrice.getText().trim());
		cartPageMap.put(ProductShippingCost, cartProductShippingCost.getText().trim());
	}



	public void proceedToCheckOutOnCart(){
		waitForElement(driver, proceedToCheckout.get(0), 15);
		proceedToCheckout.get(0).click();
		waitForElement(driver, proceedToCheckout.get(1), 15);

		cartPageMap.put(ProductTotalCost, productTotalPrice.getText().trim());

		proceedToCheckout.get(1).click();

		waitForElement(driver, proceedToCheckoutAddress, 15);
		proceedToCheckoutAddress.click();

		waitForElement(driver, proceedToCheckoutCarrier, 15);
		termsAndConditionsCheckBox.click();
		proceedToCheckoutCarrier.click();

	}


	public boolean verifyProductDetails(){
		waitForElement(driver, productName, 15);
		String arr[] = productColorAndSize.getText().split(",");
		String corlorPart[] = arr[0].split(":");
		String color = corlorPart[1].trim();
		String sizePart[] = arr[1].split(":");
		String size = sizePart[1].trim(); 
		paymentPageMap.put(ProductName, productName.getText().trim());
		paymentPageMap.put(ProductColor, color);
		paymentPageMap.put(ProductSize, size);
		paymentPageMap.put(ProductQuantity, productQuantity.getText().trim());
		paymentPageMap.put(ProductPrice, productPrice.getText().trim());
		paymentPageMap.put(ProductShippingCost, productTotalShipping.getText().trim());
		paymentPageMap.put(ProductTotalCost, productTotalPrice.getText().trim());

		return cartPageMap.equals(paymentPageMap);

	}


}
