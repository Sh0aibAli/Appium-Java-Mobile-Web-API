package smokeTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.mainInteractionMethods.HomePage;
import models.pages.mainInteractionMethods.LoginPage;
import utilities.AppiumDriverEx;

public class SetValuesWithPOMMainInteractionMethod {
    public static void main(String[] args) {


        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Creating instance for the Page classes
        LoginPage loginPage = new LoginPage(appiumDriver);
        HomePage homePage = new HomePage(appiumDriver);

        //2. Click on the login label
        homePage.clickLoginLabel();

        //3. Input the username
        loginPage.inputUsername("shoaib@gmail.com");
        //4. Input the password
        loginPage.inputPassword("shoaib@12345");

        //5. Click on the login button
        loginPage.clickLoginBtn();

        appiumDriver.findElementByXPath("//*[@text='OK']").click();
    }
}
