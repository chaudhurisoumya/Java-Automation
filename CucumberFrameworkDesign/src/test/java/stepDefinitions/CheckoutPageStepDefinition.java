package stepDefinitions;
import io.cucumber.java.en.Given;
import pageObjects.LandingPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.TestContextSetup;
public class CheckoutPageStepDefinition {

	//Single Responsibility Principle
	//Loosely coupled
	//Factory Design Pattern
	public CheckoutPage checkoutPage;
	
	TestContextSetup testcontextsetup;
	
	public CheckoutPageStepDefinition(TestContextSetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
		this.checkoutPage=testcontextsetup.pageObjectManager.getCheckoutPage();
	}
	

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_and_place_order() {
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	}
	
	@Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) {
		checkoutPage.CheckoutItems();
	}
	
}
