package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.waithelper;
import hooks.Hooks;
import utils.ConfigReader;
import utils.DriverFactory;

public class InvalidSteps {

    LoginPage loginPage;
    WebDriver driver;
    waithelper waithelper;

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        waithelper = new waithelper(driver, 10);

    }

    @Given("user navigates to login page")
    public void user_navigates_to_login_page() {
        driver.get(ConfigReader.getUrl());
        waithelper = new waithelper(driver, 10);

    }

    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials() {
        loginPage.enterUsername("aut.distributor.prod+r1_e4@gmail.com");
        loginPage.clickNext();
        loginPage.enterPassword("enduser_4_prod@een");
        loginPage.clickLogin();
    }

    @Then("user should not land on dashboard page")
    public void user_should_not_land_on_dashboard_page() {
        String actual = loginPage.getInvalidCredentialsMessage();
        Assert.assertEquals(actual, "Invalid credentials");
    }

}
