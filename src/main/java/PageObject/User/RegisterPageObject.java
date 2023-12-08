package PageObject.User;

import PageUIs.User.RegisterPageUIs;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {
 
    WebDriver driver;
    public RegisterPageObject (WebDriver driver){
        this.driver=driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUIs.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUIs.REGISTER_BUTTON);
    }


    public String getErrorFirstnameMessage() {
       return getElementText(driver, RegisterPageUIs.FIRSTNAME_ERROR_MESSAGE);
    }

    public String getErrorLastnameMessage() {
        return getElementText(driver, RegisterPageUIs.LASTNAME_ERROR_MESSAGE);
    }

    public String getErrorEmailMessage() {
        return getElementText(driver, RegisterPageUIs.EMAIL_ERROR_MESSAGE);
    }

    public String getErrorPasswordMessage() {
        return getElementText(driver, RegisterPageUIs.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorConfirmPasswordMessage() {
        return getElementText(driver, RegisterPageUIs.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void reload() {
        refreshCurrentPage(driver);
    }

    public void senkeyToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver,RegisterPageUIs.FIRSTNAME_TEXTBOX,firstName);
        sendkeyToElement(driver,RegisterPageUIs.FIRSTNAME_TEXTBOX,firstName);
    }

    public void senkeyToLastNameTextbox(String lastname) {
        waitForElementVisible(driver,RegisterPageUIs.LASTNAME_TEXTBOX,lastname);
        sendkeyToElement(driver,RegisterPageUIs.LASTNAME_TEXTBOX,lastname);
    }

    public void senkeyToEmailTextbox(String email) {
        waitForElementVisible(driver,RegisterPageUIs.EMAIL_TEXTBOX,email);
        sendkeyToElement(driver,RegisterPageUIs.EMAIL_TEXTBOX,email);
    }

    public void senkeyToPasswordTextbox(String password) {
        waitForElementVisible(driver,RegisterPageUIs.PASSWORD_TEXTBOX,password);
        sendkeyToElement(driver,RegisterPageUIs.PASSWORD_TEXTBOX,password);
    }

    public void senkeyToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver,RegisterPageUIs.CONFIRMPASSWORD_TEXTBOX,confirmPassword);
        sendkeyToElement(driver,RegisterPageUIs.CONFIRMPASSWORD_TEXTBOX,confirmPassword);
    }

    public String getErrorWrongEmailMessage() {
        waitForElementVisible(driver,RegisterPageUIs.WRONG_EMAIL_MESASGE);
        return getElementText(driver,RegisterPageUIs.WRONG_EMAIL_MESASGE);
    }

    public String getSuccessRegisterMessage() {
        waitForElementVisible(driver,RegisterPageUIs.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver,RegisterPageUIs.REGISTER_SUCCESS_MESSAGE);
    }

    public String getErrorExistedEmaiMessage() {
        waitForElementVisible(driver,RegisterPageUIs.EXISTED_EMAIL_MESSSAGE);
        return getElementText(driver,RegisterPageUIs.EXISTED_EMAIL_MESSSAGE);
    }

    public String getErrorRulePasswordMessage() {
        waitForAllElementVisible(driver,RegisterPageUIs.RULE_PASSWORD_MESSAGE);
        return getElementText(driver,RegisterPageUIs.RULE_PASSWORD_MESSAGE);
    }

    public String getNotMatchPasswordMessage() {
        waitForAllElementVisible(driver,RegisterPageUIs.NOT_MATCH_PASSWORD_MESSAGE);
        return getElementText(driver,RegisterPageUIs.NOT_MATCH_PASSWORD_MESSAGE);
    }
}
