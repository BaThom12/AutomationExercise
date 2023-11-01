package com.vmo.myec.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Collections;

public class EdgeDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        return new EdgeDriver(options);
    }
}
