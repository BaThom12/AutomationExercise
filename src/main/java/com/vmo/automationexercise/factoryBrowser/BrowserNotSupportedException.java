package com.vmo.automationexercise.factoryBrowser;

public class BrowserNotSupportedException extends IllegalStateException {
    private static final long serialVersion = 1L;

    public BrowserNotSupportedException(String browserName) {
        super(String.format("Browser not supported : %s", browserName));
    }
}
