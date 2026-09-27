package com.kredily.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By emailOrMobileField = AppiumBy.xpath("//android.widget.EditText[contains(@text,'Email') or contains(@hint,'Email') or @index='0']");
    private final By continueButton = AppiumBy.xpath("//android.widget.Button[@text='Continue' or contains(@text,'Continue')]");
    private final By passwordField = AppiumBy.xpath("//android.widget.EditText[contains(@text,'Password') or @password='true']");
    private final By signInButton = AppiumBy.xpath("//android.widget.Button[@text='Sign in' or contains(@text,'Sign in')]");
    private final By errorMessageText = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Incorrect password') or contains(@text,'attempts remaining') or contains(@text,'Enter your email')]");
    private final By unverifiedAccountText = AppiumBy.xpath("//android.widget.TextView[contains(@text,'not yet verified')]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterEmailOrMobile(String email) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(emailOrMobileField));
        input.clear();
        input.sendKeys(email);
    }

    /**
     * Taps Continue. Handles BUG-005 where a second tap is required
     * if the soft keyboard only was dismissed on the first tap.
     */
    public void clickContinue() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        btn.click();
        
        // Resilience check for BUG-005: if password field did not appear within 2 seconds, tap again
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        } catch (Exception e) {
            try {
                if (driver.findElements(continueButton).size() > 0) {
                    driver.findElement(continueButton).click();
                }
            } catch (Exception ignored) {
            }
        }
    }

    public void enterPassword(String password) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        input.clear();
        input.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        btn.click();
    }

    public void performLogin(String email, String password) {
        enterEmailOrMobile(email);
        clickContinue();
        enterPassword(password);
        clickSignIn();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageText)).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
