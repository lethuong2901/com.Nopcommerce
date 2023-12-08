package PageObject.User;

import PageUIs.User.ChangePasswordPageUIs;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPageObject extends BasePage {
    WebDriver driver;
    public ChangePasswordPageObject(WebDriver driver){
        this.driver=driver;
    }

    public void SendkeyToOldPasswordTextbox(String password) {
        waitForElementVisible(driver, ChangePasswordPageUIs.OLD_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUIs.OLD_PASSWORD_TEXTBOX,password);
    }

    public void SendkeyToNewPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, ChangePasswordPageUIs.NEW_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUIs.NEW_PASSWORD_TEXTBOX,newPassword);
    }

    public void SendkeyToConfirmPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, ChangePasswordPageUIs.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUIs.CONFIRM_PASSWORD_TEXTBOX,newPassword);
    }

    public void clickToChangePasswordButton() {
        waitForElementClickable(driver,ChangePasswordPageUIs.SAVE_BUTTON);
        clickToElement(driver,ChangePasswordPageUIs.SAVE_BUTTON);
    }

    public void clickToCloseUpdated() {
        waitForElementClickable(driver,ChangePasswordPageUIs.CLOSE_ICON);
        clickToElement(driver,ChangePasswordPageUIs.CLOSE_ICON);
        sleepInSecond(2);
    }
}
