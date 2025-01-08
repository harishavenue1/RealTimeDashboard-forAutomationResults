package com.tmb.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(String runMode, String browserName) {
        WebDriver driver = null;
        if (runMode.equalsIgnoreCase("local")) {
            driver = LocalDriverFactory.getLocalDriver(browserName);
        } else if (runMode.equalsIgnoreCase("remote")) {
            driver = RemoteDriverFactory.getRemoteDriver(browserName);
        }
        return driver;
    }
}
