package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.AppiumDriverEx;

public class SetValues {
    public static void main(String[] args) {
        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click on the login label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //3. Input the username
        MobileElement emailBox = appiumDriver.findElementByAccessibilityId("input-email");
        emailBox.sendKeys("shoaib@gmail.com");

        //4. Input the password
        MobileElement passwordBox = appiumDriver.findElementByAccessibilityId("input-password");
        passwordBox.sendKeys("shoaib@12345");

        //5. Click on the login button
        MobileElement loginButton = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();

    }
}
