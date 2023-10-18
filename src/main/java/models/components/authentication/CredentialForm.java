package models.components.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CredentialForm {
    //Creating appium driver instance
    private AppiumDriver<MobileElement> appiumDriver;

    //Creating a constructor
    public CredentialForm(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    //Defining the locators, final is used because we are not modifying these selectors
    private final By usernameSelByID = MobileBy.AccessibilityId("input-email");
    private final By passwordSelByID = MobileBy.AccessibilityId("input-password");



    public MobileElement username() {
        return appiumDriver.findElement(usernameSelByID);
    }
    public MobileElement password() {
        return appiumDriver.findElement(passwordSelByID);
    }
    public CredentialForm inputUsername(String usernameText){
        this.username().sendKeys(usernameText);
        return this; //returns the instance for the page
    }
    public CredentialForm inputPassword(String passwordText){
        this.password().sendKeys(passwordText);
        return this; //returns the instance for the page
    }
}
