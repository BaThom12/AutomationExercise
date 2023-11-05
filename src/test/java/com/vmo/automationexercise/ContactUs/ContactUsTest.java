package com.vmo.automationexercise.ContactUs;

import com.vmo.automationexercise.common.BaseTest;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.pageobject.AuthenPageObject;
import com.vmo.automationexercise.pageobject.ContactUsPageObject;
import com.vmo.automationexercise.pageobject.HomePageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
@Epic("AutomationExercise")
@Feature("Contact us")
@Story("Send feedback")
public class ContactUsTest extends BaseTest {
    WebDriver driver;
    HomePageObject homepage;
    ContactUsPageObject contact;

    @Parameters({"browser","runType"})
    @BeforeMethod
    public void setup(String browser, String type) {
        driver = getDriverBrowser(browser,type);
        driver.manage().window().maximize();
        Log.info("Open browser");
        homepage = new HomePageObject(driver);
        homepage.openHomePage(driver);
        Log.info("Open Automation exercise shop");
        contact = new ContactUsPageObject(driver);

    }
    @Test
    public void TC07_SendToContactUs() {
        homepage.verifyOnHomePage(driver);
        contact.verifySendToContactUsSuccessful();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
