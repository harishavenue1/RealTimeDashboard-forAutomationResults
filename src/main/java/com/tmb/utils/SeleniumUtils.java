package com.tmb.utils;

import com.tmb.config.ConfigFactory;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitType;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class SeleniumUtils {

    private SeleniumUtils(){}

    public static void click(By by, String elementName){
        WebElement element = waitUntilElementPresent(by);
        element.click();
        ExtentLogger.info(elementName + " is clicked successfully");
    }

    public static void click(WebElement element){
        element.click();
    }

    public static void click(By by, WaitType waitType){
        WebElement element = null;
        if(waitType == WaitType.PRESENCE){
            element = waitUntilElementPresent(by);
        } else if(waitType == WaitType.CLICKABLE){
            element = waitUntilElementToBeClickable(by);
        } else if(waitType == WaitType.VISIBLE){
            element = waitUntilElementToBeVisible(by);
        }
        assert element != null;
        element.click();
    }

    public static void sendKeys(By by, String value, String elementName){
        WebElement element = waitUntilElementPresent(by);
        element.sendKeys(value);
        ExtentLogger.info(value + " is entered "+ " successfully in "+elementName);
    }

    public static WebElement waitForElement(By by, String elementName){
        WebElement element = waitUntilElementPresent(by);
        ExtentLogger.info(elementName + " is available");
        return element;
    }

    private static WebElement waitUntilElementToBeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private static WebElement waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
