package com.vmo.automationexercise.interfaces;

public class AccountPageUI {

    public static final String COMMON_BUTTON = "//button[@data-qa='text']";//signup-button,create-account
    public static final String ACCOUNT_TITLE = "//div[@class='login-form']/h2[@class='title text-center']/b";
    public static final String TITLE_RADIO = "//label[@for='id_gender2']/div";
    public static final String COMMON_TEXTBOX = "//input[@id='text']";//password,first_name,last_name,company,address1,address2,state,city,zipcode,mobile_number
    public static final String COMMON_SELECT = "//select[@id='text']"; //days,months,years,country
    public static final String COMMON_CHECKBOX = "//label[@for='text']"; //newsletter,optin
    public static final String ACCOUNT_CREATED_LABEL = "//h2[@data-qa='account-created']/b";
    public static final String CONTINUE_CREATE_BUTTON = "//a[@data-qa='continue-button']";
    public static final String ACCOUNT_DELETE_LABEL = "//h2[@data-qa='account-deleted']/b";
    public static final String CONTINUE_DELETE_BUTTON = "//a[@class='btn btn-primary']";
    public static final String LOGIN_LABEL = "//i[@class='fa fa-user']/.."; //Logged in as
    public static final String LOGIN_NAME_LABEL = "//i[@class='fa fa-user']/../b";



}
