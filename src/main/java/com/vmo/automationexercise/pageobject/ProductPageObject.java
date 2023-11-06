package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.HomePageUI;
import com.vmo.automationexercise.interfaces.ProductPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class ProductPageObject extends BasePage {
    WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyOnProductList() {
        clickToElement(driver, replaceText(HomePageUI.COMMON_BUTTON, "text", "/products"));
        Log.allure("Click on 'Products' button");
        Assert.assertEquals(getTitle(driver), "Automation Exercise - All Products");
        Log.allure("Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertTrue(isElementDisplay(driver, ProductPageUI.ALL_PRODUCT_LABEL));
        Log.allure("The products list is visible");
    }

    public void verifyOnDetailPage() {
        String price = getTextElement(driver,replaceText(ProductPageUI.INFORMATION_PRODUCT,"text","h2"));
        String name = getTextElement(driver,replaceText(ProductPageUI.INFORMATION_PRODUCT,"text","p"));
        clickToElement(driver, replaceText(ProductPageUI.VIEW_DETAIL_BUTTON, "index", "1"));
        Log.allure("Click on 'View Product' of first product");
        Assert.assertEquals(getTitle(driver),"Automation Exercise - Product Details");
        Log.allure("User is landed to product detail page");
        Assert.assertEquals(getTextElement(driver,replaceText(ProductPageUI.INFORMATION_PRODUCT_DETAIL,"text","h2")),name);
        Log.allure("Verify that detail detail is visible: product name");
        Assert.assertTrue(getTextElement(driver,replaceText(ProductPageUI.INFORMATION_PRODUCT_DETAIL,"text","p")).contains("Category"));
        Log.allure("Verify that detail detail is visible: category");
        Assert.assertEquals(getTextElement(driver,replaceText(ProductPageUI.INFORMATION_PRODUCT_DETAIL,"text","span/span")),price);
        Log.allure("Verify that detail detail is visible: price");
        Assert.assertTrue(getTextElement(driver,replaceText(ProductPageUI.OTHER_INFORMATION_PRODUCT_DETAIL,"index","1")).toLowerCase().contains("availability"));
        Log.allure("Verify that detail detail is visible: availability");
        Assert.assertTrue(getTextElement(driver,replaceText(ProductPageUI.OTHER_INFORMATION_PRODUCT_DETAIL,"index","2")).toLowerCase().contains("condition"));
        Log.allure("Verify that detail detail is visible: condition");
        Assert.assertTrue(getTextElement(driver,replaceText(ProductPageUI.OTHER_INFORMATION_PRODUCT_DETAIL,"index","3")).toLowerCase().contains("brand"));
        Log.allure("Verify that detail detail is visible: brand");
    }

    public void verifySearchResult(String searchKey) {
        ArrayList<String> arrResultSearchProduct = new ArrayList<String>();
        sendKeyToElement(driver,ProductPageUI.SEARCH_TEXTBOX,searchKey);
        Log.allure("Enter product name in search input: %s",searchKey);
        clickToElement(driver,ProductPageUI.SEARCH_BUTTON);
        Log.allure("Click search button");
        Assert.assertEquals(getTextElement(driver,ProductPageUI.SEARCH_PRODUCT_TITLE),"SEARCHED PRODUCTS");
        Log.allure("Verify 'SEARCHED PRODUCTS' is visible");
        arrResultSearchProduct = getListProduct(driver,ProductPageUI.PRODUCT_NAME);
        String result = checkResultSearch(arrResultSearchProduct,searchKey);
        Assert.assertEquals(result,"All the products related to search");
        Log.allure("Verify all the products related to search are visible");

    }
    public ArrayList<String> getListProduct(WebDriver driver, String locator){
        ArrayList<String> arrProductName = new ArrayList<String>();
        List<WebElement> element_product = driver.findElements(By.xpath(locator));
        for(int i =0;i<element_product.size();i++){
            arrProductName.add(element_product.get(i).getText());
        }
        return arrProductName;
    }
    public String checkResultSearch(ArrayList<String> arr,String searchKey){
        int lengthArrayResultSearch = arr.size();
        int count = 0;
        String result="";
        for(int i=0;i<lengthArrayResultSearch;i++){
            if(arr.get(i).toLowerCase().contains(searchKey.toLowerCase())){
                count += 1;
            }
        }
        if(count ==lengthArrayResultSearch){
            result="All the products related to search";
        }
        return result;
    }
}
