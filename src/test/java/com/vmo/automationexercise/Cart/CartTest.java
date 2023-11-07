package com.vmo.automationexercise.Cart;

import com.vmo.automationexercise.common.BaseTest;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.pageobject.CartPageObject;
import com.vmo.automationexercise.pageobject.HomePageObject;
import com.vmo.automationexercise.pageobject.ProductPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("AutomationExercise")
@Feature("Cart")
@Story("Add product to card, view detail cart")

public class CartTest extends BaseTest {
    WebDriver driver;
    HomePageObject homepage;
    CartPageObject cart;

    @Parameters({"browser", "runType"})
    @BeforeMethod
    public void setup(String browser, String type) {
        driver = getDriverBrowser(browser, type);
        driver.manage().window().maximize();
        Log.info("Open browser");
        homepage = new HomePageObject(driver);
        homepage.openHomePage(driver);
        Log.info("Open Automation exercise shop");
        cart = new CartPageObject(driver);
    }
    @Test
    public void TC01_AddProductsInCart(){
        homepage.verifyOnHomePage(driver);
        cart.addProductInCart();
        cart.verifyProductInCard();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
