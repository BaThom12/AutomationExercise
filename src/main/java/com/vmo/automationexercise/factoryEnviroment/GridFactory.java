package com.vmo.automationexercise.factoryEnviroment;

import com.vmo.automationexercise.factoryBrowser.BrowserNotSupportedException;
import com.vmo.automationexercise.factoryBrowser.GridDriverManager.*;
import com.vmo.automationexercise.factoryBrowser.*;
import com.vmo.automationexercise.factoryBrowser.GridDriverManager.*;
import org.openqa.selenium.WebDriver;

public class GridFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browser) {
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME":
                driver = new ChromeGridDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FireFoxGridDriverManager().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeGridDriverManager().getBrowserDriver();
                break;
            case "INTERNET_EXPLORER":
                driver = new InternetExplorerGridDriverManager().getBrowserDriver();
                break;
            case "SAFARI":
                driver = new SafariGridDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }
        return driver;
    }
}
