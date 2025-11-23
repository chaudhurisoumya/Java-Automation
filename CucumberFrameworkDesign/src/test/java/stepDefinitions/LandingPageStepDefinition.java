package stepDefinitions;
import io.cucumber.java.en.Given;
import pageObjects.LandingPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.TestContextSetup;
public class LandingPageStepDefinition {

	//Single Responsibility Principle
	//Loosely coupled
	//Factory Design Pattern
	
	TestContextSetup testcontextsetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
		this.landingPage=testcontextsetup.pageObjectManager.getLandingPage();
	}
	

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	    
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)throws InterruptedException {
		
		landingPage.searchItem(shortName);
		Thread.sleep(5000);
		testcontextsetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testcontextsetup.landingPageProductName+" is extracted from Home page");
	}
	
	@When("added {string} items of the selected product to cart")
	public void Added_items_product(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
}
