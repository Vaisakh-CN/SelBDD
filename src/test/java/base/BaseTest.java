package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Base;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseTest extends AbstractTestNGCucumberTests{
    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void setBrowserName(@Optional("chrome") String browser) {
    	 Base.setBrowserName(browser);
         System.setProperty("browser", browser);
    }

    }

