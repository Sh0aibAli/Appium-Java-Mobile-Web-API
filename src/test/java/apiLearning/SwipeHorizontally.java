package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;
import utils.SwipeAction;

public class SwipeHorizontally {
    public static void main(String[] args) {
        //Launch an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the Swipe Label
        MobileElement swipeLabel = appiumDriver.findElementByXPath("//android.widget.TextView[@text='Swipe']");
        swipeLabel.click();

        /*
        AndroidTouchAction touch = new AndroidTouchAction (appiumDriver);

        touch.longPress(LongPressOptions.longPressOptions()
                        .withElement (ElementOption.element (swipeLabel)))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(3)))
                .perform ();
        System.out.println("LongPressed Tapped");
        */

        //Make sure I'm on the target screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath("//android.widget.TextView[@text='Swipe horizontal']")));

        SwipeAction swipeAction = new SwipeAction(appiumDriver);
        swipeAction.swipeLeft();

        /*
        //Get the mobile screen sizes
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Init start points and end points to touch and release
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = yStartPoint;

        //Perform the touch actions
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
        TouchAction touchAction = new TouchAction(appiumDriver);

        //Swipe Left
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint).release()
                .perform();

        //Swipe Right
        touchAction
                .press(endPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(startPoint).release()
                .perform();*/
    }
}
