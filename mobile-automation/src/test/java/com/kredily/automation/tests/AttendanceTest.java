package com.kredily.automation.tests;

import com.kredily.automation.base.BaseTest;
import com.kredily.automation.pages.AttendancePage;
import com.kredily.automation.pages.LoginPage;
import com.kredily.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttendanceTest extends BaseTest {

    @Test(description = "AUTO-004: Verify employee can perform Clock In and activate working session timer")
    public void testClockInJourney() {
        LoginPage loginPage = new LoginPage(driver);
        AttendancePage attendancePage = new AttendancePage(driver);

        loginPage.performLogin(ConfigReader.get("test.user.email"), ConfigReader.get("test.user.password"));

        attendancePage.clickClockIn();
        attendancePage.confirmClockIn();

        Assert.assertTrue(attendancePage.isClockedIn(), 
                "Working timer/Clocked-in state should be displayed after clocking in.");
    }
}
