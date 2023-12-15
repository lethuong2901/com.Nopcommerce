package commons;

import PageObject.User.*;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePageObject getUserHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver){
        return new CustomerInfoPageObject(driver);
    }
    public static AddressPageObject getAddressPage(WebDriver driver){
        return new AddressPageObject(driver);
    }

    public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
        return new ChangePasswordPageObject(driver);
    }
    public static MyProductReviewsPageObject getMyProductReviewPage(WebDriver driver) {
        return new MyProductReviewsPageObject(driver);
    }
    public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
        return new ProductDetailPageObject(driver);
    }
    public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
        return new ProductReviewPageObject(driver);
    }

    public static SearchPageObject getSearchPage(WebDriver driver) {
        return new SearchPageObject(driver);
    }

    public static CategoryPageObject getCategoryPage(WebDriver driver) {
        return new CategoryPageObject(driver);
    }
    public static SubCategoryPageObject getSubCategoryPage(WebDriver driver){
        return  new SubCategoryPageObject(driver);
    }
    public static WishlistPageObject getWishlistPage(WebDriver driver){
        return  new WishlistPageObject(driver);
    }
    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver){
        return new ShoppingCartPageObject(driver);
    }
}
