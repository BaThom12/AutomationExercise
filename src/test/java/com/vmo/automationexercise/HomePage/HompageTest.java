package com.vmo.automationexercise.HomePage;

import com.vmo.automationexercise.common.BaseTest;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.pageobject.HomePageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Epic("AutomationExercise")
@Feature("Homepage")
@Story("All feature of Homepage")
public class HompageTest extends BaseTest {
    WebDriver driver;
    HomePageObject homepage;

    @Parameters({"browser","runType"})
    @BeforeMethod
    public void setup(String browser, String type) {
        driver = getDriverBrowser(browser,type);
        driver.manage().window().maximize();
        Log.info("Open browser");
        homepage = new HomePageObject(driver);
        homepage.openHomePage(driver);
        Log.info("Open Automation exercise shop");

    }
   /* @Test
    public void TC01_VerifyTestCasesPage() {
        homepage.verifyOnHomePage(driver);
        homepage.verifyNavigatedToTestCasesPageSuccessfully();
    }
    @Test
    public void TC02_VerifySubscriptionInHomePage(){
        homepage.verifyOnHomePage(driver);
        homepage.verifySubscriptionInHomePageSuccessful();
    }
    }
    @Test
    public void TC03_VerifySubscriptionInCartPage(){
        homepage.verifyOnHomePage(driver);
        homepage.verifySubscriptionInCartPageSuccessful();
    }
    @Test
    public void TC04_ViewCategoryProducts(){
        homepage.verifyOnHomePage(driver);
        homepage.verifyCategoryDisplayOnHome();
        homepage.verifyCategoryPageDisplay();
    }
    @Test
    public void TC05_ViewCartBranchProducts(){
        homepage.verifyBranchDisplay();
        homepage.verifyNavigateToBranchPage();
    }*/

    @Test
    public void TC06_VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality(){
        homepage.openHomePage(driver);
        homepage.verifyOnHomePage(driver);
        homepage.verifyScrollAndArrowWhenClickArrow();
    }
    @Test
    public void TC07_VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality(){
        homepage.openHomePage(driver);
        homepage.verifyOnHomePage(driver);
        homepage.verifyScrollAndArrow();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}