package Hooks;

import utils.Base;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExtentManager;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.*;

public class Hooks extends DriverFactory {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest scenarioTest;
     
    
    @Before
    public void setUp(Scenario scenario) {
    	//WebDriver	driver = DriverFactory.initDriver();
        scenarioTest = extent.createTest(scenario.getName());
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
            scenarioTest.fail("Test Failed: " + scenario.getName());
        } else {
        	TakesScreenshot ts = (TakesScreenshot) getDriver();
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
            String FinalScreenShot = Base64.getEncoder().encodeToString(src);
            scenarioTest.pass("Test Passed: " + scenario.getName())
                        .addScreenCaptureFromBase64String(FinalScreenShot, "Success Screenshot");
            
        }
        extent.flush();
        DriverFactory.quitDriver();
    }
    public static ExtentTest getTest() {
        return scenarioTest;
    }
}