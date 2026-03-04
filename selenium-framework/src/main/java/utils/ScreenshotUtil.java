package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String screenshotPath = null;

        try {
            // Create timestamp
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Create folder if not exists
            File directory = new File("target/screenshots/");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Take screenshot
            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            screenshotPath = "target/screenshots/"
                    + testName + "_" + timestamp + ".png";

            File destination = new File(screenshotPath);

            FileHandler.copy(source, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}