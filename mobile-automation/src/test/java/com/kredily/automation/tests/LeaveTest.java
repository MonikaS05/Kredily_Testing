package com.kredily.automation.tests;

import com.kredily.automation.base.BaseTest;
import com.kredily.automation.pages.DashboardPage;
import com.kredily.automation.pages.LeavePage;
import com.kredily.automation.pages.LoginPage;
import com.kredily.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    @Test(description = "AUTO-005: Verify employee can submit a valid leave request and verify Pending status")
    public void testLeaveApplicationJourney() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        LeavePage leavePage = new LeavePage(driver);

        loginPage.performLogin(ConfigReader.get("test.user.email"), ConfigReader.get("test.user.password"));

        dashboardPage.navigateToAllActions();
        leavePage.clickApply();
        leavePage.selectCasualLeave();
        leavePage.enterReason("Personal work");
        leavePage.clickSubmit();

        leavePage.navigateToMyRequests();

        Assert.assertTrue(leavePage.isPendingRequestVisible(), 
                "Submitted leave request should appear in My Requests with Pending status.");
    }
}
