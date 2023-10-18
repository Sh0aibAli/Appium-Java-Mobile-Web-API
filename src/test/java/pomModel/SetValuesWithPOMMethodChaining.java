package pomModel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.HomePage;
import models.pages.LoginPage;
import models.pages.LoginPageWithMethodChaining;
import utils.AppiumDriverEx;

public class SetValuesWithPOMMethodChaining {
    public static void main(String[] args) {


        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Creating instance for the Page classes
        LoginPageWithMethodChaining loginPageWithMethodChaining = new LoginPageWithMethodChaining(appiumDriver);
        HomePage homePage = new HomePage(appiumDriver);

        //2. Click on the login label
        homePage.clickLoginLabel();

        //3. Input the creds & click on Login button
        loginPageWithMethodChaining
                .inputUsername("shoaib@gmail.com")
                .inputPassword("shoaib@12345")
                .clickLoginBtn();
    }
}
