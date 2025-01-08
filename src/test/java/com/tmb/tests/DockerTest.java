package com.tmb.tests;

import com.tmb.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DockerTest {

//    @Test
//    public void dataSupplierTest() throws MalformedURLException {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setBrowserName("chrome");
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://opensource-demo.orangehrmlive.com/");
//        System.out.println(driver.getTitle());
//        driver.quit();
//    }
}
