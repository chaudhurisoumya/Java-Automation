package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class TestBase {
	public WebDriver driver;
	
	
	public WebDriver WebDriverManager() throws IOException{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		String url=prop.getProperty("QA_URL");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		String browser=browser_maven!=null?browser_maven:browser_properties;
		
		if(driver==null) {
			if(browser.equalsIgnoreCase("chrome"))	
				driver=new ChromeDriver();
			if(browser.equalsIgnoreCase("edge"))
				driver=new EdgeDriver();
			if(browser.equalsIgnoreCase("firefox"))
				driver=new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;
	}
}
