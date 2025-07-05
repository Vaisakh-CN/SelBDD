import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;


public class test {
	private static WebDriver  driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
 
        driver.get("https://www.google.com");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10))
        		.pollingEvery(Duration.ofMillis(500)).ignoreAll(Arrays.asList(NoSuchElementException.class, StaleElementReferenceException.class));
        try {
			wait.until(ExpectedConditions.titleIs("Googlehjj"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.getTitle();
        driver.manage().window().maximize();
        driver.quit();

	}

}
