package com.vmo.automationexercise.Register;

import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.pageobject.AccountPageObject;
import com.vmo.automationexercise.pageobject.HomePageObject;
import org.openqa.selenium.WebDriver;

public class AccountTest extends BasePage {
    WebDriver driver;
    HomePageObject homepage;
    AccountPageObject account;

    public void TC01_RegisterUser() {
        homepage.verifyOnHomePage(driver);
    }
}
