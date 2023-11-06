package com.vmo.automationexercise.pageobject;

import com.github.javafaker.Faker;
import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.AccountPageUI;
import com.vmo.automationexercise.interfaces.AuthenPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class HomePageObject extends BasePage {
    WebDriver driver;
    Faker faker  = new Faker();

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage(WebDriver driver) {
        openUrl(driver, HomePageUI.AUTOMATION_URL);
        Log.allure("Open Homepage successful");
    }

    public void verifyOnHomePage(WebDriver driver) {
        Assert.assertEquals(getTitle(driver), "Automation Exercise");
        Log.allure("Verify that home page is visible successfully");
    }

    public void openSignUpPage(WebDriver driver) {
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "/login"));
    }

    public void verifyOnSignUpPage() {
        openSignUpPage(driver);
        Log.allure("Click Signup button");
        Assert.assertEquals(getTextElement(driver, replaceText(AuthenPageUI.COMMON_LABEL, "text", "signup-form")), "New User Signup!");
        Log.allure("Verify 'New User Signup!' is visible");
    }

    public void verifyNavigatedToTestCasesPageSuccessfully() {
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "/test_cases"));
        Log.allure("Click on 'Test Cases' button");
        Assert.assertEquals(getTitle(driver),"Automation Practice Website for UI Testing - Test Cases");
        Log.allure("Verify user is navigated to test cases page successfully");
    }


    public void verifySubscriptionSuccessful() {
        String email = faker.internet().emailAddress();
        scrollToBottomPage(driver);
        sendKeyToElement(driver,HomePageUI.SUBSCRIPTION_TEXTBOX,email);
        Log.allure("Enter email address in input: %s",email);
        clickToElement(driver,HomePageUI.ARROW_BUTTON);
        Log.allure("Click arrow button");
        Assert.assertEquals(getTextElement(driver,HomePageUI.SUBSCRIPTION_MESSAGE_SUCCESS),"You have been successfully subscribed!");
    }
}
