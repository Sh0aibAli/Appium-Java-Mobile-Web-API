package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.authentication.CredentialForm;
import org.openqa.selenium.By;

public class LoginPageWithComponents {
    //Creating the appium instance
    private AppiumDriver<MobileElement> appiumDriver;
    private CredentialForm credentialForm;
    //Creating a constructor for this class
    public LoginPageWithComponents(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        credentialForm = new CredentialForm(appiumDriver);
    }

    //Defining the locators, final is used because we are not modifying these selectors
    private final By loginBtnSelByID = MobileBy.AccessibilityId("button-LOGIN");

    public MobileElement loginBtn()
    {
        return appiumDriver.findElement(loginBtnSelByID);
    }
    public void clickLoginBtn()
    {  // No need to return the instance at the end of the chain
        this.loginBtn().click();
    }

    public CredentialForm credentialForm(){
        return this.credentialForm;
    }
}
