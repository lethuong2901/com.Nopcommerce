package PageUIs.User;

public class SubCategoryPageUIs {
    public static final String SORT_BY_DROPDOWN = "xpath=//select[@id='products-orderby']";
    public static final String PRODUCT_NAME = "xpath=//div[@class='product-grid']//h2[@class='product-title']//a";

    public static final String PRODUCT_PRICE ="xpath=//div[@class='product-grid']//h2[@class='product-title']//following-sibling::div[@class='add-info']//div[@class='prices']//span" ;
    public static final String PAGING_DROPDOWN ="xpath=//select[@id='products-pagesize']" ;
    public static final String PAGE_NUMBER = "xpath=//select[@id='products-pagesize']//option[text()='%s']//ancestor::div[@class='product-selectors']//following-sibling::div[@class='products-container']//div[@class='pager']//li";
    public static final String NUMBER_OF_PAGE = "xpath= //select[@id='products-pagesize']//option[text()='%s']//ancestor::div[@class='product-selectors']//following-sibling::div[@class='products-container']//div[@class='pager']//li[@class='individual-page']//a[text()='%s']";
    public static final String PRODUCT_BOX_NUMBER = "xpath=//div[@class='item-grid']//div[@class='item-box']";
    public static final String PAGE_CURRENT = "xpath=//select[@id='products-pagesize']//option[text()='3']//ancestor::div[@class='product-selectors']//following-sibling::div[@class='products-container']//div[@class='pager']//li[@class='current-page']//span";
    public static final String NEXT_ICON = "xpath=//select[@id='products-pagesize']//option[text()='%s']//ancestor::div[@class='product-selectors']//following-sibling::div[@class='products-container']//div[@class='pager']//li[@class='next-page']/a";
    public static final String PREVIOUS_ICON ="xpath=//select[@id='products-pagesize']//option[text()='%s']//ancestor::div[@class='product-selectors']//following-sibling::div[@class='products-container']//div[@class='pager']//li[@class='previous-page']/a[text()='Previous']" ;

}
