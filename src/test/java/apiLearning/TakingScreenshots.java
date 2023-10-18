package apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AppiumDriverEx;

import java.io.File;
import java.io.IOException;

public class TakingScreenshots {
    public static void main(String[] args) {

        //Launch an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the [Forms] Label
        MobileElement formsLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formsLabel.click();

        //Click on the toogle button if it is OFF
        MobileElement switchButton = appiumDriver.findElementByAccessibilityId("switch");
        MobileElement switchTextElement = appiumDriver.findElementByAccessibilityId("switch-text");
        final boolean isSwitchOn = switchTextElement.getText().equals("Click to turn the switch OFF");

        if (!isSwitchOn){
            switchButton.click();
        }
        //Click on the dropdown menu -> Select the first option
        MobileElement dropdownElement = appiumDriver.findElementByAccessibilityId("Dropdown");
        dropdownElement.click();
        MobileElement firstOption = appiumDriver.findElementByXPath("//*[@text='webdriver.io is awesome']");
        firstOption.click();

        //Taking a screenshot
        File formScreenBase64Data = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        String formStringFilePath = System.getProperty("user.dir")+"/screenshots/"+"formScreen.png";

        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formStringFilePath));
        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
