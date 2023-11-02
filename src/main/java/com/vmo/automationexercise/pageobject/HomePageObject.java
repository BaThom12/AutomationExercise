package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public void HompagePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void verifyOnHomePage(WebDriver driver){
        Assert.assertEquals(getTitle(driver),"Automation Exercise");
    }



}
