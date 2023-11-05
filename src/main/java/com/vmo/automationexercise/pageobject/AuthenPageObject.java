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

public class AuthenPageObject extends BasePage {
    WebDriver driver;

    public AuthenPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyOnLoginPage() {
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON,"text","/login"));
        Log.allure(" Click on 'Signup / Login' button");
        Assert.assertEquals(getTextElement(driver,replaceText(AuthenPageUI.COMMON_LABEL,"text","login-form")),"Login to your account");
        Log.allure(" Verify 'Login to your account' is visible");
    }

    public void verifyLoginSuccessful() {
        sendKeyToElement(driver,replaceText(AuthenPageUI.EMAIL_TEXTBOX,"text","login-email"),"tia.mclaughlin@gmail.com");
        Log.allure("Enter email: tia.mclaughlin@gmail.com");
        sendKeyToElement(driver,replaceText(AuthenPageUI.COMMON_TEXTBOX,"text","password"),"uaq3hhz2sdke6");
        Log.allure("Enter password: uaq3hhz2sdke6");
        clickToElement(driver,AuthenPageUI.LOGIN_BUTTON);
        Log.allure("Click 'login' button");
        Assert.assertTrue(getTextElement(driver, AccountPageUI.LOGIN_LABEL).contains("Logged in as"));
        Log.allure("Verify that 'Logged in as username' is visible");

    }

    public void verifyLoginFail() {
        sendKeyToElement(driver,replaceText(AuthenPageUI.EMAIL_TEXTBOX,"text","login-email"),"tia.mclaughlin@gmail.com.vn");
        Log.allure("Enter email: tia.mclaughlin@gmail.com.vn");
        sendKeyToElement(driver,replaceText(AuthenPageUI.COMMON_TEXTBOX,"text","password"),"uaq3hhz2sdke6");
        Log.allure("Enter password: uaq3hhz2sdke6");
        clickToElement(driver,AuthenPageUI.LOGIN_BUTTON);
        Log.allure("Click 'login' button");
        Assert.assertEquals(getTextElement(driver,replaceText(AuthenPageUI.ERROR_MESSAGE,"text","/login")),"Your email or password is incorrect!");
        Log.allure("Verify error 'Your email or password is incorrect!' is visible");
    }

    public void verifyLogoutSuccessful() {
        clickToElement(driver,replaceText(HomePageUI.COMMON_BUTTON,"text","/logout"));
        Log.allure("Click 'Logout' button");
        Assert.assertEquals(getCurrentUrl(driver),"https://automationexercise.com/login");
        Log.allure("Verify that user is navigated to login page");
    }
}
