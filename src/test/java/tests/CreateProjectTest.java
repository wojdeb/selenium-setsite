package tests;

import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProjectPreviewPage;
import utils.TestBase;
import utils.enums.ColorEnum;
import utils.enums.TemplateEnum;

public class CreateProjectTest extends TestBase {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;
    private ProjectPreviewPage projectPreviewPage;

    @Test
    public void createProjectTest() {
        //GIVEN
        loginToSetsite();

        //WHEN
        clickAddProject();
        setUpNewProject();
        clickSubmit();

        //THEN
        shouldProjectBeProperlyCreated();
    }

    private void loginToSetsite() {
        LandingPage landingPage = new LandingPage();
        LoginPage loginPage = landingPage.goToLoginPage();

        loginPage.setUsername("Tester_automatyczny");
        loginPage.setPassword("Test123!");
        dashboardPage = loginPage.login();
    }

    private void clickAddProject() {
        addProjectPage = dashboardPage.clickAddProject();
    }

    private void setUpNewProject() {
        addProjectPage.chooseTemplate(TemplateEnum.COLUMN_TEMPLATE);
        addProjectPage.chooseColor(ColorEnum.BLUE);
        addProjectPage.setProjectTitle("Automated Project");
        addProjectPage.setFacebookLink("https://facebook.com/sampleFBPage");
        addProjectPage.setInstagramLink("https://instagram.com/sampleInstagramAccount");
        addProjectPage.setLinkedinLink("https://linkedin.com/sampleLinkedinAccount");
        addProjectPage.setTwitterLink("https://twitter.com/sampleTwitterPage");
        addProjectPage.setTelephoneNumber("123456789");
        addProjectPage.setEmail("automatedUser@example.com");
    }

    private void clickSubmit() {
        projectPreviewPage = addProjectPage.clickSubmit();
    }

    private void shouldProjectBeProperlyCreated() {
        //TODO: ASSERTIONS HERE
    }
}
