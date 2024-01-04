package PageObject.Admin;

import PageObject.User.HomePageObject;
import PageUIs.Admin.LoginPageUIs;
import PageUIs.User.UserPageUIs;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void senKeyToUsernameTextbox(String username) {
        waitForElementVisible(driver, LoginPageUIs.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUIs.USERNAME_TEXTBOX,username);
    }

    public void sendKeyToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUIs.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUIs.PASSWORD_TEXTBOX,password);
    }

    public DashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUIs.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUIs.LOGIN_BUTTON);
        return PageGenerator.getDashboardPage(driver);
    }
}
