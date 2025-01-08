package com.tmb.tests;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.driver.DriverManager;
import com.tmb.pages.LoginPage;
import com.tmb.testdata.TestData;
import com.tmb.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest{

    @FrameworkAnnotation(author = "Harish")
    @Test(description = "To Validate Title for Invalid Login - Test1")
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication("abcd1","efgh1");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "OrangeHRM");
    }

    @FrameworkAnnotation
    @Test(description = "To Validate Title for Invalid Login - Test2",dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test2(TestData testdata){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication(testdata.username, testdata.password);
        Assert.assertEquals(DriverManager.getDriver().getTitle(), testdata.expectedTitle);
    }

    @FrameworkAnnotation
    @Test(description = "To Validate Title for Invalid Login - Test3")
    public void test3(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication("abcd2","efgh2");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "OrangeHRM");
    }

    @FrameworkAnnotation
    @Test(description = "To Validate Title for Invalid Login - Test4")
    public void test4(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication("abcd3","efgh3");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "OrangeHRM");
    }
}
