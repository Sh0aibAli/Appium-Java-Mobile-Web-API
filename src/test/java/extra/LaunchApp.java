package extra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class LaunchApp {
    public static void main(String[] args){
        try{
            //Driver instance
            AppiumDriver<MobileElement> appiumDriver;

            //Set DesiredCapabilities to sent to Appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
            desiredCapabilities.setCapability("appPackage","com.wdiodemoapp");
            desiredCapabilities.setCapability("appActivity","com.wdiodemoapp.MainActivity");
//            desiredCapabilities.setCapability("app", "C:\\Users\\harsh\\Downloads\\Android-NativeDemoApp-0.4.0.apk");

            //Setup the Appium server url to connect to
            URL appiumServer = new URL("http://localhost:4725/wd/hub");

            appiumDriver = new AppiumDriver<MobileElement>(appiumServer, desiredCapabilities);
        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
