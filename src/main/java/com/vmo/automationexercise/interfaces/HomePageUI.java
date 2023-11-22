package com.vmo.automationexercise.interfaces;

public class HomePageUI {
    public static final String AUTOMATION_URL = "http://automationexercise.com";
    public static final String COMMON_BUTTON = "//a[@href='text']";//'/login','/delete_account','/logout','/contact_us','/test_cases','/products','/view_cart','/product_details/index'
    public static final String LEFT_SIDEBAR_LABEL = "//div[@class='text']/h2"; //left-sidebar,brands_products
    public static final String SUBSCRIPTION_TEXTBOX = "//input[@id='susbscribe_email']";
    public static final String ARROW_BUTTON = "//button[@id='subscribe']";
    public static final String SUBSCRIPTION_MESSAGE_SUCCESS = "//div[@class='alert-success alert']";
    public static final String SUBSCRIPTION_LABEL = "//div[@class='single-widget']/h2";
    public static final String CATEGORY_COMMON = "//a[@href='text']";//'#Women','/category_products/1','#Men','/brand_products/Madame'
    public static final String TOP_SUBCATEGORY = "//h2[@class='title text-center']";
    public static final String RECOMMENED_ITEM = "//div[@class='recommended_items']/h2";
    public static final String RECOMMENED_ADD_TO_CART = "//div[@id='recommended-item-carousel']//a[@data-product-id='1']";
    public static final String SCROLL_UP = "//a[@id='scrollUp']";
    public static final String LOGO = "//div[@class='logo pull-left']";
    public static final String SLIDER = "(//div[@id='slider-carousel']//div[@class='carousel-inner']//h2)[1]";

}
