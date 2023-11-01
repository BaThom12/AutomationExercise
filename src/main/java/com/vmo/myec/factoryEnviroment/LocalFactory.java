package com.vmo.myec.factoryEnviroment;

import com.vmo.nopcommerce.factoryBrowser.*;
import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browser) {
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME":
                driver = new ChromeHeadlessDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FireFoxHeadlessDriverManager().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            case "INTERNET_EXPLORER":
                driver = new InternetExplorerDriverManager().getBrowserDriver();
                break;
            case "SAFARI":
                driver = new SafariDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }
        return driver;
    }
}
