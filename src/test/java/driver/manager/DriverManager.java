package driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager(){}

    public static WebDriver getWebDriver() {
        if (driver == null) {
            String pathToChromedriver =
                    "src" + File.separator + "main" + File.separator + "resources" + File.separator + "drivers" + File.separator + "chromedriver";
            System.setProperty("webdriver.chrome.driver", pathToChromedriver);
            driver = new ChromeDriver();
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }
}