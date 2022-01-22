package pages;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.thread.ThreadUtil;
import utils.enums.ColorEnum;
import utils.enums.TemplateEnum;
import waits.WaitForElement;

public class AddProjectPage {
    @FindBy(id = "template")
    WebElement templateSelect;

    @FindBy(id = "color")
    WebElement colorSelect;

    @FindBy(id = "title")
    WebElement projectTitleInput;

    @FindBy(id = "fb")
    WebElement facebookLinkInput;

    @FindBy(id = "insta")
    WebElement instagramLinkInput;

    @FindBy(id = "ln")
    WebElement linkedinLinkInput;

    @FindBy(id = "tw")
    WebElement twitterLinkInput;

    @FindBy(id = "tel")
    WebElement telephoneNumberInput;

    @FindBy(id = "mail")
    WebElement emailInput;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    public AddProjectPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void chooseTemplate(TemplateEnum templateEnum) {
        WaitForElement.waitUntilElementIsVisible(templateSelect);

        templateSelect.findElement(By.xpath(String.format("//option[@value='%s']", templateEnum.getValue())))
                .click();
    }

    public void chooseColor(ColorEnum colorEnum) {
        colorSelect.findElement(By.id(colorEnum.getValue()))
                .click();
    }

    public void setProjectTitle(String projectTitle) {
        projectTitleInput.sendKeys(projectTitle);
    }

    public void setFacebookLink(String facebookLink) {
        facebookLinkInput.sendKeys(facebookLink);
    }

    public void setInstagramLink(String instagramLink) {
        instagramLinkInput.sendKeys(instagramLink);
    }

    public void setLinkedinLink(String linkedinLink) {
        linkedinLinkInput.sendKeys(linkedinLink);
    }

    public void setTwitterLink(String twitterLink) {
        twitterLinkInput.sendKeys(twitterLink);
    }

    public void setTelephoneNumber(String telephoneNumber) {
        telephoneNumberInput.sendKeys(telephoneNumber);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public ProjectPreviewPage clickSubmit() {
        WaitForElement.waitUntilElementIsVisible(submitButton);
        WaitForElement.waitUntilElementIsClickable(submitButton);

        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getWebDriver();
        jse.executeScript("arguments[0].click()", submitButton);

//        submitButton.click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DriverManager.getWebDriver().switchTo().alert().accept();

        WaitForElement.waitUntilElementIsVisible(DriverManager.getWebDriver().findElement(By.xpath("//table/thead[@class='table-dark']")));

        return new ProjectPreviewPage();
    }
}
