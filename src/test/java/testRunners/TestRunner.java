package testRunners;

import base.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
	//features = "System",
    glue = {"stepDefinitions" , "Hooks"},
    plugin = {"pretty",
    		"html:target/cucumber-reports.html",
            "json:target/cucumber.json",
            "rerun:target/failed_scenarios.txt"},
    monochrome = true
)
public class TestRunner extends BaseTest {
	
	// This class is used to run the Cucumber tests with TestNG
	// The @CucumberOptions annotation specifies the features, glue code, and plugins to use
	// The features path can be adjusted based on your project structure
	// The glue path should include the step definitions and hooks packages
	// The plugin options specify the output formats for the test results
	
}
