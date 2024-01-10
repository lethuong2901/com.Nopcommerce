package PageUIs.User;

public class HomePageUIs {
    public static final String MYACCOUNT_LINK = "xpath=//a[@class='ico-account']";
    public static final String PRODUCT_NAME ="xpath=//a[text()='%s']" ;
    public static final String SUBCATEGORY_NAME = "xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[text()='%s ']//following-sibling::ul[@class='sublist first-level']//a[text()='%s ']";
    public static final String CATEGORY_NAME = "xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[text()='%s ']";
    public static final String ADD_TO_CART_LINK ="xpath=//h2[@class='product-title']//a[text()='%s']//ancestor::div[@class='details']//div[@class='add-info']//button[text()='Add to cart']" ;

}
