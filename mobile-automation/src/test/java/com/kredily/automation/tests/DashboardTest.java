package com.kredily.automation.tests;

import com.kredily.automation.base.BaseTest;
import com.kredily.automation.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashboardTest extends BaseTest {

    @Test(description = "AUTO-003: Dashboard validation (app starts already logged in)")
    public void testDashboardSections() {
        Assert.assertNotNull(driver, "Driver was not created - check Appium server and phone connection (adb devices)");

        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDashboardLoaded(),
                "Dashboard did not load - the phone is probably logged out. Log in once and re-run.");

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(dashboard.isHomeTabSelected(), "Home tab should be selected");
        soft.assertTrue(dashboard.isGreetingDisplayed(), "Greeting should be displayed");
        soft.assertTrue(dashboard.isShiftTimingDisplayed(), "Shift timing should be displayed in the header");
        soft.assertTrue(dashboard.isShiftCardDisplayed(), "Shift card should be displayed");
        soft.assertTrue(dashboard.isClockButtonDisplayed(), "Clock In/Out button should be displayed");
        soft.assertTrue(dashboard.isNeedsYouDisplayed(), "'Needs you' section should be displayed");
        soft.assertTrue(dashboard.isApprovalsRowDisplayed(), "Approvals row should be displayed");
        soft.assertTrue(dashboard.isTeamTodayDisplayed(), "Team today (In/Late/Leave/Absent) should be displayed");
        soft.assertTrue(dashboard.isThisWeekDisplayed(), "'This week' section should be displayed");
        soft.assertTrue(dashboard.isQuickActionsDisplayed(), "Quick actions should be displayed");
        soft.assertTrue(dashboard.isBottomNavDisplayed(), "Bottom navigation tabs should be displayed");
        soft.assertAll();
    }
}