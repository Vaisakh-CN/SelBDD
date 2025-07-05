package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        if (tDriver.get() == null) {
        //    String browser = ConfigReader.getProperty("browser").toLowerCase();
          // browser = System.getProperty("browser", "chrome");
        				String browser = Base.getBrowserName().toLowerCase(); // Get browser name from Base class

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    tDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    tDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    tDriver.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            tDriver.get().manage().window().maximize();
           // driver.get(ConfigReader.getProperty("url")); // Load URL from env file
        }

        return tDriver.get();
    }

    public static WebDriver getDriver() {
        return initDriver();
    }

    public static void quitDriver() {
      //  if (tDriver.get() != null) {
        	getDriver().quit();
        	tDriver.set(null); 
            tDriver.remove();
        //}
    }
}