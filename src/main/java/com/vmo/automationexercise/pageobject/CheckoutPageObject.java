package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import org.openqa.selenium.WebDriver;

public class CheckoutPageObject extends BasePage {
    WebDriver driver;
    public CheckoutPageObject(WebDriver driver){
        this.driver = driver;
    }
}
