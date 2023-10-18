package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriverEx;

public class HandleToogleButton {
    public static void main(String[] args) {

        //Launch an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the [Forms] Label
        MobileElement formsLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formsLabel.click();

        //Get the toogle label value before interacting with the switch
        MobileElement switchTextElement = appiumDriver.findElementByAccessibilityId("switch-text");
        System.out.println("Label text BEFORE interacting with the switch button: "+switchTextElement.getText());

        //Click on the toogle button
        MobileElement switchButton = appiumDriver.findElementByAccessibilityId("switch");
        if (!switchButton.isSelected()){
            System.out.println("Not selected");
            switchButton.click();

        }else{
            System.out.println("Already selected");
        }

        //Get the toogle label value After interacting with the switch
        System.out.println("Label text AFTER interacting with the switch button: "+switchTextElement.getText());

    }
}
