package pages;

import driver.manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class ProjectPreviewPage {

    public ProjectPreviewPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
