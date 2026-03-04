package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pages.LoginPage;
import utils.DriverFactory;
import utils.waithelper;

public class LoginSteps {

    private LoginPage loginPage;
    private waithelper waithelper;
    Actions action;
    WebDriver driver;
    JavascriptExecutor js;

    @Given("User launches the browser")
    public void launch_browser() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        waithelper = new waithelper(driver, 10);
    }

    @And("User navigates to login page")
    public void navigate_to_login() {

        driver.get("https://auth.eagleeyenetworks.com/login");
        waithelper = new waithelper(null, 10);

    }

    @When("User enters valid credentials")
    public void enter_credentials() {

        loginPage.enterUsername("aut.distributor.prod+r1_e4@gmail.com");
        loginPage.clickNext();
        loginPage.enterPassword("enduser_4_prod@een");
        loginPage.clickLogin();
    }

    @Then("User should land on dashboard page")
    public void verify_dashboard() {

        String title = driver.getTitle();
        waithelper = new waithelper(null, 10);
        driver.navigate()
                .to("https://webapp.eagleeyenetworks.com/#/layouts/9b6ba9f1-7927-46ee-a711-741642d72b15");
        loginPage.goToDashboard();
        loginPage.clickAddDevice();

    }
}
