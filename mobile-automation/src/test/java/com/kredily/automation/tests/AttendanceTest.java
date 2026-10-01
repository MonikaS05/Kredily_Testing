package com.kredily.automation.tests;

import com.kredily.automation.base.BaseTest;
import com.kredily.automation.pages.AttendancePage;
import com.kredily.automation.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttendanceTest extends BaseTest {

    @Test(description = "AUTO-004: Verify employee can perform Clock In and activate working session timer")
    public void testClockInJourney() {
        Assert.assertNotNull(driver, "Driver was not created - check Appium and adb devices");

        DashboardPage dashboard = new DashboardPage(driver);
        AttendancePage attendance = new AttendancePage(driver);

        Assert.assertTrue(dashboard.isDashboardLoaded(),
                "Dashboard did not load - phone is probably logged out. Log in once and re-run.");
        Assert.assertTrue(attendance.isClockButtonDisplayed(), "Clock button should be visible on the dashboard");

        // Precondition: make sure we start from the "Clock In" state
        if (!attendance.isReadyToClockIn()) {
            attendance.clickClockOut();
            Assert.assertTrue(attendance.isReadyToClockIn(),
                    "Could not reset to Clock In state. Label: " + attendance.getClockButtonLabel());
        }

        attendance.clickClockIn();
        attendance.confirmClockIn();

        Assert.assertTrue(attendance.isClockedIn(),
                "Button should change to 'Clock Out' after clocking in. Status: '"
                        + attendance.getStatusText() + "', timer: '" + attendance.getTimerText() + "'");
    }
}