package com.vmo.automationexercise.factoryBrowser.GridDriverManager;

import com.vmo.automationexercise.common.GlobalConstants;
import com.vmo.automationexercise.factoryBrowser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class SafariGridDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        SafariOptions options = new SafariOptions();
        try {
            return new RemoteWebDriver(new URL(GlobalConstants.HUB_URL), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
