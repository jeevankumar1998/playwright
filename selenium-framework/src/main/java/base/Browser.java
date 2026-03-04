package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class Browser {

    private WebDriver driver;

    public Browser(String browserName) {
        if (browserName.equalsIgnoreCase(ConfigReader.getBrowser())) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase(ConfigReader.getBrowser())) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        } else if (browserName.equalsIgnoreCase(ConfigReader.getBrowser())) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }
}
