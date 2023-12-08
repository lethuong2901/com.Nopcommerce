package PageObject.User;

import PageUIs.User.MyProductReviewsPageUIs;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyProductReviewsPageObject extends BasePage {
    WebDriver driver;
    public MyProductReviewsPageObject(WebDriver driver){
        this.driver=driver;
    }

    public boolean isTitleReviewDisplayed(String titleReview) {
        waitForElementVisible(driver, MyProductReviewsPageUIs.TITLE_REVIEW,titleReview);
        return getElementText(driver,MyProductReviewsPageUIs.TITLE_REVIEW,titleReview).equals(titleReview);
    }

    public boolean isRatingDisplayed(String titleReview, String ratingStyle) {
        waitForElementVisible(driver, MyProductReviewsPageUIs.RATING,titleReview);
          return getElementAtrribute(driver,MyProductReviewsPageUIs.RATING,"style",titleReview).contains(ratingStyle);
    }

    public boolean isReviewContentDisplayed(WebDriver driver, String titleReview, String contentReview) {
        waitForElementVisible(driver, MyProductReviewsPageUIs.CONTENT_REVIEW,titleReview,contentReview);
        return getElementText(driver,MyProductReviewsPageUIs.CONTENT_REVIEW,titleReview,contentReview).equals(contentReview);
    }


    public boolean isDateDisplayed(String title, String currentDay) {
        waitForElementVisible(driver, MyProductReviewsPageUIs.DATE,title);
        return getElementText(driver, MyProductReviewsPageUIs.DATE,title).contains(currentDay);

    }
}
