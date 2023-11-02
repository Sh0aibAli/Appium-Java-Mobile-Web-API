package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.AppiumDriverEx;


public class ClickOnElement {
    public static void main(String[] args) throws InterruptedException {

        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();
            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();
            Thread.sleep(5000);
            appiumDriver.closeApp();
            appiumDriver.launchApp();
            Thread.sleep(5000);
//            appiumDriver.executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));
            appiumDriver.navigate().back();

    }
//    public static WebElement scrollToAnElementByText(AppiumDriver<MobileElement> driver, String text) {
//        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
//                ".scrollIntoView(new UiSelector().text('Login'));"));
//    }
}
