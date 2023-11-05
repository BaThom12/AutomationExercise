package com.vmo.automationexercise.pageobject;

import com.github.javafaker.Faker;
import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.AccountPageUI;
import com.vmo.automationexercise.interfaces.AuthenPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class AccountPageObject extends BasePage {
    WebDriver driver;
    Faker faker = new Faker();

    public AccountPageObject(WebDriver driver) {
        this.driver = driver;
    }




    public void enterNameEmail(WebDriver driver) {
        String fullName =faker.name().fullName();
        String email = faker.internet().emailAddress();
        sendKeyToElement(driver, replaceText(AuthenPageUI.COMMON_TEXTBOX, "text", "name") , fullName);
        Log.allure("Enter name: %s", fullName);
        sendKeyToElement(driver,replaceText(AuthenPageUI.EMAIL_TEXTBOX, "text", "signup-email") , email);
        Log.allure("Enter email: %s", email);
        clickToElement(driver, replaceText(AccountPageUI.COMMON_BUTTON, "text", "signup-button"));
        Log.allure("Click on signup button");
    }


    public void verifyEnterNameAndEmail() {
        enterNameEmail(driver);
        Assert.assertEquals(getTextElement(driver, AccountPageUI.ACCOUNT_TITLE), "ENTER ACCOUNT INFORMATION");
        Log.allure("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }

    private void enterAccountInformationSuccessful() throws ElementClickInterceptedException {
        String password = faker.internet().password();
        clickToElement(driver, AccountPageUI.TITLE_RADIO);
        Log.allure("Choose title");
        sendKeyToElement(driver, replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "password"),password);
        Log.allure("Enter password: %s",password);
        Select sltDay = new Select(driver.findElement(By.xpath(replaceText(AccountPageUI.COMMON_SELECT, "text", "days"))));
        sltDay.selectByVisibleText("5");
        Log.allure("Choose day: 5");
        Select sltMonth = new Select(driver.findElement(By.xpath(replaceText(AccountPageUI.COMMON_SELECT, "text", "months"))));
        sltMonth.selectByVisibleText("May");
        Log.allure("Choose month: May");
        Select sltYear = new Select(driver.findElement(By.xpath(replaceText(AccountPageUI.COMMON_SELECT, "text", "years"))));
        sltYear.selectByVisibleText("1989");
        Log.allure("Choose year: 1989");
        clickToElement(driver,replaceText(AccountPageUI.COMMON_CHECKBOX, "text", "newsletter"));
        Log.allure("Tick on Sign up for our newsletter! checkbox");
        clickToElement(driver,replaceText(AccountPageUI.COMMON_CHECKBOX, "text", "optin"));
        Log.allure("Tick on Receive special offers from our partners! checkbox");

    }

    private void enterAddressInformation(){
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String company = faker.company().name();
        String address1 = faker.address().fullAddress();
        String address2 = faker.address().buildingNumber();
        String state = String.valueOf(faker.address().state());
        String city = String.valueOf(faker.address().cityName());
        String zipcode = String.valueOf(faker.address().zipCode());
        String phone = faker.phoneNumber().cellPhone();
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "first_name"),firstname);
        Log.allure("Enter first name: %s",firstname);
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "last_name"),lastname);
        Log.allure("Enter last name: %s",lastname);
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "company"),company);
        Log.allure("Enter company: %s",company);
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "address1"),address1);
        Log.allure("Enter address1: %s",address1);
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "address2"),address2);
        Log.allure("Enter address2: %s",address2);
        Select sltMonth = new Select(driver.findElement(By.xpath(replaceText(AccountPageUI.COMMON_SELECT, "text", "country"))));
        sltMonth.selectByVisibleText("Canada");
        Log.allure("Choose country: Canada");
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "state"),state);
        Log.allure("Enter state: %s",state);
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "city"),city);
        Log.allure("Enter city: %s",city);
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "zipcode"),zipcode);
        Log.allure("Enter zipcode: %s",zipcode);
        sendKeyToElement(driver,replaceText(AccountPageUI.COMMON_TEXTBOX, "text", "mobile_number"),phone);
        Log.allure("Enter phone number: %s",phone);

    }

    public void verifyCreateAccountSuccessful() {
        enterAccountInformationSuccessful();
        enterAddressInformation();
        clickToElement(driver,replaceText(AccountPageUI.COMMON_BUTTON, "text", "create-account"));
        Log.allure("Click on Create account button");
        Assert.assertEquals(getTextElement(driver,AccountPageUI.ACCOUNT_CREATED_LABEL),"ACCOUNT CREATED!");
        Log.allure("Verify that 'ACCOUNT CREATED!' is visible");

    }

    public void verifyLoginSuccessful() {
        clickToElement(driver,AccountPageUI.CONTINUE_CREATE_BUTTON);
        Log.allure("Click Continue button to login");
        Assert.assertTrue(getTextElement(driver,AccountPageUI.LOGIN_LABEL).contains("Logged in as"));
        Log.allure("Verify that 'Logged in as username' is visible");
    }

    public void verifyDeleteAccountSuccessful() {
        clickToElement(driver,replaceText(HomePageUI.COMMON_BUTTON, "text", "/delete_account"));
        Log.allure("Click 'Delete Account' button");
        Assert.assertEquals(getTextElement(driver,AccountPageUI.ACCOUNT_DELETE_LABEL),"ACCOUNT DELETED!");
        Log.allure("Verify that 'ACCOUNT DELETED!' is visible ");
        clickToElement(driver,AccountPageUI.CONTINUE_DELETE_BUTTON);

    }

    public void verifyCreateAccountFail() throws ElementClickInterceptedException{
        String fullName = faker.name().fullName();
        sendKeyToElement(driver, replaceText(AuthenPageUI.COMMON_TEXTBOX, "text", "name") , fullName);
        Log.allure("Enter name: %s", fullName);
        sendKeyToElement(driver,replaceText(AuthenPageUI.EMAIL_TEXTBOX, "text", "signup-email") , "tia.mclaughlin@gmail.com");
        Log.allure("Enter email: tia.mclaughlin@gmail.com");
        clickToElement(driver, replaceText(AccountPageUI.COMMON_BUTTON, "text", "signup-button"));
        Log.allure("Click on signup button");
        Assert.assertEquals(getTextElement(driver,replaceText(AuthenPageUI.ERROR_MESSAGE,"text","/signup")),"Email Address already exist!");
        Log.allure("Verify error 'Email Address already exist!' is visible");
    }
}
