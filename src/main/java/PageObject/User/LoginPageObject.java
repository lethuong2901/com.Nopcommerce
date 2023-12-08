package PageObject.User;

import PageUIs.User.LoginPageUIs;
import PageUIs.User.UserPageUIs;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUIs.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUIs.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }

    public String getErrorEmailMessage() {
        waitForElementVisible(driver,LoginPageUIs.USERNAME_EMPTY_ERROR_MESSAGE);
        return getElementText(driver,LoginPageUIs.USERNAME_EMPTY_ERROR_MESSAGE);
    }

    public void senKeyToEmailTextbox(String invalidEmail) {
        waitForElementVisible(driver,LoginPageUIs.USERNAME_TEXTBOX);
        sendkeyToElement(driver,LoginPageUIs.USERNAME_TEXTBOX,invalidEmail);
    }

    public void senKeyToPassword(String password) {
        waitForElementVisible(driver,LoginPageUIs.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginPageUIs.PASSWORD_TEXTBOX,password);
    }

    public String getErrorWrongEmailMessage() {
        waitForElementVisible(driver,LoginPageUIs.USERNAME_WRONG_EMAIL_MESSAGE);
        return getElementText(driver,LoginPageUIs.USERNAME_WRONG_EMAIL_MESSAGE);
    }

    public String getUnSuccessfulMessage() {
        waitForElementVisible(driver,LoginPageUIs.UNSUCCESSFUL_MESSAGE);
        return getElementText(driver,LoginPageUIs.UNSUCCESSFUL_MESSAGE);
    }

    public boolean IsMyAccountLinkIsDisplayed(String myAccount) {
        waitForElementVisible(driver, UserPageUIs.HEADER_LINK,myAccount);
        return isElementDisplay(driver, UserPageUIs.HEADER_LINK,myAccount);
    }
}
