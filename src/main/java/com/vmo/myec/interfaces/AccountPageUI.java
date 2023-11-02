package com.vmo.myec.interfaces;

public class AccountPageUI {
    public static final String SIGNUP_LABEL = "//div[@class='signup-form']/h2";
    public static final String NAME_TEXTBOX = "//input[@name='text']";//name,email
    public static final String SIGNUP_BUTTON = "//button[@data-qa='text']";//signup-button,create-account
    public static final String ACCOUNT_TITLE = "//div[@class='login-form']/h2[@class='title text-center']/b";
    public static final String GENDER_RADIO = "//label[@for='id_gender2']/div";
    public static final String PASSWORD_TEXTBOX = "//input[@id='text']";//password,first_name,last_name,company,address1,address2,state,city,zipcode,mobile_number
    public static final String DATE_OF_BIRTH_SELECT = "//select[@id='texts']"; //days,months,years,country
    public static final String NEWSLETTER_CHECKBOX = "//input[@name='text']"; //newsletter,optin
    public static final String ACCOUNT_CREATED_LABEL = "//h2[@data-qa='account-created']/b";
    public static final String CONTINUE_CREATE_BUTTON = "//a[@data-qa='continue-button']";
    public static final String ACCOUNT_DELETE_LABEL = "//h2[@data-qa='account-deleted']/b";
    public static final String CONTINUE_DELETE_BUTTON = "//a[@class='btn btn-primary']";



}
