package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class AccountPageObject extends BasePage {
    public void enterNameEmail(WebDriver driver){
        clickToElement(driver, HomePageUI.SIGNUP_BUTTON);
    }
}
