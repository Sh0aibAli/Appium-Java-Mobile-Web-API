package pomModel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.HomePage;
import models.pages.LoginPage;
import models.pages.LoginPageWithComponents;
import utils.AppiumDriverEx;

public class SetValuesWithPOMWithComponents {
    public static void main(String[] args) {


        //1. Launch the target app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Creating instance for the Page classes
        LoginPageWithComponents loginPageWithComponents = new LoginPageWithComponents(appiumDriver);
        HomePage homePage = new HomePage(appiumDriver);

        //2. Click on the login label
        homePage.loginLabel().click();

        //3. Input the username
        loginPageWithComponents.credentialForm().inputUsername("shoaib@gmail.com");
        //4. Input the password
        loginPageWithComponents.credentialForm().inputPassword("shoaib@12345");

        //5. Click on the login button
        loginPageWithComponents.clickLoginBtn();
    }
}
