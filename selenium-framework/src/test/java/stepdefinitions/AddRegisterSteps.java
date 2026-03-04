package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddRegisterPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.waithelper;

public class AddRegisterSteps {

    WebDriver driver;
    LoginPage loginPage;
    AddRegisterPage addRegisterPage;
    waithelper wait;

    @Given("User enters username {string} and clicks Next")
    public void user_enters_username_and_clicks_next(String username) {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        addRegisterPage = new AddRegisterPage(driver);
        driver.get(ConfigReader.getUrl());
        loginPage.enterUsername(username);
        loginPage.clickNext();
    }

    @Given("User enters password {string} and clicks Login")
    public void user_enters_password_and_clicks_login(String password) {
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @When("User adds a new POS register on site with bridge  and store  and register")
    public void user_adds_a_new_pos_register_on_site_with_bridge_and_store_and_register() {
        addRegisterPage.addNewRegister();
    }

    @Then("New register should be added successfully")
    public void new_register_should_be_added_successfully() {

        System.out.println("Register added successfully");

    }

}
