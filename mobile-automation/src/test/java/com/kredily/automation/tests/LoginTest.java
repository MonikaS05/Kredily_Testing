package com.kredily.automation.tests;

import com.kredily.automation.base.BaseTest;
import com.kredily.automation.pages.DashboardPage;
import com.kredily.automation.pages.LoginPage;
import com.kredily.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "AUTO-001: Verify registered employee can authenticate and reach Home/Dashboard")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        String email = ConfigReader.get("test.user.email");
        String password = ConfigReader.get("test.user.password");

        loginPage.performLogin(email, password);

        Assert.assertTrue(dashboardPage.isHomeDashboardLoaded(), 
                "Dashboard should load successfully after valid login.");
    }

    @Test(description = "AUTO-002: Verify invalid password input is rejected with appropriate validation")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        String email = ConfigReader.get("test.user.email");
        String invalidPassword = ConfigReader.get("test.invalid.password");

        loginPage.enterEmailOrMobile(email);
        loginPage.clickContinue();
        loginPage.enterPassword(invalidPassword);
        loginPage.clickSignIn();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), 
                "Error message should be displayed for invalid credentials.");
    }
}
