package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.AppiumDriverEx;

import java.time.Duration;

public class MultipleAppInteraction {
    public static void main(String[] args) {
        //1. Launch an appium session
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

        //Put app in the Background (simulate the way user press the Home button on device) for 3 seconds
        appiumDriver.runAppInBackground(Duration.ofSeconds(-1));
//        appiumDriver.terminateApp("com.wdiodemoapp"); // to close the specific application

//        appiumDriver.resetApp();

        //Open the setting app -> com.android.settings
        appiumDriver.activateApp("com.android.settings");

        //Goto wifi
        MobileElement networkLabel = appiumDriver.findElementByXPath("//*[@text='Network & internet']");
        networkLabel.click();

        MobileElement wifiSwitch = appiumDriver.findElementByXPath("//*[contains(@resource-id,'switchWidget')]");
        By wifiText = MobileBy.xpath("//*[@text='Wi‑Fi']/following-sibling::*");
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);

        //Toggle wifi
        if(wifiSwitch.getAttribute("checked").contains("true")){
            //Turn the wifi OFF
            wifiSwitch.click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(wifiText,"Off"));

            //Turn the wifi ON
            wifiSwitch.click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(wifiText,"AndroidWifi"));
        }else
            {
                Assert.assertTrue(wifiSwitch.getAttribute("checked").contains("false"));
                //Turn the wifi ON
                wifiSwitch.click();
            }

        //Relaunch the testing app
        appiumDriver.activateApp("com.wdiodemoapp");

        //Continue to interact with the other elements in the app
        appiumDriver.findElementByXPath("//*[@text='OK']").click();

    }
}
