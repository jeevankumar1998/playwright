package runners;

import utils.AllureResultsCleaner;
import utils.DriverFactory;
import base.Browser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import utils.ConfigReader;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions", "hooks" }, plugin = {
        "pretty", "html:target/cucumber-report.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}, tags = "@smoke", monochrome = true, dryRun = false

)

public class TestRunner extends AbstractTestNGCucumberTests {

    public static Browser browser;

    @BeforeSuite
    public void startBrowser() {

        AllureResultsCleaner.clearAllureResultsFolder();
    }

    // @AfterSuite
    // public void closeBrowser() {
    // DriverFactory.quitDriver();
    // }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
