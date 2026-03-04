package pages;

import utils.waithelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private waithelper wait;

    // Locators (Keep Private)

    private By usernameField = By.name("email");
    private By passwordField = By.name("password");
    private By nextButton = By.xpath("//button[@class='authentication--button__next']");
    private By loginButton = By.id("next");
    private By addDeviceButton = By.xpath("//button[contains(@class,'primaryBtn')]");
    private By dashboardMenu = By.xpath("//div[normalize-space()='Dashboard']");
    private By invalidMessage = By.xpath("//span[text()='Invalid credentials']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new waithelper(driver, 10);
    }

    // ========================
    // Actions
    // ========================

    public void enterUsername(String username) {
        wait.waitforelement(usernameField).clear();
        wait.waitforelement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.waitforelement(passwordField).clear();
        wait.waitforelement(passwordField).sendKeys(password);
    }

    public void clickNext() {
        wait.waitforclick(nextButton).click();
    }

    public void clickLogin() {
        wait.waitforclick(loginButton).click();
    }

    public void clickAddDevice() {
        wait.waitforclick(addDeviceButton).click();
    }

    public void goToDashboard() {
        wait.waitforclick(dashboardMenu).click();
    }

    // Business Methods

    public void loginToApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickNext();
        clickLogin();
    }

    // Validations

    public String getInvalidCredentialsMessage() {
        return wait.waitforelement(invalidMessage).getText().trim();
    }
}