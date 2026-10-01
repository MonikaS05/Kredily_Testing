package com.kredily.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private static By rid(String resourceId) {
        return AppiumBy.xpath("//*[@resource-id='" + resourceId + "']");
    }

    private static By text(String exactText) {
        return AppiumBy.xpath("//android.widget.TextView[@text='" + exactText + "']");
    }

    // ---------- Locators (verified from the real dashboard dump) ----------
    // Header
    private final By greeting = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Good ')]");
    private final By shiftTiming = AppiumBy.xpath("//android.widget.TextView[starts-with(@text,'Shift ')]");

    // Shift / clock card
    private final By shiftCard = rid("hm-hero");
    private final By shiftLabel = text("Shift");
    private final By clockButton = rid("hm-clockbtn");

    // Needs you / approvals
    private final By needsCard = rid("hm-needs");
    private final By approvalsRow = rid("ny-row-apv");

    // Team today
    private final By teamCard = rid("hm-team");
    private final By teamIn = rid("hm-team-IN");
    private final By teamLate = rid("hm-team-L");
    private final By teamLeave = rid("hm-team-LV");
    private final By teamAbsent = rid("hm-team-A");

    // This week
    private final By weekCard = rid("hm-weekcard");
    private final By weekSummary = rid("hm-week-m");
    private final By weekDays = rid("hm-week");

    // Quick actions
    private final By quickActionsTitle = text("Quick actions");
    private final By quickActions = rid("hm-qa");
    private final By qaAttendance = rid("qa-attendance");
    private final By qaApprovals = rid("qa-approvals");
    private final By qaDirectory = rid("qa-directory");
    private final By qaPayslips = rid("qa-payslips");
    private final By qaMore = rid("qa-more");

    // Bottom tabs
    private final By tabHome = rid("tab-home");
    private final By tabApprovals = rid("tab-approvals");
    private final By tabAttendance = rid("tab-attendance");
    private final By tabDirectory = rid("tab-directory");
    private final By tabProfile = rid("tab-profile");

    public DashboardPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private boolean isVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    // Kept for LoginTest (AUTO-001) - same check as isDashboardLoaded()
    public boolean isHomeDashboardLoaded() {
        return isDashboardLoaded();
    }

    // Kept for LeaveTest (AUTO-005) - opens the full actions list via "More"
    public void navigateToAllActions() {
        wait.until(ExpectedConditions.elementToBeClickable(qaMore)).click();
    }
    public boolean isDashboardLoaded() { return isVisible(shiftCard); }
    public boolean isGreetingDisplayed() { return isVisible(greeting); }
    public boolean isShiftTimingDisplayed() { return isVisible(shiftTiming); }
    public boolean isShiftCardDisplayed() { return isVisible(shiftCard) && isVisible(shiftLabel); }
    public boolean isClockButtonDisplayed() { return isVisible(clockButton); }
    public boolean isNeedsYouDisplayed() { return isVisible(needsCard); }
    public boolean isApprovalsRowDisplayed() { return isVisible(approvalsRow); }
    public boolean isTeamTodayDisplayed() {
        return isVisible(teamCard) && isVisible(teamIn) && isVisible(teamLate)
                && isVisible(teamLeave) && isVisible(teamAbsent);
    }
    public boolean isThisWeekDisplayed() {
        return isVisible(weekCard) && isVisible(weekSummary) && isVisible(weekDays);
    }
    public boolean isQuickActionsDisplayed() {
        return isVisible(quickActionsTitle) && isVisible(quickActions)
                && isVisible(qaAttendance) && isVisible(qaApprovals)
                && isVisible(qaDirectory) && isVisible(qaPayslips) && isVisible(qaMore);
    }
    public boolean isBottomNavDisplayed() {
        return isVisible(tabHome) && isVisible(tabApprovals) && isVisible(tabAttendance)
                && isVisible(tabDirectory) && isVisible(tabProfile);
    }
    public boolean isHomeTabSelected() {
        try {
            return "true".equals(wait.until(ExpectedConditions.visibilityOfElementLocated(tabHome))
                    .getAttribute("selected"));
        } catch (Exception e) {
            return false;
        }
    }

    // Navigation helpers (useful for the Attendance and Leave journeys later)
    public void openAttendance() {
        wait.until(ExpectedConditions.elementToBeClickable(tabAttendance)).click();
    }
    public void clickClockButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clockButton)).click();
    }
}