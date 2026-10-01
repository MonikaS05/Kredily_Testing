package com.kredily.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AttendancePage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // ---------- Dashboard (verified) ----------
    private final By clockButton = AppiumBy.xpath("//*[@resource-id='hm-clockbtn']");
    private final By clockStatus = AppiumBy.xpath("//*[@resource-id='hm-status']");
    private final By clockTimer = AppiumBy.xpath("//*[@resource-id='hm-timer']");
    private final By clockInState = AppiumBy.xpath("//*[@resource-id='hm-clockbtn' and contains(@content-desc,'Clock In')]");
    private final By clockOutState = AppiumBy.xpath("//*[@resource-id='hm-clockbtn' and contains(@content-desc,'Clock Out')]");

    // ---------- "Verify & confirm" screen (verified from dump) ----------
    private final By verifyScreenTitle = AppiumBy.xpath("//android.widget.TextView[@text='Verify & confirm']");
    // Bottom button reads "✓ Clock In" (or "✓ Clock Out"); it has no resource-id
    private final By verifyConfirmButton = AppiumBy.xpath(
            "//android.widget.Button[contains(@content-desc,'Clock') and not(@resource-id='hm-clockbtn')]");
    private final By verifyCloseButton = AppiumBy.xpath("//*[@content-desc='Close' and @clickable='true']");

    // NOT verified: Team / Me tabs on the Attendance screen
    private final By teamTab = AppiumBy.xpath("//android.widget.TextView[@text='Team' or contains(@text,'Team')]");
    private final By meTab = AppiumBy.xpath("//android.widget.TextView[@text='Me' or contains(@text,'Me')]");

    public AttendancePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private boolean appears(By locator, int seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isClockButtonDisplayed() { return appears(clockButton, 15); }
    public boolean isReadyToClockIn() { return appears(clockInState, 5); }
    public boolean isClockedIn() { return appears(clockOutState, 15); }
    public boolean isVerifyScreenDisplayed() { return appears(verifyScreenTitle, 10); }

    public String getClockButtonLabel() {
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(clockButton));
        return btn.getAttribute("content-desc");
    }

    public String getStatusText() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(clockStatus)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getTimerText() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(clockTimer)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    /** Step 1: tap Clock In on the dashboard (opens the Verify & confirm screen). */
    public void clickClockIn() {
        wait.until(ExpectedConditions.elementToBeClickable(clockInState)).click();
    }

    /** Step 2: on the Verify & confirm screen, tap the bottom "✓ Clock In/Out" button. */
    public void confirmClockIn() {
        if (isVerifyScreenDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(verifyConfirmButton)).click();
        }
    }

    public void closeVerifyScreen() {
        try {
            driver.findElement(verifyCloseButton).click();
        } catch (Exception ignored) {
        }
    }

    public void clickClockOut() {
        wait.until(ExpectedConditions.elementToBeClickable(clockOutState)).click();
        confirmClockIn();
    }

    public void switchToTeamTab() {
        wait.until(ExpectedConditions.elementToBeClickable(teamTab)).click();
    }

    public void switchToMeTab() {
        wait.until(ExpectedConditions.elementToBeClickable(meTab)).click();
    }
}