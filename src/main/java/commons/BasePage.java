package commons;

import PageUIs.User.UserPageUIs;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void backForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void setCookie(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
            //  sleepInSecond(3);
        }
    }

    public Set<Cookie> getCookie(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public void dimissAlert(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }


    public String getTextlAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void senKeyToAlert(WebDriver driver, String textvalue) {
        waitForAlertPresence(driver).sendKeys(textvalue);
    }

    public void switchToWindowByID(WebDriver driver, String WindowID) {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            if (!id.equals(WindowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (!actualTitle.equals(tabTitle)) {
                driver.switchTo().window(actualTitle);
                break;
            }
        }
    }

    public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("css=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=")) {
            by = By.xpath(locatorType.substring(6));
        } else if (locatorType.startsWith("classname=")) {
            by = By.className(locatorType.substring(10));
        } else if (locatorType.startsWith("name=")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("tagname=")) {
            by = By.tagName(locatorType.substring(8));
        }

        return by;
    }

    public String getDynamicXpath(String locatorType, String... dynamicValue) {
        if (locatorType.startsWith("xpath=")) {
            locatorType = String.format(locatorType, (Object[]) dynamicValue);
        }
        return locatorType;
    }

    public WebElement getWebElement(WebDriver driver, String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locatorType, String... dynamicValue) {
        return driver.findElements(getByLocator(getDynamicXpath(locatorType,dynamicValue)));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    public void clickToElement(WebDriver driver, String locatorType) {
        getWebElement(driver, locatorType).click();
    }

    public void clickToElement(WebDriver driver, String locatorType, String... dynamicValue) {
        getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).click();
    }

    public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValue) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
        element.clear();
        element.sendKeys(textValue);
    }

    public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
        WebElement element = getWebElement(driver, locatorType);
        element.clear();
        element.sendKeys(textValue);
    }

    public String getElementText(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).getText();
    }

    public String getElementText(WebDriver driver, String locatorType, String... dynamicValue) {
        return getWebElement(driver, getDynamicXpath(locatorType,dynamicValue)).getText();
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
        Select select = new Select(getWebElement(driver, locatorType));
        select.selectByVisibleText(textItem);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem,
                                            String... dynamicValue) {
        Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
        select.selectByVisibleText(textItem);
    }

    public String getFirstSelectItemInDefaultDropdown(WebDriver driver, String locatorType) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.getFirstSelectedOption().getText();
    }

    public String getFirstSelectItemInDefaultDropdown(WebDriver driver, String locatorType, String... dynamicValue) {
        Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultile(WebDriver driver, String locatorType) {
        Select select = new Select(getWebElement(driver, locatorType));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath,
                                           String expectedTextItem) {
        getWebElement(driver, parentXpath).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        List<WebElement> allItems = explicitWait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedTextItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("agruments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    public String getElementAtrribute(WebDriver driver, String locatorType, String atributeName,
                                      String... dynamicValue) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).getAttribute(atributeName);
    }

    public String getElementAtrribute(WebDriver driver, String locatorType, String atributeName) {
        return getWebElement(driver, locatorType).getAttribute(atributeName);
    }

    public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
        return getWebElement(driver, locatorType).getCssValue(propertyName);
    }

    public String covertRgbaToHex(String rgbhValue) {
        return Color.fromString(rgbhValue).asHex();
    }

    public int getElementSize(WebDriver driver, String locatorType) {
        return getListWebElement(driver, locatorType).size();
    }

    public int getElementSize(WebDriver driver, String locatorType, String... dynamicValue) {
        return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).size();
    }

    public void checkToDefautCheckboxRadio(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToDefautCheckboxRadio(WebDriver driver, String locatorType, String... dynamicValue) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void unCheckToDefautCheckbox(WebDriver driver, String locatorType) {
        WebElement element = getWebElement(driver, locatorType);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void unCheckToDefautCheckbox(WebDriver driver, String locatorType, String... dynamicValue) {
        WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplay(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isDisplayed();
    }

    public boolean isElementDisplay(WebDriver driver, String locatorType, String... dynamicValue) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).isDisplayed();
    }

    public void waitToElementInvisible(WebDriver driver, String locatorType) {
        WebDriverWait waitExplicit = new WebDriverWait(driver, longTime);
        overrideGlobalTimeOut(driver, 5);
        waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
        overrideGlobalTimeOut(driver, 30);
    }

    public boolean isElementUndisplay(WebDriver driver, String locatorType) {
        overrideGlobalTimeOut(driver, 5);
        List<WebElement> elements = getListWebElement(driver, locatorType);
        overrideGlobalTimeOut(driver, 30);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementUndisplay(WebDriver driver, String locatorType, String... dynamicValue) {
        overrideGlobalTimeOut(driver, 5);
        List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
        overrideGlobalTimeOut(driver, 30);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void overrideGlobalTimeOut(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

    }

    public boolean isElementEnable(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isEnabled();
    }

    public boolean isElementEnable(WebDriver driver, String locatorType, String... dynamicValue) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locatorType) {
        return getWebElement(driver, locatorType).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locatorType, String... dynamicValue) {
        return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).isSelected();
    }

    public void switchToFrame(WebDriver driver, String locatorType) {
        driver.switchTo().frame(getWebElement(driver, locatorType));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouse(WebDriver driver, String locatorType) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locatorType)).perform();
    }

    public void hoverMouse(WebDriver driver, String locatorType, String... dynamicValue) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType,dynamicValue))).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(driver, locatorType), key).perform();
    }


    public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValue) {
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)), key).perform();
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, locatorType);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
    }

    public void scrollToElement(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
    }

    public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
                getWebElement(driver, locatorType));
    }

    public String getValue(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].value;", getWebElement(driver, locatorType));
    }

    public String getValue(WebDriver driver, String locatorType, String... dynamicValue) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].value;", getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
                getWebElement(driver, locatorType));
    }

    public boolean isImageLoaded(WebDriver driver, String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(driver, locatorType));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
    }

    public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions
                .visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
    }

    public void waitForAllElementVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
    }

    public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
    }

    public void waitForElementInVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
    }

    public void waitForElementInVisible(WebDriver driver, String locatorType, String... dynamicValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions
                .invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
    }

    public void waitForAllElementInVisible(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
    }

    public void waitForAllElementInVisible(WebDriver driver, String locatorType, String... dynamicValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions
                .invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValue))));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(
                ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
    }

    private long longTime = GlobalConstant.LONG_TIMEOUT;
    private long shortTime = GlobalConstant.SHORT_TIMEOUT;

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clickToHeaderLink(WebDriver driver, String headerLink) {
        waitForElementClickable(driver, UserPageUIs.HEADER_LINK, headerLink);
        clickToElement(driver, UserPageUIs.HEADER_LINK, headerLink);
    }

    public void clickToSideBarLink(WebDriver driver, String sidebarLink) {
        waitForElementClickable(driver, UserPageUIs.SIDEBAR_LINK, sidebarLink);
        clickToElement(driver, UserPageUIs.SIDEBAR_LINK, sidebarLink);
    }

    public void sendKeyToTextboxAtAddressPage(WebDriver driver, String fieldName, String fieldValue) {
        waitForElementVisible(driver, UserPageUIs.FIELD_NAME_TEXTBOX_AT_ADDRESS, fieldName);
        sendkeyToElement(driver, UserPageUIs.FIELD_NAME_TEXTBOX_AT_ADDRESS, fieldValue, fieldName);
    }

    public boolean isInformationDisplayed(WebDriver driver, String fieldName, String fieldValue) {
        waitForElementVisible(driver, UserPageUIs.FIELD_NAME_TEXTBOX_AT_ADDRESS, fieldName);
        return getValue(driver, UserPageUIs.FIELD_NAME_TEXTBOX_AT_ADDRESS,fieldName).equals(fieldValue);
    }

    public boolean isInformationUpdated(WebDriver driver, String fieldName, String fieldValue) {
        waitForElementVisible(driver,UserPageUIs.FIELD_NAME_TEXTBOX_AT_ADDRESS_UPDATED,fieldName);
        return getElementText(driver,UserPageUIs.FIELD_NAME_TEXTBOX_AT_ADDRESS_UPDATED,fieldName).equals(fieldValue);
    }

    public void clickToFooterLink(WebDriver driver,String footerLink) {
        waitForElementClickable(driver, UserPageUIs.FOOTER_LINK,footerLink);
        clickToElement(driver, UserPageUIs.FOOTER_LINK,footerLink);
    }

}
