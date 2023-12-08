package PageObject.User;

import PageUIs.User.SearchPageUIs;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageObject extends BasePage {
    private WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToSearchButton() {
        waitForElementClickable(driver, SearchPageUIs.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUIs.SEARCH_BUTTON);
    }

    public String getWaringEmptyDataMessage() {
        waitForElementVisible(driver,SearchPageUIs.WARNING_MESSAGE);
        return  getElementText(driver,SearchPageUIs.WARNING_MESSAGE);
    }

    public void sendkeyToSearchTextbox(String searchValue1) {
        waitForElementVisible(driver,SearchPageUIs.SEARCH_TEXTBOX);
        sendkeyToElement(driver, SearchPageUIs.SEARCH_TEXTBOX, searchValue1);
    }

    public String getNoProductFoundMessage() {
        waitForElementVisible(driver,SearchPageUIs.NO_FOUND_MESSAGE);
        return getElementText(driver,SearchPageUIs.NO_FOUND_MESSAGE);
    }

    public boolean isListProductDisplayed(String searchValue2) {
        waitForElementVisible(driver,SearchPageUIs.RESULT_SEARCH,searchValue2);
        boolean a=true;
        List<WebElement> resultSearch= getListWebElement(driver,SearchPageUIs.RESULT_SEARCH,searchValue2);
        for(WebElement result:resultSearch) {
            if(result.getText().contains(searchValue2))
               a=true;
            else a=false;
        }
        return a;
    }

    public int resultNumberOfProduct(String searchValue2) {
        waitForElementVisible(driver,SearchPageUIs.RESULT_SEARCH,searchValue2);
        List<WebElement> resultSearch= getListWebElement(driver,SearchPageUIs.RESULT_SEARCH,searchValue2);
        return  resultSearch.size();
    }

    public String isProductDisplayed() {
        waitForElementVisible(driver,SearchPageUIs.RESULT_SEARCH_PRODUCT);
        return getElementText(driver,SearchPageUIs.RESULT_SEARCH_PRODUCT);
    }

    public void clickToSearchAdvanceCheckbox() {
        waitForElementClickable(driver,SearchPageUIs.ADVANCE_SEARCH_CHECKBOX);
        checkToDefautCheckboxRadio(driver,SearchPageUIs.ADVANCE_SEARCH_CHECKBOX);
    }

    public void selectCategoryParent(String category) {
        waitForElementVisible(driver,SearchPageUIs.CATEGORY_DROPDOWN);
        selectItemInDefaultDropdown(driver,SearchPageUIs.CATEGORY_DROPDOWN,category);
    }

    public String getMessageNoResult() {
        waitForElementVisible(driver, SearchPageUIs.NO_FOUND_MESSAGE);
        return getElementText(driver, SearchPageUIs.NO_FOUND_MESSAGE);
    }

    public void clickToSubCategoriesCheckbox() {
        waitForElementClickable(driver,SearchPageUIs.SUBCATEGORY_CHECKBOX);
        checkToDefautCheckboxRadio(driver,SearchPageUIs.SUBCATEGORY_CHECKBOX);
    }

    public void selectManufacturer(String manufacturer) {
        waitForElementVisible(driver,SearchPageUIs.MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropdown(driver,SearchPageUIs.MANUFACTURER_DROPDOWN,manufacturer);
    }
}
