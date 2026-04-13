package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String name) {
        // image save in target folder
        String fileName = name + ".png";
        String destination = System.getProperty("user.dir") + "/target/" + fileName;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(destination));
        } catch (IOException e) {
            System.out.println("Screenshot Capture Failed: " + e.getMessage());
        }

        // return only image name
        return fileName;
    }
}