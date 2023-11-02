package com.vmo.myec.Register;

import com.vmo.myec.common.BasePage;
import com.vmo.myec.pageobject.AccountPageObject;
import com.vmo.myec.pageobject.HompagePageObject;
import org.openqa.selenium.WebDriver;

public class AccountTest extends BasePage {
    WebDriver driver;
    HompagePageObject homepage;
    AccountPageObject account;

    public void TC01_RegisterUser() {
        homepage.verifyOnHomePage(driver);
    }
}
