package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features=".//Features/Customer.feature", 
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
	

}
