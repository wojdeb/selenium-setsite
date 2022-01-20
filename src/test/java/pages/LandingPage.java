package pages;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {

    @FindBy(xpath = "(//a[contains(text(), 'Zaloguj się')])[1]")
    WebElement loginButton;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage goToLoginPage() {
        WaitForElement.waitUntilElementIsClickable(loginButton);
        loginButton.click();

        WaitForElement.waitUntilElementIsVisible(DriverManager.getWebDriver().findElement(By.id("username")));

        return new LoginPage();
    }
}
