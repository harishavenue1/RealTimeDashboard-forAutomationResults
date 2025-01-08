package com.tmb.pages;

import org.openqa.selenium.By;

import static com.tmb.utils.SeleniumUtils.*;

public class LoginPage {

    private static final By TXTBOX_USERNAME = By.name("username"); //100 threads //1 txtboxUsername
    private static final By TXTBOX_PASSWORD = By.name("password");
    private static final By BTN_LOGIN = By.xpath("//button");
    private static final By ALERT_INVALID_LOGIN = By.xpath("//*[contains(@class,'alert-content-text')]");

    private LoginPage setUserName(String username){
        sendKeys(TXTBOX_USERNAME,username,"Username");
        return this;
    }
    private LoginPage setPassword(String password){
        sendKeys(TXTBOX_PASSWORD,password,"Password");
        return this;
    }
    private HomePage setLogin(){
        click(BTN_LOGIN, "Login Button");
        return new HomePage(); //page chaining
    }

    public HomePage loginToApplication(String username, String password){ //method chaining
        return setUserName(username)
                .setPassword(password)
                .setLogin();
    }

    public String getInvalidLoginMessage(){
        return waitForElement(ALERT_INVALID_LOGIN, "Invalid Credentials").getText();
    }
}
