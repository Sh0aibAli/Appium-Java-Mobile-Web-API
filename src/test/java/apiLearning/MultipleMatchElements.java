package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AppiumDriverEx;

import java.util.List;

public class MultipleMatchElements {
    public static void main(String[] args) {
        //Start an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the login label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //Find element those are matched //*[@text="Login"]
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.xpath("//*[@text='Login']"),2));

        List<MobileElement> loginTextElements = appiumDriver.findElementsByXPath("//*[@text='Login']");
        final int Login_Text_Form_Index = 0;
        final int Login_Menu_Text_Index = 1;

        loginTextElements.get(Login_Text_Form_Index).click();
        loginTextElements.get(Login_Menu_Text_Index).getText();
    }
}
