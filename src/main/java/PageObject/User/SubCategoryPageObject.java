package PageObject.User;

import PageUIs.User.HomePageUIs;
import PageUIs.User.SubCategoryPageUIs;
import PageUIs.User.UserPageUIs;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubCategoryPageObject extends BasePage {
    private WebDriver driver;

    public SubCategoryPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public CustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUIs.MYACCOUNT_LINK);
        clickToElement(driver, HomePageUIs.MYACCOUNT_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }

    public boolean isMyAccountLinkDisplayed(WebDriver driver, String myAccount) {
        waitForElementVisible(driver, UserPageUIs.HEADER_LINK, myAccount);
        return isElementDisplay(driver, UserPageUIs.HEADER_LINK, myAccount);
    }

    public ProductDetailPageObject clickToProduct(WebDriver driver, String productName) {
        waitForElementClickable(driver, HomePageUIs.PRODUCT_NAME, productName);
        clickToElement(driver, HomePageUIs.PRODUCT_NAME, productName);
        return PageGenerator.getProductDetailPage(driver);
    }

    public void selectSortByDropdown(String item) {
        waitForElementVisible(driver, SubCategoryPageUIs.SORT_BY_DROPDOWN, item);
        selectItemInDefaultDropdown(driver, SubCategoryPageUIs.SORT_BY_DROPDOWN, item);
    }

    public boolean isProductNameSortbyAscending() {
        ArrayList<String> productListUI = new ArrayList<String>();
        List<WebElement> listProductNameText = getListWebElement(driver, SubCategoryPageUIs.PRODUCT_NAME);
        for (WebElement productName : listProductNameText) {
            productListUI.add(productName.getText());
        }
        ArrayList<String> productListSort = new ArrayList<String>();
        for (String product : productListUI) {
            productListSort.add(product);
        }
        Collections.sort(productListSort);
        return productListSort.equals(productListUI);
    }

    public boolean isProductNameSortbyDescending() {
        ArrayList<String> productListUI = new ArrayList<String>();
        List<WebElement> productNameText = getListWebElement(driver, SubCategoryPageUIs.PRODUCT_NAME);
        for (WebElement productName : productNameText) {
            productListUI.add(productName.getText());
        }
        ArrayList<String> productListSort = new ArrayList<String>();
        for (String product : productListUI) {
            productListSort.add(product);
        }
        Collections.sort(productListSort);
        ;
        Collections.reverse(productListSort);
        return productListSort.equals(productListUI);
    }


    public boolean isProductPriceSortbyAscending() {
        ArrayList<String> productListUI = new ArrayList<String>();
        List<WebElement> listProductNameText = getListWebElement(driver, SubCategoryPageUIs.PRODUCT_PRICE);
        for (WebElement productName : listProductNameText) {
            productListUI.add(productName.getText());
        }
        ArrayList<String> productListSort = new ArrayList<String>();
        for (String product : productListUI) {
            productListSort.add(product);
        }
        Collections.sort(productListSort);
        return productListSort.equals(productListUI);
    }

    public boolean isProductPriceSortbyDescending() {
        ArrayList<String> productListUI = new ArrayList<String>();
        List<WebElement> listProductNameText = getListWebElement(driver, SubCategoryPageUIs.PRODUCT_PRICE);
        for (WebElement productName : listProductNameText) {
            productListUI.add(productName.getText());
        }
        ArrayList<String> productListSort = new ArrayList<String>();
        for (String product : productListUI) {
            productListSort.add(product);
        }
        Collections.sort(productListSort);
        Collections.reverse(productListSort);
        return productListSort.equals(productListUI);
    }

    public void clickToPagingDropdown(String number) {
        waitForElementVisible(driver, SubCategoryPageUIs.PAGING_DROPDOWN);
        selectItemInDefaultDropdown(driver, SubCategoryPageUIs.PAGING_DROPDOWN, number);
    }

    public boolean isLessOrEqualThreePerPage(WebDriver driver, String pageSize) {
        int number3 = getElementSize(driver, SubCategoryPageUIs.PAGE_NUMBER, pageSize);
        sleepInSecond(2);
        int numberProductOfPerPage;
        boolean result = true;
        for (int i = 2; i <= number3 - 1; i++) {
            waitForElementClickable(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
            clickToElement(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
            numberProductOfPerPage = getElementSize(this.driver, SubCategoryPageUIs.PRODUCT_BOX_NUMBER);
            if (numberProductOfPerPage <= 3)
                result = true;
            else result = false;
        }
        return result;
    }

    public boolean isNexIconDisplayed(String pageSize) {
        int number = getElementSize(driver, SubCategoryPageUIs.PAGE_NUMBER, pageSize);
        sleepInSecond(2);
        System.out.print(number);
        boolean result = true;
        if (number >= 0) {
            for (int i = 1; i <= number - 2; i++) {
                waitForElementClickable(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
                clickToElement(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
                sleepInSecond(10);
                if (getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize).equals("3") && Integer.parseInt(getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize)) < 2) {
                    result = isElementDisplay(driver, SubCategoryPageUIs.NEXT_ICON, pageSize);
                }
            }
            return result;
        } else {
            System.out.print("Không xuất hiện paging");
        }
        return result;
    }

    public boolean isNexIconUnDisplayed(String pageSize) {
        int numberU = getElementSize(driver, SubCategoryPageUIs.PAGE_NUMBER, pageSize);
        sleepInSecond(10);
        System.out.print(numberU);
        boolean result = false;
        if (numberU >= 0) {
            for (int i = 1; i <= numberU - 2; i++) {
                waitForElementClickable(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i + 1));
                clickToElement(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i + 1));
                sleepInSecond(15);
                if (getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize).equals("3") && Integer.parseInt(getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize)) == 2 && isElementUndisplay(driver, SubCategoryPageUIs.NEXT_ICON, pageSize) == true) {
                    result = true;
                } else result = false;
                System.out.print(getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize));
                System.out.print(Integer.parseInt(getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize)));
                System.out.print(Integer.parseInt(getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize)));
            }
        } else {
            System.out.print("Không xuất hiện paging");
        }
        System.out.print(result);
        return result;
    }

    public boolean isPreviousIconDisplayed(String pageSize) {
        int number = getElementSize(driver, SubCategoryPageUIs.PAGE_NUMBER, pageSize);
        sleepInSecond(2);
        System.out.print(number);
        boolean result = true;
        if (number >= 0) {
            for (int i = 1; i <= number - 2; i++) {
                waitForElementClickable(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
                clickToElement(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
                sleepInSecond(10);
                if (getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize).equals("3") && Integer.parseInt(getElementText(driver, SubCategoryPageUIs.PAGE_CURRENT, pageSize)) == 2) {
                    result = isElementDisplay(driver, SubCategoryPageUIs.PREVIOUS_ICON, pageSize);
                }
            }
            return result;
        } else {
            System.out.print("Không xuất hiện paging");
        }
        return result;
    }

    public boolean isLessOrEqualSixPerPage(WebDriver driver, String pageSize) {
        int number6 = getElementSize(driver, SubCategoryPageUIs.PAGE_NUMBER, pageSize);
        sleepInSecond(2);
        int numberProductOfPerPage;
        boolean result = true;
        if (number6 > 0) {
            for (int i = 2; i <= number6 - 1; i++) {
                waitForElementClickable(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
                clickToElement(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
                numberProductOfPerPage = getElementSize(this.driver, SubCategoryPageUIs.PRODUCT_BOX_NUMBER);
                if (numberProductOfPerPage <= 6)
                    result = true;
                else result = false;
            }
        } else {
            numberProductOfPerPage = getElementSize(this.driver, SubCategoryPageUIs.PRODUCT_BOX_NUMBER);
            if (numberProductOfPerPage <= 6)
                result = true;
            else result = false;
            System.out.print("Không xuất hiện Paging");
        }
        return result;
    }

    public boolean isLessOrEqualNinePerPage(WebDriver driver, String pageSize) {
        int number9 = getElementSize(driver, SubCategoryPageUIs.PAGE_NUMBER, pageSize);
        sleepInSecond(2);
        int numberProductOfPerPage;
        boolean result = true;
        if (number9 > 0) {
            for (int i = 2; i <= number9 - 1; i++) {
                waitForElementClickable(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
                clickToElement(driver, SubCategoryPageUIs.NUMBER_OF_PAGE, pageSize, String.valueOf(i));
                numberProductOfPerPage = getElementSize(this.driver, SubCategoryPageUIs.PRODUCT_BOX_NUMBER);
                if (numberProductOfPerPage <= 6)
                    result = true;
                else result = false;
            }
        } else {
            numberProductOfPerPage = getElementSize(this.driver, SubCategoryPageUIs.PRODUCT_BOX_NUMBER);
            if (numberProductOfPerPage <= 9)
                result = true;
            else result = false;
            System.out.print("Không xuất hiện Paging");
        }
        return result;
    }
}


