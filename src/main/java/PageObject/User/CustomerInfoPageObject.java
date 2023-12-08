package PageObject.User;

import PageUIs.User.CustomerInforPageUIs;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CustomerInfoPageObject extends BasePage {
    WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isCustomerInforDisplayed() {
        waitForAllElementVisible(driver, CustomerInforPageUIs.CUSTOMERINFO_LINK);
       return isElementDisplay(driver, CustomerInforPageUIs.CUSTOMERINFO_LINK);
    }


    public void clickToGender(String male) {
        waitForElementClickable(driver,CustomerInforPageUIs.GENDER_CHECKBOX,male);
        checkToDefautCheckboxRadio(driver,CustomerInforPageUIs.GENDER_CHECKBOX, male);
    }

    public void clickToAddressLink() {
        waitForElementVisible(driver,CustomerInforPageUIs.ADDRESS_LINK);
        clickToElement(driver,CustomerInforPageUIs.ADDRESS_LINK);
    }

    public void clickToCustomerLink() {
        waitForElementVisible(driver,CustomerInforPageUIs.CUSTOMERINFO_LINK);
        clickToElement(driver,CustomerInforPageUIs.CUSTOMERINFO_LINK);
    }


    public void sendKeyToCompanyTextBox(String companyName) {
        waitForElementVisible(driver,CustomerInforPageUIs.COMPANY_TEXTBOX);
        sendkeyToElement(driver,CustomerInforPageUIs.COMPANY_TEXTBOX,companyName);
    }

    public void updateFirstName(String newFirstName) {
        waitForElementVisible(driver,CustomerInforPageUIs.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver,CustomerInforPageUIs.FIRSTNAME_TEXTBOX,newFirstName);
    }

    public void updateDateOfBirth(String date) {
        waitForElementClickable(driver, CustomerInforPageUIs.DATE0FBIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, CustomerInforPageUIs.DATE0FBIRTH_DROPDOWN, date);
    }

    public void updateLastName(String newLastName) {
        waitForElementVisible(driver,CustomerInforPageUIs.LASTNAME_TEXTBOX);
        sendkeyToElement(driver,CustomerInforPageUIs.LASTNAME_TEXTBOX,newLastName);
    }

    public void updateMonthOfBirth(String monthOfBirth) {
        waitForElementClickable(driver, CustomerInforPageUIs.MONTHOFBIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, CustomerInforPageUIs.MONTHOFBIRTH_DROPDOWN, monthOfBirth);
    }

    public void updateYearOfBirth(String yearOfBirth) {
        waitForElementClickable(driver, CustomerInforPageUIs.YEAROFBIRTH_DROPDOWN);
        selectItemInDefaultDropdown(driver, CustomerInforPageUIs.YEAROFBIRTH_DROPDOWN, yearOfBirth);
    }

    public void updateEmail(String newEmail) {
        waitForElementVisible(driver,CustomerInforPageUIs.EMAIL_TEXTBOX);
        sendkeyToElement(driver,CustomerInforPageUIs.EMAIL_TEXTBOX, newEmail);
    }

    public boolean IsFirstNameUpdateDisplayed(String newFirstName, String value) {
        waitForElementVisible(driver,CustomerInforPageUIs.FIRSTNAME_TEXTBOX);
        return getElementAtrribute(driver,CustomerInforPageUIs.FIRSTNAME_TEXTBOX,value).equals(newFirstName);
    }

    public boolean IsLastNameUpdateDisplayed(String newLastName, String value) {
        waitForElementVisible(driver,CustomerInforPageUIs.LASTNAME_TEXTBOX);
        return getElementAtrribute(driver,CustomerInforPageUIs.LASTNAME_TEXTBOX,value).equals(newLastName);
    }

    public boolean IsDateOfBirthUpdateDisplayed(String dateOfBirth, String value) {
        waitForElementVisible(driver,CustomerInforPageUIs.DATE0FBIRTH_DROPDOWN);
        return getElementAtrribute(driver,CustomerInforPageUIs.DATE0FBIRTH_DROPDOWN,value).equals(dateOfBirth);
    }

    public boolean IsMonthOfBirthUpdateDisplayed(String monthOfBirth, String value) {
        waitForElementVisible(driver,CustomerInforPageUIs.MONTHOFBIRTH_DROPDOWN);
        return getElementAtrribute(driver,CustomerInforPageUIs.MONTHOFBIRTH_DROPDOWN,value).equals(monthOfBirth);
    }

    public boolean IsYearUpdateDisplayed(String newYearOfBirth, String value) {
        waitForElementVisible(driver,CustomerInforPageUIs.YEAROFBIRTH_DROPDOWN);
        return getElementAtrribute(driver,CustomerInforPageUIs.YEAROFBIRTH_DROPDOWN,value).equals(newYearOfBirth);
    }

    public boolean IsEmailUpdateDisplayed(String newEmail, String value) {
        waitForElementVisible(driver,CustomerInforPageUIs.EMAIL_TEXTBOX);
        return getElementAtrribute(driver,CustomerInforPageUIs.EMAIL_TEXTBOX,value).equals(newEmail);
    }

    public boolean IsCompanyNameUpdateDisplayed(String companyName, String value) {
        waitForElementVisible(driver,CustomerInforPageUIs.COMPANY_TEXTBOX);
        return getElementAtrribute(driver,CustomerInforPageUIs.COMPANY_TEXTBOX,value).equals(companyName);
    }

    public boolean IsGenderChecked(String male) {
        waitForElementVisible(driver,CustomerInforPageUIs.GENDER_CHECKBOX,male);
       return isElementSelected(driver,CustomerInforPageUIs.GENDER_CHECKBOX,male);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver,CustomerInforPageUIs.SAVE_BUTTON);
        clickToElement(driver,CustomerInforPageUIs.SAVE_BUTTON);
    }
}
