package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WindowsHandlePage;
import utils.Base;
import utils.ConfigReader;
import utils.DriverFactory;

public class WindowsHandle extends Base {
	SoftAssert softAssert = new SoftAssert();
	WebDriver	driver = DriverFactory.initDriver();
	WindowsHandlePage windowsHandlePage  = new WindowsHandlePage(driver);
	
	@Given("User is in landing page")
	public void user_is_in_landing_page() {
	    driver.get(ConfigReader.getProperty("url2"));
	    System.out.println(driver.getTitle());
	    softAssert.assertTrue(driver.getTitle().equals("Window Handles Practice - H Y R Tutorials")) ;
	   System.out.println(driver.getTitle());
	   
	}

	@When("User clicks on new Window button")
	public void user_clicks_on_new_window_button() {
	    windowsHandlePage.clickNewWindowButton();
	}

	@Then("Verify New Window is opened")
	public void verify_new_window_is_opened() {
	    String mainWindowHandle = driver.getWindowHandle();
	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(mainWindowHandle)) {
	            driver.switchTo().window(handle);
	            softAssert.assertTrue(driver.getTitle().contains("New Window"));
	            break;
	        }
	    }
	    
	    
	}

	@Then("Veify the content in new window contains {string} and {string}")
	public void veify_the_content_in_new_window_contains_and(String string, String string2) {
		String newWindowContent = driver.getPageSource();
	    assertTrue(newWindowContent.contains(string ));
	    assertTrue(newWindowContent.contains(string2));
	    
	    // Close the new window and switch back to the main window
	    driver.close();
	    driver.switchTo().window(driver.getWindowHandles().iterator().next());
	}

}
