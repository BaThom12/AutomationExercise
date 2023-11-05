package com.vmo.automationexercise.Account;

import com.vmo.automationexercise.common.BaseTest;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.helper.TestNGListener;
import com.vmo.automationexercise.pageobject.AccountPageObject;
import com.vmo.automationexercise.pageobject.HomePageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("AutomationExercise")
@Feature("Account")
@Story("Register and delete account")
@Listeners(TestNGListener.class)
public class RegisterTest extends BaseTest {
    WebDriver driver;
    HomePageObject homepage;
    AccountPageObject account;

    @Parameters({"browser","runType"})
    @BeforeClass
    public void setup(String browser, String type) {
        driver = getDriverBrowser(browser,type);
        driver.manage().window().maximize();
        Log.info("Open browser");
         homepage = new HomePageObject(driver);
        homepage.openHomePage(driver);
        Log.info("Open Automation exercise shop");
        account = new AccountPageObject(driver);

    }


   /* @Test(priority = 1)
    public void TC01_RegisterUser() {
        homepage.verifyOnHomePage(driver);
        homepage.verifyOnSignUpPage();
        account.verifyEnterNameAndEmail();
        account.verifyCreateAccountSuccessful();
        account.verifyLoginSuccessful();
    }
    @Test(priority = 2)
    public void TC02_DeleteUser() {
        account.verifyDeleteAccountSuccessful();
    }*/
    @Test(priority = 3)
    public void TC06_RegisterUserWithExistingEmail() {
        homepage.verifyOnHomePage(driver);
        homepage.verifyOnSignUpPage();
        account.verifyCreateAccountFail();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
