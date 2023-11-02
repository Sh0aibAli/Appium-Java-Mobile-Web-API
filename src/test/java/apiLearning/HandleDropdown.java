package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.AppiumDriverEx;

public class HandleDropdown {
    public static void main(String[] args) {
        //Launch an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the [Forms] Label
        MobileElement formsLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formsLabel.click();

        //Click on the dropdown element
        MobileElement dropdownElement = appiumDriver.findElementByAccessibilityId("Dropdown");
        dropdownElement.click();

        //Select the first option
        MobileElement firstOption = appiumDriver.findElementByXPath("//*[@text='webdriver.io is awesome']");
        firstOption.click();

        try {
            Thread.sleep(3000);
        }catch (Exception e){}

        //Get the text displays on the dropdown

    }
}
