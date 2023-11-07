package com.vmo.automationexercise.interfaces;

public class ProductPageUI {
    //list product
    public static final String ALL_PRODUCT_LABEL = "//div[@class='features_items']/h2";
    public static final String VIEW_DETAIL_BUTTON = "//a[@href='/product_details/index']";
    public static final String INFORMATION_PRODUCT = "//a[@data-product-id='1']/../text";//h2,p
    public static final String KEY_SEARCH = "Men";
    public static final String HOVER_PRODUCT = "(//div[@class='product-overlay'])[index]";//1,2
    public static final String ADD_TO_CART_PRODUCT = "//div[@class='overlay-content']/a[@data-product-id='index']";//1,2
    //detail product
    public static final String INFORMATION_PRODUCT_DETAIL = "//div[@class='product-information']/text";//h2,p
    public static final String OTHER_INFORMATION_PRODUCT_DETAIL = "(//div[@class='product-information']//p/b)[index]";
    public static final String SEARCH_TEXTBOX = "//input[@id='search_product']";
    public static final String SEARCH_BUTTON = "//button[@id='submit_search']";
    public static final String SEARCH_PRODUCT_TITLE = "//h2[@class='title text-center']";
    public static final String PRODUCT_NAME = "//div[@class='productinfo text-center']/p";





}
