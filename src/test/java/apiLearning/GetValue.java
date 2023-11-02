package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.AppiumDriverEx;

public class GetValue {
    public static void main(String[] args) {
        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click on the Login label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //3. Input username
        MobileElement emailTextBox = appiumDriver.findElementByAccessibilityId("input-email");
        emailTextBox.sendKeys("shoaib@gmail.com");

        //4. Input password
        MobileElement passwordTextBox = appiumDriver.findElementByAccessibilityId("input-password");
        passwordTextBox.sendKeys("12345@gmail@#$");

        //5. Click on the login button
        MobileElement loginButton = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();

        //6. get the title from the dialog
        MobileElement successTitle = appiumDriver.findElementById("android:id/alertTitle");
        System.out.println("Dialog title: "+ successTitle.getText());


    }
}
