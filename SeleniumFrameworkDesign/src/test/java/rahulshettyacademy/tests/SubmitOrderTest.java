package rahulshettyacademy.tests;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import java.util.List;
import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.TestComponents.BaseTest;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.OrderPage;
public class SubmitOrderTest extends BaseTest {
	
	//String productName="ZARA COAT 3";
	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitOrder(HashMap<String,String> input)throws IOException, InterruptedException{
		
	
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password")); // credentials given
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();		
		String confirmMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
			
		}

	
	
	//To verify ZARA COAT 3 is displaying in orders page
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() {
		ProductCatalogue productCatalogue=landingPage.loginApplication("impulsdeep28@gmail.com", "AxByCz99"); // credentials given
		OrderPage orderPage=productCatalogue.goToOrdersPage();
		//Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		
		/*
		 * HashMap<String,String> map1=new HashMap<String,String>();
		 * map1.put("email","chaudhuri28soumya@gmail.com"); map1.put("password",
		 * "AxByCz99"); map1.put("productName", "ZARA COAT 3");
		 * 
		 * HashMap<String,String> map2=new HashMap<String,String>(); map2.put("email",
		 * "tulikatty@gmail.com"); map2.put("password", "AxByCz99");
		 * map2.put("productName", "ADIDAS ORIGINAL");
		 * 
		 * HashMap<String,String> map3=new HashMap<String,String>(); map3.put("email",
		 * "impulsdeep28@gmail.com"); map3.put("password", "AxByCz99");
		 * map3.put("productName", "iphone 13 pro");
		 * 
		 * 
		 * return new Object[][] { {map1}, {map2}, {map3} };
		 */
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {
			{data.get(0)},
			{data.get(1)},
			{data.get(2)}
		};
	}


}
