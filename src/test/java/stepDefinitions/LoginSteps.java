package stepDefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hooks.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.Base;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginSteps extends Base {
	WebDriver	driver = DriverFactory.initDriver();
	LoginPage loginPage = new LoginPage(driver);

    @Given("user launches the browser")
    public void user_launches_the_browser() {
    	System.out.println(ConfigReader.getProperty("url") + "==================++++++++======");

    	driver.get(ConfigReader.getProperty("url"));
		// Initialize WebDriver based on the browser specified in the config file
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
    }

    @When("user opens the login page")
    public void user_opens_the_login_page() {
    	driver.get(ConfigReader.getProperty("url"));
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Check for successful login
    	loginPage.clickLogin();
    	Hooks.getTest().info("User logged in successfully");
    
    	
    }
}
