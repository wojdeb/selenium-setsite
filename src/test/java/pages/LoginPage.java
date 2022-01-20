package pages;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(xpath = "//button[contains(text(), 'Zaloguj')]")
    WebElement submitButton;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void setUsername(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
    }

    public DashboardPage login() {
        WaitForElement.waitUntilElementIsClickable(submitButton);
        submitButton.click();

        WaitForElement.waitUntilElementIsVisible(DriverManager.getWebDriver().findElement(By.id("projects")));

        return new DashboardPage();
    }
}
