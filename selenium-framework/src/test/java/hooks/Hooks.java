package hooks;

import base.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.Base64;
import java.io.ByteArrayInputStream;

import io.qameta.allure.Allure;

import runners.TestRunner;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExtentManager;

public class Hooks {

    public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {

        DriverFactory.initDriver(); // create driver for this thread
        WebDriver driver = DriverFactory.getDriver(); // get thread-specific driver

        driver.get(ConfigReader.getUrl());

        extent = ExtentManager.getInstance();
        test = extent.createTest(scenario.getName());
        test.info("Scenario started");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            test.fail("Scenario Failed");

            String base64Screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BASE64);

            test.addScreenCaptureFromBase64String(
                    base64Screenshot,
                    "Failure Screenshot");
            byte[] decodedScreenshot = Base64.getDecoder().decode(base64Screenshot);
            Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(decodedScreenshot));

            scenario.attach(
                    Base64.getDecoder().decode(base64Screenshot),
                    "image/png",
                    scenario.getName());

        } else {
            test.pass("Scenario Passed");
        }

        extent.flush();

        try {
            // Get original window handle
            String originalWindow = driver.getWindowHandle();

            // Close all other windows
            for (String window : driver.getWindowHandles()) {
                if (!window.equals(originalWindow)) {
                    driver.switchTo().window(window);
                    driver.close();
                }
            }

            // Switch back to original window
            driver.switchTo().window(originalWindow);

            // Clear cookies
            driver.manage().deleteAllCookies();

            // Navigate back to the login page
            driver.get(ConfigReader.getUrl());

        } catch (Exception e) {
            System.out.println("Error resetting browser after scenario: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
