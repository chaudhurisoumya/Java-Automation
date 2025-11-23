package stepDefinitions;

import utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

public class Hooks {
	
	TestContextSetup testcontextsetup;
	public Hooks(TestContextSetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
	}
	
	@After
	public void tearDown() throws IOException {
		testcontextsetup.testBase.WebDriverManager().quit(); //driver.quit
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario)throws IOException {
		WebDriver driver=testcontextsetup.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
