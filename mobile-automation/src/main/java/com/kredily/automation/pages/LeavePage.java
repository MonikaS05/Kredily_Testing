package com.kredily.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeavePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By applyButton = AppiumBy.xpath("//android.widget.Button[contains(@text,'Apply') or contains(@text,'+ Apply')]");
    private final By leaveTypeSelector = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Casual') or contains(@text,'Select leave type')]");
    private final By casualLeaveOption = AppiumBy.xpath("//android.widget.TextView[@text='Casual Leave' or contains(@text,'Casual Leave')]");
    private final By reasonField = AppiumBy.xpath("//android.widget.EditText[contains(@hint,'Reason') or contains(@text,'Reason')]");
    private final By submitRequestBtn = AppiumBy.xpath("//android.widget.Button[contains(@text,'Submit') or contains(@text,'Submit request')]");
    private final By myRequestsTab = AppiumBy.xpath("//android.widget.TextView[@text='My requests' or contains(@text,'My requests')]");
    private final By pendingStatusBadge = AppiumBy.xpath("//android.widget.TextView[@text='Pending' or contains(@text,'Pending')]");
    private final By validationMessage = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Add a reason') or contains(@text,'least 15 day') or contains(@text,'available')]");

    public LeavePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickApply() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        btn.click();
    }

    public void selectCasualLeave() {
        try {
            WebElement selector = wait.until(ExpectedConditions.elementToBeClickable(leaveTypeSelector));
            selector.click();
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(casualLeaveOption));
            option.click();
        } catch (Exception ignored) {
        }
    }

    public void enterReason(String reason) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(reasonField));
        field.clear();
        field.sendKeys(reason);
    }

    public void clickSubmit() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(submitRequestBtn));
        btn.click();
    }

    public void navigateToMyRequests() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(myRequestsTab));
        tab.click();
    }

    public boolean isPendingRequestVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(pendingStatusBadge)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getValidationMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(validationMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
