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

    // ---------- Locators (verified from real screen dumps) ----------
    // Screen 1: email / mobile
    private final By emailOrMobileField = AppiumBy.xpath("//*[@resource-id='auth-ident']");
    private final By continueButton = AppiumBy.xpath("//*[@resource-id='auth-continue']");
    private final By signInWithPasswordButton = AppiumBy.xpath("//*[@resource-id='auth-alt']");

    // Screen 2: password
    private final By passwordScreenTitle = AppiumBy.xpath("//android.widget.TextView[@text='Enter password']");
    private final By passwordField = AppiumBy.xpath("//*[@resource-id='auth-pass']");
    private final By signInButton = AppiumBy.xpath("//*[@resource-id='auth-signin']");
    private final By backButton = AppiumBy.xpath("//*[@resource-id='auth-back']");

    // NOT yet verified - need a dump of the screen after a wrong password
    private final By errorMessageText = AppiumBy.xpath("//android.widget.TextView[contains(@text,'Incorrect password') or contains(@text,'attempts remaining') or contains(@text,'Enter your email') or contains(@text,'Invalid')]");
    private final By unverifiedAccountText = AppiumBy.xpath("//android.widget.TextView[contains(@text,'not yet verified')]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterEmailOrMobile(String email) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(emailOrMobileField));
        input.click();
        input.clear();
        input.sendKeys(email);
    }
    public boolean isLoginScreenDisplayed() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(emailOrMobileField))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void loginIfNeeded(String email, String password) {
        if (isLoginScreenDisplayed()) {
            performLogin(email, password);
        }
    }
    /**
     * Taps "Sign in with password" to open the password screen.
     * Handles BUG-005 (a second tap is sometimes needed): if the password
     * screen has not appeared within 2 seconds, tap once more.
     */
    public void clickSignInWithPassword() {
        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {
        }

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(signInWithPasswordButton));
        btn.click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        } catch (Exception e) {
            try {
                if (!driver.findElements(signInWithPasswordButton).isEmpty()) {
                    driver.findElement(signInWithPasswordButton).click();
                }
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * Kept so existing tests that call clickContinue() still compile.
     * The password flow goes through "Sign in with password", so this delegates to it.
     */
    public void clickContinue() {
        clickSignInWithPassword();
    }

    public void enterPassword(String password) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        input.click();
        input.clear();
        input.sendKeys(password);
    }

    public void clickSignIn() {
        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {
        }
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        btn.click();
    }

    public void performLogin(String email, String password) {
        enterEmailOrMobile(email);
        clickSignInWithPassword();
        enterPassword(password);
        clickSignIn();
    }

    public boolean isPasswordScreenDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordScreenTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
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