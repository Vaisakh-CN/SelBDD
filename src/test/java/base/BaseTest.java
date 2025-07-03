package base;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseTest extends AbstractTestNGCucumberTests{
    private static ThreadLocal<String> browserName = new ThreadLocal<>();
   
    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setBrowserName(@Optional("chrome") String browser) {
        browserName.set(browser);
    }

    public static String getBrowserName() {
        return browserName.get();
    }
}
