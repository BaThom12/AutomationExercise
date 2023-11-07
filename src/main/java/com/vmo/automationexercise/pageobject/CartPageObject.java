package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.CartPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import com.vmo.automationexercise.interfaces.ProductPageUI;
import org.openqa.selenium.WebDriver;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class CartPageObject extends BasePage {
    WebDriver driver;
    public CartPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void addProductInCart() {
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON,"text","/products"));
        Log.allure("Click 'Products' button");
        hoverMouseToElement(driver, replaceText(ProductPageUI.HOVER_PRODUCT,"index","1"));
        Log.allure("Hover over first product ");
        clickToElement(driver,replaceText(ProductPageUI.ADD_TO_CART_PRODUCT,"index","1"));
        Log.allure("Click add to cart of first product");
        clickToElement(driver, CartPageUI.CONTINUE_SHOPPING_BUTTON);
        Log.allure("Click 'Continue Shopping' button");
        hoverMouseToElement(driver, replaceText(ProductPageUI.HOVER_PRODUCT,"index","2"));
        Log.allure("Hover over second product ");
        clickToElement(driver,replaceText(ProductPageUI.ADD_TO_CART_PRODUCT,"index","2"));
        Log.allure("Click add to cart of second product");


    }


    public void verifyProductInCard() {
    }

}
