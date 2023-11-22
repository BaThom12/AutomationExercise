package com.vmo.automationexercise.pageobject;

import com.github.javafaker.Faker;
import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.AccountPageUI;
import com.vmo.automationexercise.interfaces.AuthenPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class HomePageObject extends BasePage {
    WebDriver driver;
    Faker faker = new Faker();

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
        Assert.assertEquals(getTitle(driver), "Automation Practice Website for UI Testing - Test Cases");
        Log.allure("Verify user is navigated to test cases page successfully");
    }


    public void verifySubscriptionInHomePageSuccessful() {
        String email = faker.internet().emailAddress();
        scrollToBottomPage(driver);
        sendKeyToElement(driver, HomePageUI.SUBSCRIPTION_TEXTBOX, email);
        Log.allure("Enter email address in input: %s", email);
        clickToElement(driver, HomePageUI.ARROW_BUTTON);
        Log.allure("Click arrow button");
        Assert.assertEquals(getTextElement(driver, HomePageUI.SUBSCRIPTION_MESSAGE_SUCCESS), "You have been successfully subscribed!");
        Log.allure("Verify success message 'You have been successfully subscribed!' is visible");
    }

    public void verifySubscriptionInCartPageSuccessful() {
        String email = faker.internet().emailAddress();
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "/view_cart"));
        Log.allure("Click 'Cart' button");
        scrollToBottomPage(driver);
        sendKeyToElement(driver, HomePageUI.SUBSCRIPTION_TEXTBOX, email);
        Log.allure("Enter email address in input: %s", email);
        clickToElement(driver, HomePageUI.ARROW_BUTTON);
        Log.allure("Click arrow button");
        Assert.assertEquals(getTextElement(driver, HomePageUI.SUBSCRIPTION_MESSAGE_SUCCESS), "You have been successfully subscribed!");
        Log.allure("Verify success message 'You have been successfully subscribed!' is visible");
    }

    public void verifyCategoryDisplayOnHome() {
        Assert.assertEquals(getTextElement(driver, replaceText(HomePageUI.LEFT_SIDEBAR_LABEL, "text", "left-sidebar")), "CATEGORY");
        Log.allure("Verify that categories are visible on left side bar");
    }

    public void verifyCategoryPageDisplay() {
        clickToElement(driver, replaceText(HomePageUI.CATEGORY_COMMON, "text", "#Women"));
        Log.allure("Click on 'Women' category");
        clickToElement(driver, replaceText(HomePageUI.CATEGORY_COMMON, "text", "/category_products/1"));
        Log.allure("Click on 'Dress' subcategory");
        Assert.assertEquals(getTitle(driver), "Automation Exercise - Dress Products");
        Log.allure("Verify that category page is displayed");
        Assert.assertEquals(getTextElement(driver, HomePageUI.TOP_SUBCATEGORY), "WOMEN - DRESS PRODUCTS");
        Log.allure("Verify that confirm text 'WOMEN - TOPS PRODUCTS' is displayed");
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "#Men"));
        clickToElement(driver, replaceText(HomePageUI.CATEGORY_COMMON, "text", "/category_products/6"));
        Assert.assertEquals(getTitle(driver), "Automation Exercise - Jeans Products");
        Log.allure("Verify that user is navigated to that category page");
    }

    public void verifyBranchDisplay() {
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "/products"));
        Assert.assertEquals(getTextElement(driver, replaceText(HomePageUI.LEFT_SIDEBAR_LABEL, "text", "brands_products")), "BRANDS");
        Log.allure("Verify that Brands are visible on left side bar");

    }

    public void verifyNavigateToBranchPage() {
        clickToElement(driver, "//div[@class='brands_products']" + replaceText(HomePageUI.COMMON_BUTTON, "text", "/brand_products/Madame"));
        Log.allure("Click on any brand name");
        Assert.assertEquals(getTitle(driver), "Automation Exercise - Madame Products");
        Log.allure("Verify that user is navigated to brand page");
        Assert.assertEquals(getTextElement(driver, HomePageUI.TOP_SUBCATEGORY), "BRAND - MADAME PRODUCTS");
        Log.allure("Verify that brand products are displayed");
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "/brand_products/Kookie Kids"));
        Assert.assertEquals(getTitle(driver), "Automation Exercise - Kookie Kids Products");
        Log.allure("Verify that user is navigated to that brand page");
        Assert.assertEquals(getTextElement(driver, HomePageUI.TOP_SUBCATEGORY), "BRAND - KOOKIE KIDS PRODUCTS");
        Log.allure("Verify that kookie kids products are displayed");
    }

    public void verifyScrollAndArrowWhenClickArrow() {
        scrollToBottomPage(driver);
        Log.allure("Scroll down page to bottom");
        Assert.assertTrue(isElementDisplay(driver, HomePageUI.SUBSCRIPTION_LABEL));
        Log.allure("Verify 'SUBSCRIPTION' is visible");
        clickToElement(driver, HomePageUI.SCROLL_UP);
        Log.allure("Click on arrow at bottom right side to move upward");
        Assert.assertTrue(isElementDisplay(driver, HomePageUI.LOGO));
        Log.allure("Verify that page is scrolled up ");
        Assert.assertEquals(getTextElement(driver, HomePageUI.SLIDER), "Full-Fledged practice website for Automation Engineers");
        Log.allure("Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
    }

    public void verifyScrollAndArrow() {
        scrollToBottomPage(driver);
        Log.allure("Scroll down page to bottom");
        Assert.assertTrue(isElementDisplay(driver, HomePageUI.SUBSCRIPTION_LABEL));
        Log.allure("Verify 'SUBSCRIPTION' is visible");
        scrollToElement(driver, HomePageUI.LOGO);
        Log.allure("Scroll up page to top");
        Assert.assertTrue(isElementDisplay(driver, HomePageUI.LOGO));
        Log.allure("Verify that page is scrolled up ");
        Assert.assertEquals(getTextElement(driver, HomePageUI.SLIDER), "Full-Fledged practice website for Automation Engineers");
        Log.allure("Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
    }




}
