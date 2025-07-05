package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class Base extends DriverFactory {
 
	
	private static ThreadLocal<String> browserName = new ThreadLocal<>();

    public static void setBrowserName(String browser) {
        browserName.set(browser);
    }

    public static String getBrowserName() {
        return browserName.get();
    }
    public static Properties prop;

    public static void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/test/resources/Config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
