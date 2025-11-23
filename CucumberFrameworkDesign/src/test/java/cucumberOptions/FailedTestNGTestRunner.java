package cucumberOptions;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="@target/failed_scenarios.txt",
glue="stepDefinitions",
monochrome=true,
dryRun=false,
//tags="@PlaceOrder or @OffersPage",
plugin= {"html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		})
public class FailedTestNGTestRunner extends AbstractTestNGCucumberTests{ // Only difference with Junit is that instead of extends AbstractTestNGCucumberTests
																   // We put @RunsWith annotation on top of the class
	
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
