package pages;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class DashboardPage {
    @FindBy(id = "projects")
    WebElement projectList;

    public DashboardPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isProjectsDisplayed() {
        WaitForElement.waitUntilElementIsVisible(projectList);

        return projectList.isDisplayed();
    }
}
