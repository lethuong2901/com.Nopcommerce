package PageObject.User;

import PageUIs.User.HomePageUIs;
import PageUIs.User.UserPageUIs;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public CustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUIs.MYACCOUNT_LINK);
        clickToElement(driver, HomePageUIs.MYACCOUNT_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }

    public boolean isMyAccountLinkDisplayed(WebDriver driver, String myAccount) {
        waitForElementVisible(driver, UserPageUIs.HEADER_LINK,myAccount);
        return isElementDisplay(driver, UserPageUIs.HEADER_LINK,myAccount);
    }

    public ProductDetailPageObject clickToProduct(WebDriver driver, String productName) {
        waitForElementClickable(driver,HomePageUIs.PRODUCT_NAME,productName);
        clickToElement(driver,HomePageUIs.PRODUCT_NAME,productName);
        return PageGenerator.getProductDetailPage(driver);
    }


    public void clickToSubCategory(String category, String subcategory) {
        waitForElementVisible(driver,HomePageUIs.CATEGORY_NAME,category);
        hoverMouse(driver,HomePageUIs.CATEGORY_NAME,category);
        clickToElement(driver,HomePageUIs.SUBCATEGORY_NAME,category,subcategory);
    }

    public ProductDetailPageObject clickToAddToCart(WebDriver driver, String productName) {
        waitForElementClickable(driver,HomePageUIs.ADD_TO_CART_LINK,productName);
        clickToElement(driver,HomePageUIs.ADD_TO_CART_LINK,productName);
        return PageGenerator.getProductDetailPage(driver);
    }

}
