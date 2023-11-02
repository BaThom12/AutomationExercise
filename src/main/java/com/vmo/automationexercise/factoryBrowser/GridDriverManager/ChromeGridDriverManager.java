package com.vmo.automationexercise.factoryBrowser.GridDriverManager;

import com.vmo.nopcommerce.common.GlobalConstants;
import com.vmo.nopcommerce.factoryBrowser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeGridDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "100");
        options.setCapability("platformName", "Windows");
// Showing a test name instead of the session id in the Grid UI
        options.setCapability("se:name", "My simple test");
// Other type of metadata can be seen in the Grid UI by clicking on the
// session info or via GraphQL
        options.setCapability("se:sampleMetadata", "Sample metadata value");
        try {
            return new RemoteWebDriver(new URL(GlobalConstants.HUB_URL), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
