package com.vmo.automationexercise.pageobject;

import com.vmo.automationexercise.common.BasePage;
import com.vmo.automationexercise.helper.Log;
import com.vmo.automationexercise.interfaces.CartPageUI;
import com.vmo.automationexercise.interfaces.HomePageUI;
import com.vmo.automationexercise.interfaces.ProductPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.vmo.automationexercise.pageobject.CommonPageObject.replaceText;

public class ProductPageObject extends BasePage {
    WebDriver driver;
    ArrayList<String> arrNameProduct = new ArrayList<>();

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
        String price = getTextElement(driver, replaceText(ProductPageUI.INFORMATION_FIRST_PRODUCT, "text", "h2"));
        String name = getTextElement(driver, replaceText(ProductPageUI.INFORMATION_FIRST_PRODUCT, "text", "p"));
        clickToElement(driver, replaceText(ProductPageUI.VIEW_DETAIL_BUTTON, "index", "1"));
        Log.allure("Click on 'View Product' of first product");
        Assert.assertEquals(getTitle(driver), "Automation Exercise - Product Details");
        Log.allure("User is landed to product detail page");
        Assert.assertEquals(getTextElement(driver, replaceText(ProductPageUI.INFORMATION_PRODUCT_DETAIL, "text", "h2")), name);
        Log.allure("Verify that detail detail is visible: product name");
        Assert.assertTrue(getTextElement(driver, replaceText(ProductPageUI.INFORMATION_PRODUCT_DETAIL, "text", "p")).contains("Category"));
        Log.allure("Verify that detail detail is visible: category");
        Assert.assertEquals(getTextElement(driver, replaceText(ProductPageUI.INFORMATION_PRODUCT_DETAIL, "text", "span/span")), price);
        Log.allure("Verify that detail detail is visible: price");
        Assert.assertTrue(getTextElement(driver, replaceText(ProductPageUI.OTHER_INFORMATION_PRODUCT_DETAIL, "index", "1")).toLowerCase().contains("availability"));
        Log.allure("Verify that detail detail is visible: availability");
        Assert.assertTrue(getTextElement(driver, replaceText(ProductPageUI.OTHER_INFORMATION_PRODUCT_DETAIL, "index", "2")).toLowerCase().contains("condition"));
        Log.allure("Verify that detail detail is visible: condition");
        Assert.assertTrue(getTextElement(driver, replaceText(ProductPageUI.OTHER_INFORMATION_PRODUCT_DETAIL, "index", "3")).toLowerCase().contains("brand"));
        Log.allure("Verify that detail detail is visible: brand");
    }

    public void verifySearchResult(String searchKey) {
        ArrayList<String> arrResultSearchProduct = new ArrayList<String>();
        sendKeyToElement(driver, replaceText(ProductPageUI.SEARCH_TEXTBOX, "text", "search_product"), searchKey);
        Log.allure("Enter product name in search input: %s", searchKey);
        clickToElement(driver, ProductPageUI.SEARCH_BUTTON);
        Log.allure("Click search button");
        Assert.assertEquals(getTextElement(driver, ProductPageUI.SEARCH_PRODUCT_TITLE), "SEARCHED PRODUCTS");
        Log.allure("Verify 'SEARCHED PRODUCTS' is visible");
        arrResultSearchProduct = getListNameProduct(driver, ProductPageUI.PRODUCT_NAME);
        String result = checkResultSearch(arrResultSearchProduct, searchKey);
        Assert.assertEquals(result, "All the products related to search");
        Log.allure("Verify all the products related to search are visible");

    }

    public ArrayList<String> getListNameProduct(WebDriver driver, String locator) {
        ArrayList<String> arrProductName = new ArrayList<String>();
        List<WebElement> element_product = driver.findElements(By.xpath(locator));
        for (int i = 0; i < element_product.size(); i++) {
            arrProductName.add(element_product.get(i).getText());
        }
        return arrProductName;
    }

    public ArrayList<Integer> getListIndexSearchedProduct(WebDriver driver, String locator) {
        ArrayList<Integer> arrIndex = new ArrayList<Integer>();
        List<WebElement> element_product = driver.findElements(By.xpath(locator));
        for (int i = 0; i < element_product.size(); i++) {
            //arrIndex.add(element_product.get(i).getAttribute("data-product-id"));
        }
        return arrIndex;
    }


    public String checkResultSearch(ArrayList<String> arr, String searchKey) {
        int lengthArrayResultSearch = arr.size();
        int count = 0;
        String result = "";
        for (int i = 0; i < lengthArrayResultSearch; i++) {
            if (arr.get(i).toLowerCase().contains(searchKey.toLowerCase())) {
                count += 1;
            }
        }
        if (count == lengthArrayResultSearch) {
            result = "All the products related to search";
        }
        return result;
    }

    public void addSearchedProductToCart() {
     /*  List<Integer> index = new ArrayList<>();
        index.add(2);
        index.add(7);
        index.add(42);
        index.add(43);*/

        List<WebElement> index = new ArrayList<>();
        index = getListWebElements(driver, ProductPageUI.ADD_TO_CART_SEARCHED_PRODUCTS);
        for (int i = 0; i < 4; i++) {
            hoverMouseToElement(driver, ProductPageUI.ADD_TO_CART_SEARCHED_PRODUCTS);
            // clickToElement(driver, index.get(i));
            index.get(i).click();
            clickToElement(driver, CartPageUI.CONTINUE_SHOPPING_BUTTON);
        }
        Log.allure("Add those products to cart");

    }

    public void verifySearchedProductInCart() {
        arrNameProduct = getListNameProduct(driver, ProductPageUI.PRODUCT_NAME);
        clickToElement(driver, replaceText(HomePageUI.CATEGORY_COMMON, "text", "/view_cart"));
        Log.allure("Click 'Cart' button");
        ArrayList<String> arrNameInCart = new ArrayList<String>();
        List<WebElement> arrTemp = getListWebElements(driver, CartPageUI.NAME_PRODUCT_IN_CART);
        for (int i = 0; i < arrTemp.size(); i++) {
            arrNameInCart.add(arrTemp.get(i).getText().toString());
        }
        Collections.sort(arrNameProduct);
        Collections.sort(arrNameInCart);
        for (int i = 0; i < arrNameProduct.size(); i++) {
            if (arrNameProduct.get(i).equals(arrNameInCart.get(i))) {
                Log.allure("verify that products are visible in cart");
            }
        }
    }

    public void verifyrReviewProductSuccessful() throws ElementClickInterceptedException {
        scrollToElement(driver,replaceText(ProductPageUI.VIEW_DETAIL_BUTTON, "index", "1"));
        clickToElement(driver, replaceText(ProductPageUI.VIEW_DETAIL_BUTTON, "index", "1"));
        Log.allure("Click on 'View Product' button");
        Assert.assertTrue(isElementDisplay(driver, replaceText(ProductPageUI.VIEW_DETAIL_BUTTON, "/product_details/index", "#reviews")));
        Log.allure("Verify 'Write Your Review' is visible");
        sendKeyToElement(driver, replaceText(ProductPageUI.INFOR_REVIEW, "text", "name"), "Thom");
        sendKeyToElement(driver, replaceText(ProductPageUI.INFOR_REVIEW, "text", "email"), "olkachizhova@shonecool.club");
        sendKeyToElement(driver, ProductPageUI.COMMENT_REVIEW, "Good product");
        Log.allure("Enter name, email and review");
        clickToElement(driver, ProductPageUI.BUTTON_REVIEW);
        Log.allure("Click 'Submit' button");
        Assert.assertEquals(getTextElement(driver, ProductPageUI.MESSAGE_REVIEW_SUCCESS), "Thank you for your review.");
        Log.allure("Verify success message 'Thank you for your review.'");


    }
}
