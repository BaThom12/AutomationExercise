package com.vmo.myec.pageobject;

import com.vmo.myec.common.BasePage;
import com.vmo.myec.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class AccountPageObject extends BasePage {
    public void enterNameEmail(WebDriver driver){
        clickToElement(driver, HomePageUI.SIGNUP_BUTTON);
    }
}
