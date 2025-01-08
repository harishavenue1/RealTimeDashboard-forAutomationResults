package com.tmb.tests;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.listeners.TestListener;
import com.tmb.pages.LoginPage;
import com.tmb.testdata.TestData;
import com.tmb.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class HomePageTest extends BaseTest {

    @FrameworkAnnotation
    @Test(description = "To check whether the user the title of orangehrm website homepage is displayed correctly",
            dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void titleValidationTest(TestData testdata) {
        LoginPage loginPage = new LoginPage();
        String actualTitle = loginPage
                .loginToApplication(testdata.username, testdata.password)
                .waitForHomePageHeader()
                .getHomePageTitle();

        System.out.println("Actual Title is "+ actualTitle);
        Assert.assertEquals(actualTitle, testdata.expectedTitle);
    }

    @FrameworkAnnotation(author = "Harish")
    @Test(description = "To check whether the user login fails to validate the invalid credentials message displayed correctly")
    public void titleInvalidationTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication("admin", "admin1234");
        String actualTitle = loginPage.getInvalidLoginMessage();

        System.out.println("Actual Title is "+ actualTitle);
        Assert.assertEquals(actualTitle, "Invalid credentials");
    }
}