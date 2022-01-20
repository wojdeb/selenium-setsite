package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LandingPage;
import pages.LoginPage;
import utils.TestBase;

public class LoginTest extends TestBase {

    @Test
    public void asUserTryToLogin() {
        LandingPage landingPage = new LandingPage();
        LoginPage loginPage = landingPage.goToLoginPage();

        loginPage.setUsername("Tester_automatyczny");
        loginPage.setPassword("Test123!");
        DashboardPage dashboardPage = loginPage.login();

        Assert.assertTrue(dashboardPage.isProjectsDisplayed());
    }
}
