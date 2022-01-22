package pages;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class DashboardPage {
    @FindBy(id = "projects")
    WebElement projectList;

    @FindBy(xpath = "//*[contains(text(), 'Dodaj nowy projekt')]/parent::div[@class='card-body']")
    WebElement addProjectButton;

    public DashboardPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isProjectsDisplayed() {
        WaitForElement.waitUntilElementIsVisible(projectList);

        return projectList.isDisplayed();
    }

    public AddProjectPage clickAddProject() {
        WaitForElement.waitUntilElementIsClickable(addProjectButton);

        addProjectButton.click();

        //Waiting until Add project page loads
        WaitForElement.waitUntilElementIsVisible(DriverManager.getWebDriver().findElement(By.id("template")));

        return new AddProjectPage();
    }
}
