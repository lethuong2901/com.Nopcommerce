package PageUIs.User;

public class MyProductReviewsPageUIs {
    public static final String TITLE_REVIEW = "xpath=//strong[text()='%s']";
    public static final String CONTENT_REVIEW = "xpath=//strong[text()='%s']//ancestor::div[@class='review-item-head']//following-sibling::div[@class='review-content']//div[text()='%s']";
    public static final String RATINGS = "xpath=//strong[text()='Review for productss']//ancestor::div[@class='review-title']//following-sibling::div[@class='product-review-box']//div[@style='width:60%']";
    public static final String RATING = "xpath=//strong[text()='%s']//ancestor::div[@class='review-title']//following-sibling::div[@class='product-review-box']//div[@class='rating']//div";
    public static final String DATE = "xpath=//strong[text()='%s']//ancestor::div[@class='review-item-head']//following-sibling::div[@class='review-content']//span[@class='date']//span";
}
