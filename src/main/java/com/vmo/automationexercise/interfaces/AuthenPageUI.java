package com.vmo.automationexercise.interfaces;

public class AuthenPageUI {
    public static final String COMMON_LABEL = "//div[@class='text']/h2";//signup-form,login-form
    public static final String COMMON_TEXTBOX = "//input[@name='text']";//name,password
    public static final String EMAIL_TEXTBOX = "//input[@data-qa='text']"; //signup-email,login-email
    public static final String LOGIN_BUTTON = "//button[@data-qa='login-button']";
    public static final String ERROR_MESSAGE = "//form[@action='text']/p";//'/login','/signup'

}
