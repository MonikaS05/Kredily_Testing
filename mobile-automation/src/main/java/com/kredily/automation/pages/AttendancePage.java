package com.kredily.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AttendancePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By clockInButton = AppiumBy.xpath("//android.widget.Button[contains(@text,'Clock In') or contains(@text,'Punch In')]");
    private final By clockOutButton = AppiumBy.xpath("//android.widget.Button[contains(@text,'Clock Out') or contains(@text,'Punch Out')]");
    private final By confirmationDoneBtn = AppiumBy.xpath("//android.widget.Button[@text='Done' or contains(@text,'Done')]");
    private final By clockedInTimer = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Clocked in') or contains(@text,'hrs') or contains(@text,'timer')]");
    private final By teamTab = AppiumBy.xpath("//android.widget.TextView[@text='Team' or contains(@text,'Team')]");
    private final By meTab = AppiumBy.xpath("//android.widget.TextView[@text='Me' or contains(@text,'Me')]");

    public AttendancePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickClockIn() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(clockInButton));
        btn.click();
    }

    public void confirmClockIn() {
        try {
            WebElement done = wait.until(ExpectedConditions.elementToBeClickable(confirmationDoneBtn));
            done.click();
        } catch (Exception ignored) {
        }
    }

    public boolean isClockedIn() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(clockedInTimer)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickClockOut() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(clockOutButton));
        btn.click();
        confirmClockIn();
    }

    public void switchToTeamTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(teamTab));
        tab.click();
    }

    public void switchToMeTab() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(meTab));
        tab.click();
    }
}
