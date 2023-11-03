package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.interfaces.AccountPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class AccountPageObject extends BasePage {
    WebDriver driver;
    public AccountPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void openSignUpPage(WebDriver driver){
        clickToElement(driver, HomePageUI.SIGNUP_BUTTON);

    }
    public String replaceText(String locator,String actual, String expect){
        return locator.replace(actual,expect);
    }
    public void enterNameEmail(WebDriver driver){
        sendKeyToElement(driver, replaceText(AccountPageUI.NAME_TEXTBOX,"text","name"),"Melyssa Lester");
        sendKeyToElement(driver, replaceText(AccountPageUI.NAME_TEXTBOX,"text","email"),"posuere.cubilia@protonmail.edu");
        clickToElement(driver,replaceText(AccountPageUI.NAME_TEXTBOX,"text","signup-button"));
    }

    public void verifyOnSignUpPage() {
        openSignUpPage(driver);
    }

    public void verifyEnterAccountInformationSuccessful() {
    }

    public void verifyCreateAccountSuccessful() {
    }

    public void verifyLoginSuccessful() {
    }

    public void verifyDeleteAccountSuccessful() {
    }
}
