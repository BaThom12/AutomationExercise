package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void openHomePage(WebDriver driver){
        openUrl(driver, HomePageUI.AUTOMATION_URL);
        Log.allure("Open Homepage successful");
    }
    public void verifyOnHomePage(WebDriver driver){
        Assert.assertEquals(getTitle(driver),"Automation Exercise");
        Log.allure("Verify that home page is visible successfully");
    }



}
