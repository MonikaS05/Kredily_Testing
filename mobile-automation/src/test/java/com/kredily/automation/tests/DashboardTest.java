package com.kredily.automation.tests;

import com.kredily.automation.base.BaseTest;
import com.kredily.automation.pages.DashboardPage;
import com.kredily.automation.pages.LoginPage;
import com.kredily.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(description = "AUTO-003: Verify critical Home dashboard sections load after successful login")
    public void testDashboardSections() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.performLogin(ConfigReader.get("test.user.email"), ConfigReader.get("test.user.password"));

        Assert.assertTrue(dashboardPage.isHomeDashboardLoaded(), "Home Dashboard must be visible.");
        Assert.assertTrue(dashboardPage.isShiftSectionDisplayed(), "Shift section must be visible.");
        Assert.assertTrue(dashboardPage.isApprovalsSectionDisplayed(), "Approvals section must be visible.");
        Assert.assertTrue(dashboardPage.isTeamTodaySectionDisplayed(), "Team Today section must be visible.");
        Assert.assertTrue(dashboardPage.isThisWeekSectionDisplayed(), "This Week attendance section must be visible.");
        Assert.assertTrue(dashboardPage.isQuickActionsDisplayed(), "Quick Actions section must be visible.");
    }
}
