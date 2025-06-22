package stepDefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    WebDriver driver;

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("user opens the login page")
    public void user_opens_the_login_page() {
        driver.get("https://www.saucedemo.com/v1/");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Check for successful login
    	driver.findElement(By.id("login-button")).click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    			wait.until(d -> d.findElement(By.className("title")).isDisplayed());

    	
        //driver.quit();
    }
}
