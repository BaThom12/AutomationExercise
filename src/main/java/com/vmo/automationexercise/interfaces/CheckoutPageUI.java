package com.vmo.automationexercise.interfaces;

public class CheckoutPageUI {
    public static final String PROCEED_TO_CHECKOUT_BUTTON = "//a[@class='btn btn-default check_out']";
    public static final String LOGIN_LINK = "//p//a[@href='/login']";////div[@class='modal-body']//a[@href='/login']
    public static final String YOUR_BILLING_ADDRESS = "//ul[@class='address alternate_item box']//li[@class='text']";
    //address_firstname address_lastname,address_address1 address_address2,address_city address_state_name address_postcode,address_country_name,address_phone
    public static final String COMMENT_ORDER = "//textarea[@name='message']";
    public static final String PLACE_ORDER_BUTTON = "//a[@class='btn btn-default check_out']";
    public static final String CARD_COMMON_TEXTBOX = "//input[@name='text']";//name_on_card,card_number,cvc,expiry_month,expiry_year
    public static final String ORDER_BUTTON = "//button[@id='submit']";
    public static final String ORDER_SUCCESS = "//div[contains(text(),'Your order has been placed successfully!')]";
    public static final String DOWNLOAD_INVOICE = "//a[text()='Download Invoice']";
    public static final String CONTINUE_BUTTON = "//a[@data-qa='continue-button']";

    }