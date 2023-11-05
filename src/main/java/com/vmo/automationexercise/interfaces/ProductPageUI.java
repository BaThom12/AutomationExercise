package com.vmo.automationexercise.interfaces;

public class ProductPageUI {
    //list product
    public static final String ALL_PRODUCT_LABEL = "//div[@class='features_items']/h2";
    public static final String VIEW_DETAIL_BUTTON = "//a[@href='/product_details/index']";
    public static final String INFORMATION_PRODUCT = "//a[@data-product-id='1']/../text";//h2,p
    //detail product
    public static final String INFORMATION_PRODUCT_DETAIL = "//div[@class='product-information']/text";//h2,p
    public static final String OTHER_INFORMATION_PRODUCT_DETAIL = "(//div[@class='product-information']//p/b)[index]";



}
