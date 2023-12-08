package PageObject.User;

import PageUIs.User.ProductReviewPageUIs;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ProductReviewPageObject extends BasePage {
    private WebDriver driver;

    public ProductReviewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendkeyToTitleReview(String titleReview) {
        waitForElementVisible(driver, ProductReviewPageUIs.TITLE_REVIEW_TEXTBOX);
        sendkeyToElement(driver, ProductReviewPageUIs.TITLE_REVIEW_TEXTBOX,titleReview);
    }

    public void sendkeyToContentReview(String contentReview) {
        waitForElementVisible(driver, ProductReviewPageUIs.CONTENT_REVIEW_TEXTBOX);
        sendkeyToElement(driver, ProductReviewPageUIs.CONTENT_REVIEW_TEXTBOX,contentReview);
    }

    public void clickToRating(String rating) {
        waitForElementVisible(driver, ProductReviewPageUIs.RATING,rating);
        clickToElement(driver, ProductReviewPageUIs.RATING,rating);
    }

    public void clickToSubmitButton() {
        waitForElementVisible(driver, ProductReviewPageUIs.SUBMIT_BUTTON);
        clickToElement(driver, ProductReviewPageUIs.SUBMIT_BUTTON);
    }

    public boolean isReviewAdded() {
        waitForElementVisible(driver,ProductReviewPageUIs.RESULTS);
        return getElementText(driver,ProductReviewPageUIs.RESULTS).contains("Product review is successfully added.");
    }
}
