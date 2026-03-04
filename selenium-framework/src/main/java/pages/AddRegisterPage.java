package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.DriverFactory;
import utils.waithelper;

public class AddRegisterPage {

    private WebDriver driver;
    private waithelper wait;

    // Locators

    private By dashboardMenu = By.xpath("//div[text()=' Dashboard ']");
    private By addButton = By.xpath("//button[contains(@class,'d-flex align-center een-button primaryBtn')]");
    private By addPosRegisterOption = By
            .xpath("//div[@class='v-menu__content theme--light menuable__content__active drop-down-menu']/div[7]");
    private By plusIcon = By.xpath("//button[@class='mx-1 een-button isIcon hasAppendIcon']");

    private By siteDropdown = By.xpath("//div[@class='v-input__slot']/preceding::div[@class='v-input__control']");
    private By selectSiteOption = By.xpath("//div[text()='Dont delete']");

    private By bridgeDropdown = By.xpath("//div[@class='ma-4']");
    private By selectBridgeOption = By.xpath("//div[text()='711 Test']");

    private By storeToggle = By
            .xpath("//button[@class='v-icon notranslate v-treeview-node__toggle v-icon--link theme--light']");
    private By registerCheckbox = By
            .xpath("//div[@data-testid='pos-registers-sidebar-register-list-item-checkbox:01']");

    private By addRegisterUnderBridge = By.xpath("//button[@class='een-button accentBtn']");

    private By cameraDropdown = By
            .xpath("//label[text()='Select Camera']/following::div[contains(@class,'v-input__icon--append')][1]");
    private By selectCamera = By.xpath("//div[text()='EN-CDUM-008']");

    private By finalAddRegisterButton = By.xpath("//button[contains(@class,'depressedBtn')]");

    // Constructor

    public AddRegisterPage(WebDriver driver) {
        driver = DriverFactory.getDriver();
        this.driver = driver;
        this.wait = new waithelper(driver, 10);
    }

    // Navigation Actions

    public void goToDashboard() {
        wait.waitforclick(dashboardMenu).click();
    }

    public void clickAddButton() {
        wait.waitforclick(addButton).click();
    }

    public void selectAddPosRegister() {
        wait.waitforclick(addPosRegisterOption).click();
    }

    public void clickPlusIcon() {
        wait.waitforclick(plusIcon).click();
    }

    // Register Configuration

    public void selectSite() {
        wait.waitforclick(siteDropdown).click();
        wait.waitforclick(selectSiteOption).click();
    }

    public void selectBridge() {
        wait.waitforelement(bridgeDropdown).click();
        wait.waitforclick(selectBridgeOption).click();
    }

    public void selectStoreAndRegister() {
        wait.waitforclick(storeToggle).click();
        wait.waitforclick(registerCheckbox).click();
    }

    public void selectCameraOption() {
        wait.waitforclick(cameraDropdown).click();
        wait.waitforclick(selectCamera).click();
    }

    public void clickAddRegisterUnderAction() {
        wait.waitforclick(addRegisterUnderBridge).click();
    }

    public void clickFinalAddRegister() {
        wait.waitforclick(finalAddRegisterButton).click();
    }

    public void Successmessage() {

    }

    // Business Flow Method

    public void addNewRegister() {

        goToDashboard();
        clickAddButton();
        selectAddPosRegister();
        clickPlusIcon();
        selectSite();
        selectBridge();
        selectStoreAndRegister();
        clickAddRegisterUnderAction();
        selectCameraOption();
        clickFinalAddRegister();
    }

}