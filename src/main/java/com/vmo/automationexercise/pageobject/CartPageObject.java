package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.CartPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import com.vmo.automationexercise.interfaces.ProductPageUI;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.HashMap;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class CartPageObject extends BasePage {
    WebDriver driver;
    HashMap<String, String> informationProduct;
    HashMap<String, String> inforProduct = new HashMap<String, String>();

    public CartPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void addAndVerifyProductInCart() {
        String firstProductName = getTextElement(driver, replaceText(ProductPageUI.INFORMATION_FIRST_PRODUCT, "text", "p"));
        String firstProductPrice = getTextElement(driver, replaceText(ProductPageUI.INFORMATION_FIRST_PRODUCT, "text", "h2"));
        String secondProductName = getTextElement(driver, replaceText(ProductPageUI.INFORMATION_SECOND_PRODUCT, "text", "p"));
        String secondProductPrice = getTextElement(driver, replaceText(ProductPageUI.INFORMATION_SECOND_PRODUCT, "text", "h2"));

        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "/products"));
        Log.allure("Click 'Products' button");
        hoverMouseToElement(driver, replaceText(ProductPageUI.HOVER_PRODUCT, "index", "1"));
        Log.allure("Hover over first product ");
        clickToElement(driver, replaceText(ProductPageUI.ADD_TO_CART_PRODUCT, "index", "1"));
        Log.allure("Click add to cart of first product");
        clickToElement(driver, CartPageUI.CONTINUE_SHOPPING_BUTTON);
        Log.allure("Click 'Continue Shopping' button");
        hoverMouseToElement(driver, replaceText(ProductPageUI.HOVER_PRODUCT, "index", "2"));
        Log.allure("Hover over second product ");
        clickToElement(driver, replaceText(ProductPageUI.ADD_TO_CART_PRODUCT, "index", "2"));
        Log.allure("Click add to cart of second product");
        clickToElement(driver, CartPageUI.VIEW_CART_BUTTON);
        Log.allure("Click 'View Cart' button");
        Assert.assertEquals(getTextElement(driver,replaceText(CartPageUI.NAME_PRODUCT, "index", "1")).toLowerCase(), firstProductName.toLowerCase());
        Assert.assertEquals(getTextElement(driver,replaceText(CartPageUI.PRICE_PRODUCT, "index", "1")).toLowerCase(), firstProductPrice.toLowerCase());
        Log.allure("First product is added to Cart");
        Assert.assertEquals(getTextElement(driver,replaceText(CartPageUI.NAME_PRODUCT, "index", "2")).toLowerCase(), secondProductName.toLowerCase());
        Assert.assertEquals(getTextElement(driver,replaceText(CartPageUI.PRICE_PRODUCT, "index", "2")).toLowerCase(), secondProductPrice.toLowerCase());
        Log.allure("Second product is added to Cart");
        Assert.assertEquals(getTextElement(driver,replaceText(CartPageUI.QUANTITY_PRODUCT, "index", "1")),"1");
        Log.allure("Quantity of first product is: 1");
        Assert.assertEquals(getTextElement(driver,replaceText(CartPageUI.QUANTITY_PRODUCT, "index", "2")),"1");
        Log.allure("Quantity of second product is: 1");
        Assert.assertEquals(firstProductPrice,getTextElement(driver,replaceText(CartPageUI.TOTAL_PRICE_PRODUCT,"index","1")));
        Log.allure("Total price of first product is correct");
        Assert.assertEquals(secondProductPrice,getTextElement(driver,replaceText(CartPageUI.TOTAL_PRICE_PRODUCT,"index","2")));
        Log.allure("Total price of second product is correct");
    }




    public void addAndVerifyProductWithQuantityIs4() {
        String secondProductName = getTextElement(driver, replaceText(ProductPageUI.INFORMATION_SECOND_PRODUCT, "text", "p"));
        clickToElement(driver,replaceText(HomePageUI.COMMON_BUTTON,"text","/product_details/2"));
        Log.allure("Click 'View Product' for any product on home page");
        Assert.assertEquals(getTitle(driver),"Automation Exercise - Product Details");
        Log.allure("Verify product detail is opened");
        sendKeyToElement(driver,replaceText(ProductPageUI.SEARCH_TEXTBOX,"text","quantity"),"4");
        Log.allure("Increase quantity to 4");
        clickToElement(driver,ProductPageUI.ADD_TO_CART_BUTTON);
        Log.allure("Click 'Add to cart' button");
        clickToElement(driver,CartPageUI.VIEW_CART_BUTTON);
        Log.allure("Click 'View Cart' button");
        Assert.assertEquals(getTextElement(driver,replaceText(CartPageUI.NAME_PRODUCT, "index", "2")).toLowerCase(), secondProductName.toLowerCase());
        Assert.assertEquals(getTextElement(driver,replaceText(CartPageUI.QUANTITY_PRODUCT,"index","2")),"4");
        Log.allure("Verify that product is displayed in cart page with exact quantity");

    }


}
