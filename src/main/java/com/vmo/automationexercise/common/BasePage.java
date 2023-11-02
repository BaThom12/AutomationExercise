package com.vmo.automationexercise.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {
    private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
    private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
    private Alert alert;
    private WebDriverWait explicit;
    private Select select;
    private JavascriptExecutor jsExecutor;
    private Actions action;

    protected static BasePage getBasePage() {
        return new BasePage();
    }

    protected void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected Set<Cookie> getAllCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    protected void setAllCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    protected String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    //set lai wait
    protected void overrideImplicitTimeOut(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    protected Alert waitAlertPresence(WebDriver driver) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        return alert = explicit.until(ExpectedConditions.alertIsPresent());
    }

    protected boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideImplicitTimeOut(driver, shortTimeOut);
        List<WebElement> listElement = getListWebElements(driver, locator);
        overrideImplicitTimeOut(driver, longTimeOut);
        if (listElement.size() == 0) {
            return true;
        } else if (!listElement.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isElementUndisplayed(WebDriver driver, String locator, String... params) {
        locator = getDynamiLocator(locator, params);
        overrideImplicitTimeOut(driver, shortTimeOut);
        List<WebElement> listElement = getListWebElements(driver, locator);
        overrideImplicitTimeOut(driver, longTimeOut);
        if (listElement.size() == 0) {
            return true;
        } else if (!listElement.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    protected void acceptAlert(WebDriver driver) {
        alert = waitAlertPresence(driver);
        alert.accept();
    }

    protected void dismissAlert(WebDriver driver) {
        alert = waitAlertPresence(driver);
        alert.dismiss();
    }

    protected String getTextAlert(WebDriver driver) {
        alert = waitAlertPresence(driver);
        return alert.getText();
    }

    protected void sendKeysToAlert(WebDriver driver, String value) {
        alert = waitAlertPresence(driver);
        alert.sendKeys(value);
    }

    protected void switchWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    protected void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    protected void closeTabWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);

    }

    protected void openNewTabByRobot(WebDriver driver, int index) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    protected void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected By getXPathLocator(String locator) {
        return By.xpath(locator);
    }

    protected WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getXPathLocator(locator));
    }

    protected WebElement getWebElement(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver, locator, params);
        locator = getDynamiLocator(locator, params);
        return driver.findElement(getXPathLocator(locator));
    }

    protected List<WebElement> getListWebElements(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return driver.findElements(getXPathLocator(locator));
    }

    protected List<WebElement> getListWebElements(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver, locator, params);
        return driver.findElements(getXPathLocator(getDynamiLocator(locator, params)));
    }

    protected List<String> getListTextElements(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        List<WebElement> listSearch = driver.findElements(By.xpath(locator));
        List<String> listNameProduct = new ArrayList<>();
        for (WebElement childElement : listSearch) {
            listNameProduct.add(childElement.getText());
        }
        return listNameProduct;
    }

    protected int getElementSize(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return getListWebElements(driver, locator).size();
    }

    protected int getElementSize(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver, locator, params);
        return getListWebElements(driver, locator, params).size();
    }

    protected void clickToElement(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        getWebElement(driver, locator).click();
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String value) {
        waitForElementVisible(driver,locator);
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(value);
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String value, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(value);
    }

    protected void selectItemInDefaultDropdownByText(WebDriver driver, String locator, String itemText) {
        waitForElementVisible(driver,locator);
        select = new Select(getWebElement(driver, locator));
        select.selectByVisibleText(itemText);
    }

    protected void selectItemInDefaultDropdownByText(WebDriver driver, String locator, String itemText, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        select = new Select(getWebElement(driver, locator));
        select.selectByVisibleText(itemText);
    }

    protected String getSelectedItemInDefaultDropdown(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        select = new Select(getWebElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    protected String getSelectedItemInDefaultDropdown(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        select = new Select(getWebElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropdownMultiple(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        select = new Select(getWebElement(driver, locator));
        return select.isMultiple();
    }

    protected void selectItemInCustomDropdown(WebDriver driver, String xPathParent, String xPathChild, String expectedItem) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        jsExecutor = (JavascriptExecutor) driver;
        clickToElement(driver, xPathParent);
        sleepInSecond(1);
        List<WebElement> listItems = explicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getXPathLocator(xPathChild)));
        for (WebElement item : listItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }

        }
    }

    protected String getAttributeElement(WebDriver driver, String locator, String attributeName) {
        waitForElementVisible(driver,locator);
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    protected String getAttributeElement(WebDriver driver, String locator, String attributeName, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    protected String getTextElement(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        return getWebElement(driver, locator).getText();
    }

    protected String getTextElement(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        return getWebElement(driver, locator).getText();
    }

    protected String convertRgbaToHex(String rgba) {
        String color = Color.fromString(rgba).asHex();
        return color;
    }

    protected String getCssValueElement(WebDriver driver, String locator, String cssAttribute) {
        waitForElementVisible(driver,locator);
        return getWebElement(driver, locator).getCssValue(cssAttribute);
    }

    protected void checkToDefaultCheckboxOrDefaultRadio(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        if (!isElementSelected(driver, locator)) {
            clickToElement(driver, locator);
        }
    }

    protected void checkToDefaultCheckboxOrDefaultRadio(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver,locator,params);
        if (!isElementSelected(driver, locator, params)) {
            clickToElement(driver, locator, params);
        }

    }

    protected void uncheckToDefaultCheckbox(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        if (isElementSelected(driver, locator)) {
            clickToElement(driver, locator);
        }
    }

    protected boolean isElementDisplay(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        try {
            return getWebElement(driver, locator).isDisplayed();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    protected boolean isElementDisplay(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        return getWebElement(driver, locator).isDisplayed();
    }

    protected boolean isElementSelected(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        return getWebElement(driver, locator).isSelected();
    }

    protected boolean isElementSelected(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        return getWebElement(driver, locator).isSelected();
    }

    protected boolean isElementEnabled(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        return getWebElement(driver, locator).isEnabled();
    }

    protected void switchToFrameOrIFrameByElement(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        driver.switchTo().frame(getWebElement(driver, locator));
    }

    protected void switchToDefaultContent(WebDriver driver, String locator) {
        driver.switchTo().defaultContent();
    }

    protected void doubleClickToElement(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        action = new Actions(driver);
        action.doubleClick(getWebElement(driver, locator)).perform();
    }

    protected void hoverMouseToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locator)).perform();
    }

    protected void hoverMouseToElement(WebDriver driver, String locator, String... params) {
        locator = getDynamiLocator(locator, params);
        action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locator)).perform();
    }

    protected void rightCLickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.contextClick(getWebElement(driver, locator)).perform();
    }

    protected void dragAndDrop(WebDriver driver, String locatorSource, String locatorTarget) {
        action = new Actions(driver);
        WebElement source = getWebElement(driver, locatorSource);
        WebElement target = getWebElement(driver, locatorTarget);
        action.dragAndDrop(source, target).perform();
    }

    protected void pressKeyboardToElemntByActions(WebDriver driver, String locator, Keys key) {
        waitForElementVisible(driver,locator);
        action = new Actions(driver);
        action.sendKeys(getWebElement(driver, locator), key).perform();
    }

    protected void pressKeyboardToElemnt(WebDriver driver, String locator, Keys key) {
        waitForElementVisible(driver,locator);
        getWebElement(driver, locator).sendKeys(key);
    }

    protected void pressKeyboardToElemnt(WebDriver driver, String locator, Keys key, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        getWebElement(driver, locator).sendKeys(key);
    }

    protected Object executeForBrowser(WebDriver driver, String javaScript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    protected String getInnerText(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    protected boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    protected void scrollToBottomPage(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void navigateToUrlByJS(WebDriver driver, String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    protected void highlightElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");

        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    protected void clickToElementByJS(WebDriver driver, String locator) {
        waitForElementVisible(driver,locator);
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
    }

    protected void clickToElementByJS(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
    }

    protected void scrollToElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    protected void scrollToElement(WebDriver driver, String locator, String... params) {
        jsExecutor = (JavascriptExecutor) driver;
        locator = getDynamiLocator(locator, params);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }


    protected void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        waitForElementVisible(driver,locator);
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
    }

    protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    protected String getTextElementByJS(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver,locator,params);
        locator = getDynamiLocator(locator, params);
        jsExecutor = (JavascriptExecutor) driver;
        String script = "return $(document.evaluate(" + "\"" + locator + "\"" + ", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()";
//
        return (String) jsExecutor.executeScript(script);
    }

    protected String getElementValidationMessage(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;

        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    protected boolean isImageLoaded(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        return (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));

    }

    protected boolean isJQueryLoadSuccess(WebDriver driver) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                // TODO Auto-generated method stub
                return (Boolean) jsExecutor.executeScript("return (window.jQuery!=null) && (jQuery.active===0);");

            }

        };
        return explicit.until(jQueryLoad);
    }

    protected boolean isjQueryAndPageLoadSuccess(WebDriver driver) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                // TODO Auto-generated method stub
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active;") == 0);
                } catch (Exception e) {
                    return true;
                }

            }

        };
        ExpectedCondition<Boolean> PageLoadSuccess = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                // TODO Auto-generated method stub
                return (Boolean) jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }

        };
        return explicit.until(jQueryLoad) && explicit.until(PageLoadSuccess);
    }

    protected void waitForElementVisible(WebDriver driver, String locator) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.visibilityOfElementLocated(getXPathLocator(locator)));
    }

    protected void waitForElementVisible(WebDriver driver, String locator, String... params) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.visibilityOfElementLocated(getXPathLocator(getDynamiLocator(locator, params))));
    }

    protected void waitForAllElementsVisible(WebDriver driver, String locator) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXPathLocator(locator)));
    }

    protected void waitForAllElementsVisible(WebDriver driver, String locator, String... params) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        locator = getDynamiLocator(locator, params);
        explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXPathLocator(locator)));
    }

    protected void waitForElementInvisible(WebDriver driver, String locator) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXPathLocator(locator)));

    }

    /*
     *
     * Wait for element undisplayed in DOM or not DOM and overide time out
     */
    protected void waitForElementUnDisplay(WebDriver driver, String locator, String... params) {
        locator = getDynamiLocator(locator, params);
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        overrideImplicitTimeOut(driver, shortTimeOut);
        explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXPathLocator(locator)));

    }

    protected void waitForElementInvisible(WebDriver driver, String locator, String... params) {
        locator = getDynamiLocator(locator, params);

        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXPathLocator(locator)));

    }

    protected void waitForElementClickable(WebDriver driver, String locator) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.elementToBeClickable(getXPathLocator(locator)));

    }

    protected void waitForElementClickable(WebDriver driver, WebElement element) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.elementToBeClickable(element));

    }

    protected void waitForAllElementsInvisible(WebDriver driver, String locator) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locator)));
    }

    protected String getDynamiLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    protected void waitForElementClickable(WebDriver driver, String locator, String... params) {
        explicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
        explicit.until(ExpectedConditions.elementToBeClickable(getXPathLocator(getDynamiLocator(locator, params))));

    }

    protected void clickToElement(WebDriver driver, String locator, String... params) {
        waitForElementVisible(driver,locator,params);
        getWebElement(driver, getDynamiLocator(locator, params)).click();
    }
    protected boolean isDisplayInDom(String locator){
      return explicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).isDisplayed();

    }

}
