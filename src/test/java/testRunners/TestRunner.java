package testRunners;

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
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
