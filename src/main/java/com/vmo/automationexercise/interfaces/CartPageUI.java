package com.vmo.automationexercise.interfaces;

public class CartPageUI {
    public static final String CONTINUE_SHOPPING_BUTTON = "//button[@class='btn btn-success close-modal btn-block']";
    public static final String VIEW_CART_BUTTON = "//p//a[@href='/view_cart']";
    public static final String NAME_PRODUCT = "//a[@href='/product_details/index']";//1,2
    public static final String PRICE_PRODUCT = "//tr[@id='product-index']/td[@class='cart_price']/p";//1,2
    public static final String QUANTITY_PRODUCT = "//tr[@id='product-index']/td[@class='cart_quantity']/button";//1,2
    public static final String TOTAL_PRICE_PRODUCT = "//tr[@id='product-index']//p[@class='cart_total_price']";//1,2
}
