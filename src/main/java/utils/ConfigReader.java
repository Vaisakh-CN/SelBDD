package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props;
    private static Properties baseProps;
    public static void loadProperties() {
        try {
            // Step 1: Load base config (config.properties)
             baseProps = new Properties();
            FileInputStream baseFis = new FileInputStream("src/test/resources/Config.properties");
            baseProps.load(baseFis);
System.out.println("===================================================================");
            // Step 2: Read environment from base config
            String env = baseProps.getProperty("env"); // e.g., "qa", "dev", etc.

            // Step 3: Load env-specific config with fallback to baseProps
            props = new Properties(baseProps);
            FileInputStream envFis = new FileInputStream("src/test/resources/" + env + ".properties");
            props.load(envFis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
    	loadProperties();
        return props.getProperty(key);
    }}