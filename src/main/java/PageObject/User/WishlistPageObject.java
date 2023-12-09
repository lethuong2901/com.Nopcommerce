package PageObject.User;

import PageUIs.User.ProductDetailPageUIs;
import PageUIs.User.WishlistPageUIs;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;

public class WishlistPageObject extends BasePage {
    private WebDriver driver;

    public WishlistPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductDiplayed(WebDriver driver, String s, String productName) {
        int indexRow = getElementSize(driver, WishlistPageUIs.INDEXROW,s) + 1;
        waitForElementVisible(driver,WishlistPageUIs.PRODUCT_NAME,String.valueOf(indexRow));
        return getElementText(driver,WishlistPageUIs.PRODUCT_NAME,String.valueOf(indexRow)).equals(productName);
    }

    public void clickToUrlShareWishlist() {
        waitForElementClickable(driver,WishlistPageUIs.URL_SHARE);
        clickToElement(driver,WishlistPageUIs.URL_SHARE);
    }


    public boolean isWishlistTitleDisplayed(WebDriver driver, String fullname) {
        waitForElementVisible(driver,WishlistPageUIs.WISHLIST_TITLE);
        return getElementText(driver,WishlistPageUIs.WISHLIST_TITLE).contains(fullname);
    }

    public boolean isWishlistProductDisplayed(WebDriver driver, String s, String productName) {
        int indexRow = getElementSize(driver, WishlistPageUIs.INDEXROW,s) + 1;
        waitForElementVisible(driver,WishlistPageUIs.PRODUCT_NAME,String.valueOf(indexRow));
        return getElementText(driver,WishlistPageUIs.PRODUCT_NAME,String.valueOf(indexRow)).equals(productName);
    }
}
