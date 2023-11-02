package com.vmo.automationexercise.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class InternetExplorerDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.attachToEdgeChrome();
        options.withEdgeExecutablePath(System.getProperty("webdriver.edge.binary"));
        return new InternetExplorerDriver(options);
    }
}
