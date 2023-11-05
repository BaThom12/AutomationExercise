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
    @Test
    public void TC08_VerifyTestCasesPage() {
        homepage.verifyOnHomePage(driver);
        homepage.verifyNavigatedToTestCasesPageSuccessfully();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}