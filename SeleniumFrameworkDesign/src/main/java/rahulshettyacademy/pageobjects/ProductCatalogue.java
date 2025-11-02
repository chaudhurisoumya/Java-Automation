package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); // It takes the driver as argument and uses the driver during page factory initialization
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
	
	//PageFactory -- It is applicable only for driver.findElement construction
	@FindBy(css=".mb-3")
	private List<WebElement> products;
	private By productsBy=By.cssSelector(".mb-3");
	
	private By addToCart=By.cssSelector(".card-body button:last-of-type");
	private By toastMessage=By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	private WebElement spinner;
	
	public List<WebElement> getProductList() {  //Action method
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod= getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
	
	
	

}
