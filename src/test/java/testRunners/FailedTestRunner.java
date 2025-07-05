package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "@target/failed_scenarios.txt",  // @ is required!
	    glue = {"stepDefinitions" , "Hooks"},
	    plugin = {
	        "pretty",
	        "html:target/rerun-report.html"
	    }
	)
	public class FailedTestRunner extends AbstractTestNGCucumberTests {
	}