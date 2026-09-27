package com.kredily.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By homeHeader = AppiumBy.xpath("//android.widget.TextView[contains(@text,'QA') or contains(@text,'Assessment') or contains(@text,'Home')]");
    private final By shiftSection = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Shift') or contains(@text,'General Shift')]");
    private final By approvalsSection = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Approvals') or contains(@text,'Approval')]");
    private final By teamTodaySection = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Team Today') or contains(@text,'Team')]");
    private final By thisWeekSection = AppiumBy.xpath("//android.widget.TextView[contains(@text,'This Week') or contains(@text,'Weekly')]");
    private final By quickActionsSection = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Quick Actions') or contains(@text,'Actions')]");
    
    // Bottom Navigation
    private final By attendanceTab = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Attendance')]");
    private final By allActionsTab = AppiumBy.xpath("//android.widget.TextView[contains(@text,'All actions') or contains(@text,'Actions') or contains(@text,'More')]");

    public DashboardPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isHomeDashboardLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(homeHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isShiftSectionDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(shiftSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isApprovalsSectionDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(approvalsSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTeamTodaySectionDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(teamTodaySection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isThisWeekSectionDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(thisWeekSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isQuickActionsDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(quickActionsSection)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateToAttendance() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(attendanceTab));
        tab.click();
    }

    public void navigateToAllActions() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(allActionsTab));
        tab.click();
    }
}
