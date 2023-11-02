package extra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeAction {
    private AppiumDriver<MobileElement> appiumDriver;
    private TouchAction touchAction;
    private  PointOption startPoint;
    private  PointOption endPoint;
    public SwipeAction(AppiumDriver<MobileElement> appiumDriver){
        this.appiumDriver = appiumDriver;
        touchAction = new TouchAction(this.appiumDriver);
        //Get the mobile screen sizes
        Dimension windowSize = this.appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Init start points and end points to touch and release
        int xStartPoint = 50 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = yStartPoint;

        //Perform the touch actions
        this.startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        this.endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
    }

    public void swipeRight(int times){
        for (int initTime = 0; initTime < times; initTime++){
            this.swipeRight();}
    }
    public void swipeLeft(int times){
        for (int initTime = 0; initTime < times; initTime++){
            this.swipeLeft();
        }
    }
    public void swipeRight(){
        touchAction
                .press(endPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(startPoint).release()
                .perform();
    }

    public void swipeLeft(){
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint).release()
                .perform();
    }
}
