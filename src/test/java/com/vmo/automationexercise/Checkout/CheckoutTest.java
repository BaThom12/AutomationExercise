package com.vmo.automationexercise.Checkout;

import com.vmo.automationexercise.common.BaseTest;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.pageobject.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("AutomationExercise")
@Feature("Checkout")
@Story("Checkout product")
public class CheckoutTest extends BaseTest {
    WebDriver driver;
    HomePageObject homepage;
    ProductPageObject product;
    CartPageObject cart;
    CheckoutPageObject checkout;
    AccountPageObject account;
    AuthenPageObject authen;

    @Parameters({"browser", "runType"})
    @BeforeMethod
    public void setup(String browser, String type) {
        driver = getDriverBrowser(browser, type);
        driver.manage().window().maximize();
        Log.info("Open browser");
        homepage = new HomePageObject(driver);
        homepage.openHomePage(driver);
        Log.info("Open Automation exercise shop");
        product = new ProductPageObject(driver);
        cart = new CartPageObject(driver);
        checkout = new CheckoutPageObject(driver);
        account = new AccountPageObject(driver);
        authen = new AuthenPageObject(driver);
    }
    @Test
    public void TC01_PlaceOrderRegisterWhileCheckout(){
        homepage.verifyOnHomePage(driver);
        cart.addProductToCartFromHomepage();
        checkout.loginBeforeCheckout();
        account.verifyEnterNameAndEmail();
        account.verifyCreateAccountSuccessful();
        account.verifyLoginSuccessful();
        checkout.checkoutProduct();
        checkout.verifyAddressAndProductInCart();
        checkout.enterInformationCheckout();
    }
    @Test
    public void TC02_PlaceOrderRegisterBeforeCheckout(){
        homepage.verifyOnHomePage(driver);
        homepage.verifyOnSignUpPage();
        account.verifyEnterNameAndEmail();
        account.verifyCreateAccountSuccessful();
        account.verifyLoginSuccessful();
        cart.addProductToCartFromHomepage();
        checkout.checkoutProduct();
        checkout.verifyAddressAndProductInCart();
        checkout.enterInformationCheckout();
    }
    @Test
    public void TC03_PlaceOrderLoginBeforeCheckout(){
        homepage.verifyOnHomePage(driver);
        authen.verifyOnLoginPage();
        authen.verifyLoginSuccessful();
        cart.addProductToCartFromHomepage();
        checkout.checkoutProduct();
        checkout.verifyNameAndProductInCart();
        checkout.enterInformationCheckout();
    }
    @Test
    public void TC04_VerifyAddressDetailsInCheckoutPage(){
        homepage.verifyOnHomePage(driver);
        homepage.verifyOnSignUpPage();
        account.verifyEnterNameAndEmail();
        account.verifyCreateAccountSuccessful();
        account.verifyLoginSuccessful();
        cart.addProductToCartFromHomepage();
        checkout.checkoutProduct();
        checkout.verifyNameAndProductInCart();
        checkout.enterInformationCheckout();
    }
    @Test
    public void TC05_DownloadInvoiceAfterPurchaseOrder(){
        homepage.verifyOnHomePage(driver);
        cart.addProductToCartFromHomepage();
        cart.checkout();
        account.verifyEnterNameAndEmail();
        account.verifyCreateAccountSuccessful();
        account.verifyLoginSuccessful();
        checkout.checkoutProduct();
        checkout.verifyNameAndProductInCart();
        checkout.enterInformationCheckout();
        checkout.verifyDownloadInvoiceSuccessful();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
