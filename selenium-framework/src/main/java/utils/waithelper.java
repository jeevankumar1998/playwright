package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waithelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public waithelper(WebDriver driver, int time) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public WebElement waitforelement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitforclick(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void launch(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeSelected(ele));

    }

    public Boolean invisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}
