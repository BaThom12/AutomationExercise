package com.vmo.automationexercise.pageobject;

public class CommonPageObject {
    public static String replaceText(String locator, String actual, String expect) {
        return locator.replace(actual, expect);
    }
}
