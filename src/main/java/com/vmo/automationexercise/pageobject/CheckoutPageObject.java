package com.vmo.automationexercise.pageobject;

import com.github.javafaker.Faker;
import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.common.GlobalConstants;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.CartPageUI;
import com.vmo.automationexercise.interfaces.CheckoutPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class CheckoutPageObject extends BasePage {
    WebDriver driver;
    AccountPageObject account = new AccountPageObject(driver);
    Faker faker = new Faker();
    String nameOfCard = faker.name().fullName();
    String cardNumber = faker.finance().creditCard();
    String cvc = "489";
    String expiry_month = "12";
    String expiry_year = "2025";
    JavascriptExecutor js;

    public CheckoutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void loginBeforeCheckout() {
        clickToElement(driver, CheckoutPageUI.PROCEED_TO_CHECKOUT_BUTTON);
        Log.allure("Click Proceed To Checkout");
        clickToElement(driver, CheckoutPageUI.LOGIN_LINK);
        Log.allure("Click 'Register / Login' button");

    }

    public void checkoutProduct() {
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "/view_cart"));
        Log.allure("Click 'Cart' button");
        clickToElement(driver, CheckoutPageUI.PROCEED_TO_CHECKOUT_BUTTON);
        Log.allure("Click 'Proceed To Checkout' button");
    }

    public void verifyAddressAndProductInCart() {
        Assert.assertTrue(getTextElement(driver, replaceText(CheckoutPageUI.YOUR_BILLING_ADDRESS, "text", "address_firstname address_lastname")).contains(AccountPageObject.firstname + " " + AccountPageObject.lastname));
        Assert.assertEquals(getTextElement(driver, replaceText(CheckoutPageUI.YOUR_BILLING_ADDRESS, "text", "address_address1 address_address2") + "[1]"), AccountPageObject.company);
        Assert.assertEquals(getTextElement(driver, replaceText(CheckoutPageUI.YOUR_BILLING_ADDRESS, "text", "address_address1 address_address2") + "[2]"), AccountPageObject.address1);
        Assert.assertEquals(getTextElement(driver, replaceText(CheckoutPageUI.YOUR_BILLING_ADDRESS, "text", "address_address1 address_address2") + "[3]"), AccountPageObject.address2);
        Assert.assertEquals(getTextElement(driver, replaceText(CheckoutPageUI.YOUR_BILLING_ADDRESS, "text", "address_city address_state_name address_postcode")), AccountPageObject.city + " " + AccountPageObject.state + " " + AccountPageObject.zipcode);
        Assert.assertEquals(getTextElement(driver, replaceText(CheckoutPageUI.YOUR_BILLING_ADDRESS, "text", "address_phone")), AccountPageObject.phone);
        Log.allure("Verify Address Details Successfully");
        Assert.assertEquals(getTextElement(driver, replaceText(CartPageUI.NAME_PRODUCT, "index", "1")), "Blue Top");
        Assert.assertEquals(getTextElement(driver, replaceText(CartPageUI.QUANTITY_PRODUCT, "index", "1")), "1");
        Log.allure("Verify Review Your Order Successfully");
    }

    public void verifyNameAndProductInCart() {
        // Assert.assertTrue(getTextElement(driver,replaceText(CheckoutPageUI.YOUR_BILLING_ADDRESS,"text","address_firstname address_lastname")).contains("Clair Mayert"));
        // Assert.assertTrue(getTextElement(driver,replaceText(CheckoutPageUI.YOUR_BILLING_ADDRESS,"text","address_firstname address_lastname")).contains(AccountPageObject.firstname));
        Log.allure("Verify Name Details Successfully");
        Assert.assertEquals(getTextElement(driver, replaceText(CartPageUI.NAME_PRODUCT, "index", "1")), "Blue Top");
        Assert.assertEquals(getTextElement(driver, replaceText(CartPageUI.QUANTITY_PRODUCT, "index", "1")), "1");
        Log.allure("Verify Review Your Order Successfully");
    }

    public void enterInformationCheckout() {
        sendKeyToElement(driver, CheckoutPageUI.COMMENT_ORDER, "please send me");
        clickToElement(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);
        Log.allure("Enter description in comment text area and click 'Place Order'");
        sendKeyToElement(driver, replaceText(CheckoutPageUI.CARD_COMMON_TEXTBOX, "text", "name_on_card"), nameOfCard);
        Log.allure("Enter payment details: Name on Card");
        sendKeyToElement(driver, replaceText(CheckoutPageUI.CARD_COMMON_TEXTBOX, "text", "card_number"), cardNumber);
        Log.allure("Enter payment details:  Card Number");
        sendKeyToElement(driver, replaceText(CheckoutPageUI.CARD_COMMON_TEXTBOX, "text", "cvc"), cvc);
        Log.allure("Enter payment details:  CVC");
        sendKeyToElement(driver, replaceText(CheckoutPageUI.CARD_COMMON_TEXTBOX, "text", "expiry_month"), expiry_month);
        Log.allure("Enter payment details:  Expiration month");
        sendKeyToElement(driver, replaceText(CheckoutPageUI.CARD_COMMON_TEXTBOX, "text", "expiry_year"), expiry_year);
        Log.allure("Enter payment details:  Expiration year");
        clickToElement(driver, CheckoutPageUI.ORDER_BUTTON);
        Log.allure("Click 'Pay and Confirm Order' button");
        //backToPage(driver);
        // Assert.assertEquals(getTextElement(driver,CheckoutPageUI.ORDER_SUCCESS),"Your order has been placed successfully!");
        Log.allure("Verify success message 'Your order has been placed successfully!'");
    }


    public void verifyDownloadInvoiceSuccessful() {
        clickToElement(driver, CheckoutPageUI.DOWNLOAD_INVOICE);
        Log.allure("Click 'Download Invoice' button ");
        overrideImplicitTimeOut(driver, GlobalConstants.LONG_TIMEOUT);
        isFileDownloaded("C:\\Users\\ancoi\\Downloads\\", "invoice.txt");
        Log.allure("verify invoice is downloaded successfully.");
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON);
        Log.allure("Click 'Continue' button");
    }
}
