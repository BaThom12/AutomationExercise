package com.vmo.automationexercise.pageobject;

import com.github.javafaker.Faker;
import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.AuthenPageUI;
import com.vmo.automationexercise.interfaces.ContactUsPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class ContactUsPageObject extends BasePage {
    WebDriver driver;
    Faker faker = new Faker();
    public ContactUsPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void verifySendToContactUsSuccessful(){
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String subject = "Product";
        String message = "Contact us";
        String pathFile = "/src/test/resources/Test data.xlsx";
        clickToElement(driver,replaceText(HomePageUI.COMMON_BUTTON,"text","/contact_us"));
        Log.allure("Click on 'Contact Us' button");
        Assert.assertEquals(getTextElement(driver, ContactUsPageUI.TITLE_LABEL),"GET IN TOUCH");
        Log.allure("Verify 'GET IN TOUCH' is visible");
        sendKeyToElement(driver,replaceText(ContactUsPageUI.COMMON_TEXTBOX,"text","name"),name);
        Log.allure("Enter name: %s",name);
        sendKeyToElement(driver,replaceText(ContactUsPageUI.COMMON_TEXTBOX,"text","email"),email);
        Log.allure("Enter email: %s",email);
        sendKeyToElement(driver,replaceText(ContactUsPageUI.COMMON_TEXTBOX,"text","subject"),subject);
        Log.allure("Enter subject: %s",subject);
        sendKeyToElement(driver,ContactUsPageUI.MESSAGE_TEXTAREA,message);
        Log.allure("Enter message: %s",message);
        uploadFile(driver,replaceText(ContactUsPageUI.COMMON_TEXTBOX,"text","upload_file"),pathFile);
        Log.allure("Upload file");
        clickToElement(driver,replaceText(ContactUsPageUI.COMMON_TEXTBOX,"text","submit"));
        Log.allure("Click 'Submit' button");
        waitAlertPresence(driver);
        acceptAlert(driver);
        Log.allure("Click on OK button");
        Assert.assertEquals(getTextElement(driver,ContactUsPageUI.MESSAGE_SUCCESS),"Success! Your details have been submitted successfully.");
        Log.allure("Verify success message 'Success! Your details have been submitted successfully.' is visible");
        clickToElement(driver,ContactUsPageUI.HOME_BUTTON);
        Log.allure("Click 'Home' button");
        waitForElementVisible(driver,replaceText(HomePageUI.LEFT_SIDEBAR_LABEL,"text","left-sidebar"));
        Assert.assertEquals(getTitle(driver),"Automation Exercise");
        Log.allure("Verify that landed to home page successfully");
    }
}
