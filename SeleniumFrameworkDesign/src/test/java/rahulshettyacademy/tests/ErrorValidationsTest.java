package rahulshettyacademy.tests;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import java.util.List;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;

import org.testng.annotations.Test;

public class ErrorValidationsTest extends BaseTest {
	String productName="ZARA COAT 3";
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation()throws IOException, InterruptedException{
		
		
		landingPage.loginApplication("chaudhuri28soumya@gmail.com", "Zoom99mooz"); // credentials given
		Assert.assertEquals("Incorrect emails or password.", landingPage.getErrorMessage());
		

	}
	
	@Test
	public void ProductErrorValidation()throws IOException, InterruptedException{
		
		String productName="ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplication("impulsdeep28@gmail.com", "AxByCz99"); // credentials given
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		

	}


}
