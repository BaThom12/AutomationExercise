package com.vmo.automationexercise.Account;

import com.vmo.automationexercise.common.BaseTest;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.helper.TestNGListener;
import com.vmo.automationexercise.pageobject.AuthenPageObject;
import com.vmo.automationexercise.pageobject.HomePageObject;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("AutomationExercise")
@Feature("Account")
@Story("Login")
@Listeners(TestNGListener.class)
public class AuthenTest extends BaseTest {
    WebDriver driver;
    HomePageObject homepage;
    AuthenPageObject authen;

    @Parameters({"browser","runType"})
    @BeforeMethod
    public void setup(String browser, String type) {
        driver = getDriverBrowser(browser,type);
        driver.manage().window().maximize();
        Log.info("Open browser");
        homepage = new HomePageObject(driver);
        homepage.openHomePage(driver);
        Log.info("Open Automation exercise shop");
        authen = new AuthenPageObject(driver);

    }
    @Test(priority = 1)
    public void TC03_LoginUserWithCorrectEmailAndPassword() {
        homepage.verifyOnHomePage(driver);
        authen.verifyOnLoginPage();
        authen.verifyLoginSuccessful();
    }
    @Test(priority = 2)
    public void TC04_LoginUserWithIncorrectEmailAndPassword() {
        homepage.verifyOnHomePage(driver);
        authen.verifyOnLoginPage();
        authen.verifyLoginFail();
    }
    @Test(priority = 3)
    public void TC05_Logout() {
        homepage.verifyOnHomePage(driver);
        authen.verifyOnLoginPage();
        authen.verifyLoginSuccessful();
        authen.verifyLogoutSuccessful();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
