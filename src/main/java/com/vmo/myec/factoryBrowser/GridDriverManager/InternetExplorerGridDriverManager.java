package com.vmo.myec.factoryBrowser.GridDriverManager;

import com.vmo.nopcommerce.common.GlobalConstants;
import com.vmo.nopcommerce.factoryBrowser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class InternetExplorerGridDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.attachToEdgeChrome();
        try {
            return new RemoteWebDriver(new URL(GlobalConstants.HUB_URL), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
