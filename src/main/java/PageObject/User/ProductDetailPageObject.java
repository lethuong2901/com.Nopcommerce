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
}
