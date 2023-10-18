package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.AppiumDriverEx;

import java.time.Duration;

public class HandleMultiTouch {
    public static void main(String[] args) {
        //Launch an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the Drag Label
        MobileElement dragLabel = appiumDriver.findElementByXPath("//android.widget.TextView[@text='Drag']");
        dragLabel.click();

        MobileElement element1 = appiumDriver.findElementByXPath("//android.view.ViewGroup[@content-desc='drag-l2']/android.widget.ImageView");
        MobileElement positionA = appiumDriver.findElementByXPath("//android.view.ViewGroup[@content-desc='drop-l2']/android.view.ViewGroup");
//        MobileElement element2 = appiumDriver.findElementByXPath("");
//        MobileElement positionB = appiumDriver.findElementByXPath("");

        TouchAction action =new TouchAction(appiumDriver);
        action.longPress(PointOption.point(element1.getLocation().x, element1.getLocation().y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(positionA.getLocation().x, positionA.getLocation().y)).release().perform();


    }
}
