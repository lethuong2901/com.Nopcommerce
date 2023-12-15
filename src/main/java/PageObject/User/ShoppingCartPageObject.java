package PageObject.User;

import PageUIs.User.AddressPageUIs;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCountryDropdown(String country) {
        waitForAllElementVisible(driver, AddressPageUIs.COUNTRY_DROPDOWN);
        selectItemInDefaultDropdown(driver, AddressPageUIs.COUNTRY_DROPDOWN, country);
    }

    public void selectStateDropdown(String state) {
        waitForAllElementVisible(driver, AddressPageUIs.STATE_DROPDOWN);
        selectItemInDefaultDropdown(driver, AddressPageUIs.STATE_DROPDOWN, state);
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver, AddressPageUIs.ADDNEW_BUTTON);
        clickToElement(driver, AddressPageUIs.ADDNEW_BUTTON);
    }

    public boolean isNewFirstNameDisplayed(String newFirstName) {
        waitForElementVisible(driver, AddressPageUIs.FIRSTNAME_TEXTBOX);
        return getValue(driver, AddressPageUIs.FIRSTNAME_TEXTBOX).equals(newFirstName);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, AddressPageUIs.SAVE_BUTTON);
        clickToElement(driver, AddressPageUIs.SAVE_BUTTON);
    }


    public boolean isEmailUpdated(String newEmail) {
        waitForElementVisible(driver, AddressPageUIs.EMAIL);
        return getElementText(driver,AddressPageUIs.EMAIL).contains(newEmail);
    }

    public boolean isPhoneUpaded(String phone) {
        waitForElementVisible(driver, AddressPageUIs.PHONE);
        return getElementText(driver,AddressPageUIs.PHONE).contains(phone);
    }

    public boolean isFaxUpdated(String fax) {
        waitForElementVisible(driver, AddressPageUIs.FAX);
        return getElementText(driver,AddressPageUIs.FAX).contains(fax);
    }
}
