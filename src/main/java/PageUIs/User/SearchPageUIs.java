package PageUIs.User;

public class SearchPageUIs {

    public static final String SEARCH_BUTTON = "xpath=//div[@class='search-input']//button[text()='Search']";
    public static final String WARNING_MESSAGE = "xpath=//div[@class='warning']" ;
    public static final String SEARCH_TEXTBOX ="xpath=//input[@class='search-text']" ;
    public static final String NO_FOUND_MESSAGE ="xpath=//div[@class='no-result']" ;
    public static final String RESULT_SEARCH ="xpath=//div[@class='item-grid']//h2[@class='product-title']//a[contains(text(),'%s')]" ;
    public static final String RESULT_SEARCH_PRODUCT ="xpath=//div[@class='item-grid']//h2[@class='product-title']//a" ;
    public static final String ADVANCE_SEARCH_CHECKBOX ="xpath=//input[@id='advs']";
    public static final String CATEGORY_DROPDOWN = "xpath=//select[@id='cid']";
    public static final String SUBCATEGORY_CHECKBOX="xpath=//input[@id='isc']";
    public static final String MANUFACTURER_DROPDOWN ="xpath=//select[@id='mid']" ;
}
