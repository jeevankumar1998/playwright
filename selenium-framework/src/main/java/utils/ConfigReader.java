package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Static block to load the properties from config.properties
    static {
        try {
            // Use ClassLoader to read the config.properties from resources folder
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            properties = new Properties();

            // Load the properties file
            properties.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get browser type (chrome, firefox, etc.)
    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    // Get base URL of the application
    public static String getUrl() {
        return properties.getProperty("app.url");
    }

    // Get the implicit wait timeout value
    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicit.wait"));
    }

    // Get the explicit wait timeout value
    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicit.wait"));
    }

    // Get the page load timeout value
    public static int getPageLoadTimeout() {
        return Integer.parseInt(properties.getProperty("page.load.timeout"));
    }

    // Get the report file path
    public static String getReportPath() {
        return properties.getProperty("report.path");
    }

    // Get the screenshot file path
    public static String getScreenshotPath() {
        return properties.getProperty("screenshot.path");
    }

    // Get the environment (QA, UAT, PROD)
    public static String getEnvironment() {
        return properties.getProperty("environment");
    }

    // Check if headless mode is enabled for browser
    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    // Check if browser window should be maximized
    public static boolean isMaximized() {
        return Boolean.parseBoolean(properties.getProperty("maximize"));
    }
}