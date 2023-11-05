package com.vmo.automationexercise.Product;

import com.vmo.automationexercise.common.BaseTest;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.pageobject.HomePageObject;
import com.vmo.automationexercise.pageobject.ProductPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("AutomationExercise")
@Feature("Product")
@Story("List,  detail product")
public class ProductTest extends BaseTest {
    WebDriver driver;
    HomePageObject homepage;
    ProductPageObject product;

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
    }

    @Test
    public void TC09_VerifyAllProductsAndProductDetailPage() throws ElementClickInterceptedException {
        homepage.verifyOnHomePage(driver);
        product.verifyOnProductList();
        product.verifyOnDetailPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
