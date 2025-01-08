package com.tmb.driver;

import com.tmb.config.ConfigFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class RemoteDriverFactory {

    private RemoteDriverFactory() {}

    @SneakyThrows
    public static WebDriver getRemoteDriver(String browserName) {
        DesiredCapabilities cap = new DesiredCapabilities();
        if (browserName.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
        } else if (browserName.equalsIgnoreCase("edge")) {
            cap.setBrowserName("edge");
        } else {
            cap.setBrowserName("firefox");
        }
        return new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteUrl()), cap);
    }
}
