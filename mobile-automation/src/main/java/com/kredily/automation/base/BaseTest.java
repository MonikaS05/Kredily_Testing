package com.kredily.automation.base;

import com.kredily.automation.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(ConfigReader.get("device.name"));
            options.setPlatformName(ConfigReader.get("platform.name"));
            options.setPlatformVersion(ConfigReader.get("platform.version"));
            options.setAutomationName(ConfigReader.get("automation.name"));
            options.setAppPackage(ConfigReader.get("app.package"));
            options.setAppActivity(ConfigReader.get("app.activity"));
            options.setAutoGrantPermissions(Boolean.parseBoolean(ConfigReader.get("auto.grant.permissions")));

            String appPath = ConfigReader.get("app.path");
            if (appPath != null && !appPath.trim().isEmpty()) {
                options.setApp(appPath);
            }

            String serverUrl = ConfigReader.get("appium.server.url");
            driver = new AndroidDriver(new URL(serverUrl), options);

            int explicitWaitSec = ConfigReader.getInt("explicit.wait", 15);
            wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWaitSec));

            int implicitWaitSec = ConfigReader.getInt("implicit.wait", 10);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSec));
        } catch (Exception e) {
            System.err.println("Driver initialization failed or Appium server offline: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
            }
        }
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator) {
        waitForClickable(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
