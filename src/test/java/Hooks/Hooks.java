package Hooks;

import utils.Base;
import utils.ConfigReader;
import utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {

    @Before
    public void setUp() {
        //driver.get(ConfigReader.getProperty("url"));
        System.err.println("Scenario Initiated");
       // driver = Base.driver;
    }

    @After
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}