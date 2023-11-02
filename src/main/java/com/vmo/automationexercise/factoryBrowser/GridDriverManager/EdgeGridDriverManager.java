package com.vmo.automationexercise.factoryBrowser.GridDriverManager;

import com.vmo.nopcommerce.common.GlobalConstants;
import com.vmo.nopcommerce.factoryBrowser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeGridDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        try {
            return new RemoteWebDriver(new URL(GlobalConstants.HUB_URL), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
