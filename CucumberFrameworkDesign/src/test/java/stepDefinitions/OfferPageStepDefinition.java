package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.TestContextSetup;
import io.cucumber.java.en.Then;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.lang.InterruptedException;
import pageObjects.PageObjectManager;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
public class OfferPageStepDefinition {
	TestContextSetup testcontextsetup;
	String offerPageProductName;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
		OfferPage offerPage=testcontextsetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortName);
		Thread.sleep(5000);
	    
	    offerPageProductName=offerPage.getProductName();
	  
	}
	public void switchToOffersPage() {
		
		LandingPage landingPage=testcontextsetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testcontextsetup.genericUtils.SwitchWindowToChild();
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page() {
		Assert.assertEquals(offerPageProductName, testcontextsetup.landingPageProductName);
	}
}
