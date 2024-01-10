package PageObject.User;

import PageUIs.User.ProductDetailPageUIs;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;

public class ProductDetailPageObject extends BasePage {
    private WebDriver driver;

    public ProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public ProductReviewPageObject clickToAddReviewLink() {
        waitForElementClickable(driver, ProductDetailPageUIs.ADD_REVIEW_LINK);
        clickToElement(driver, ProductDetailPageUIs.ADD_REVIEW_LINK);
        return PageGenerator.getProductReviewPage(driver);
    }
    public void clickToAddWishlistLink() {
        waitForElementClickable(driver,ProductDetailPageUIs.ADD_WISHLIST_BUTTON);
        clickToElement(driver,ProductDetailPageUIs.ADD_WISHLIST_BUTTON);
    }

    public String getMessageProductIsAddWishlistDisplayed() {
        waitForElementVisible(driver,ProductDetailPageUIs.SUCCESSFUL_MESSAGE);
        return getElementText(driver,ProductDetailPageUIs.SUCCESSFUL_MESSAGE);
    }

    public void closeToMessage() {
        waitForElementClickable(driver,ProductDetailPageUIs.CLOSE_MESAGSAE_ICON);
        clickToElement(driver,ProductDetailPageUIs.CLOSE_MESAGSAE_ICON);
    }

    public void selectProcessor(String processor) {
        waitForElementVisible(driver,ProductDetailPageUIs.PROCESSOR_DROPDOWN);
        selectItemInDefaultDropdown(driver,ProductDetailPageUIs.PROCESSOR_DROPDOWN,processor);
    }

    public void selectRam(String ram) {
        waitForElementVisible(driver,ProductDetailPageUIs.RAM_DROPDOWN);
        selectItemInDefaultDropdown(driver,ProductDetailPageUIs.RAM_DROPDOWN,ram);
    }

    public void selectHDD(String hdd) {
        waitForElementClickable(driver,ProductDetailPageUIs.HDD_CHECKBOX,hdd);
        checkToDefautCheckboxRadio(driver,ProductDetailPageUIs.HDD_CHECKBOX,hdd);
    }

    public void clickToAddToCart() {
        waitForElementClickable(driver,ProductDetailPageUIs.ADDTOCART_BUTTON);
        clickToElement(driver,ProductDetailPageUIs.ADDTOCART_BUTTON);
    }

    public String getAddToCartSuccessfulMessage() {
        waitForElementVisible(driver,ProductDetailPageUIs.ADDTOCART_MESAGE);
        return getElementText(driver,ProductDetailPageUIs.ADDTOCART_MESAGE);
    }
}
