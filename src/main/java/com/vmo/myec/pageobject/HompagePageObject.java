package com.vmo.myec.pageobject;

import com.vmo.myec.common.BasePage;
import com.vmo.myec.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HompagePageObject extends BasePage {
    WebDriver driver;
    public void HompagePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void verifyOnHomePage(WebDriver driver){
        Assert.assertEquals(getTitle(driver),"Automation Exercise");
    }



}
