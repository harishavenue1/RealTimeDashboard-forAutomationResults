package com.tmb.pages;

import com.tmb.driver.DriverManager;
import com.tmb.pages.pagecomponent.FooterMenuComponent;
import com.tmb.pages.pagecomponent.TopMenuComponent;
import org.openqa.selenium.By;
import static com.tmb.utils.SeleniumUtils.*;

public class HomePage { // IS A

    // HomePage has TopMenu  --> composition
    // HomepageTest isA Test --> inheritance
    private static final By homePageHeader = By.xpath("//*[contains(@class,'topbar-header')][text()='Dashboard']");

    private final TopMenuComponent topMenuComponent;
    private final FooterMenuComponent footerMenuComponent;
    
    public HomePage(){
        topMenuComponent = new TopMenuComponent();
        footerMenuComponent = new FooterMenuComponent();
    }

    public String getHomePageTitle(){
        return DriverManager.getDriver().getTitle();
    }

    public void clickOnAdmin(){
        topMenuComponent.clickOnMenu("value");
    }

    public String getFooterText(){
        return footerMenuComponent.getFooterLabel();
    }

    public HomePage waitForHomePageHeader(){
        waitForElement(homePageHeader, "homePageHeader");
        return this;
    }
}
