package com.tmb.driver;

import com.tmb.config.ConfigFactory;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public final class Driver { //IS A relationship

    private Driver(){}

    public static void initDriver(){
        String browser = ConfigFactory.getConfig().browser();
        String runMode = ConfigFactory.getConfig().runMode();

        if(DriverManager.getDriver() == null) {
            WebDriver driver = DriverFactory.getDriver(runMode, browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);//presence of element in the dom
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
        }
    }

    public static void quitDriver(){
        if(DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
    }
}
