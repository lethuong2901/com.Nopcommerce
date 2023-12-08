package Nopcommerce.User;

import PageObject.User.HomePageObject;
import PageObject.User.LoginPageObject;
import PageObject.User.SearchPageObject;
import commons.BaseTest;
import commons.PageGenerator;
import commons.Utilities.User_Data_Mapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserSearch extends BaseTest {
    WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private SearchPageObject searchPage;
    private User_Data_Mapper userDataMapper;
    String email, password;
    String searchValue1, searchValue2, searchValue3, searchValue4, category;


    @Parameters({"browserName", "url"})
    @BeforeClass
    public void Beforeclass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getUserHomePage(driver);
        userDataMapper = User_Data_Mapper.getUseData();
        email = userDataMapper.getEmail();
        password = userDataMapper.getPassword();
        searchValue1 = "Product not exist";
        searchValue2 = "Lenovo";
        searchValue3 = "Lenovo Thinkpad X1 Carbon Laptop";
        searchValue4= "Apple MacBook Pro 13-inch";
        category="Computers";
        homePage.clickToHeaderLink(driver, "Log in");
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.senKeyToEmailTextbox(email);
        loginPage.senKeyToPassword(password);
        loginPage.clickToLoginButton();
        loginPage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getSearchPage(driver);
    }

    @Test
    public void TC_01_Search_Empty_Data() {
        log.info("Search: Empty data - Step 01: Click to 'search' button");
        searchPage.clickToSearchButton();

        log.info("Search: Empty data - Step 02: Verify waring message");
        Assert.assertEquals(searchPage.getWaringEmptyDataMessage(), "Search term minimum length is 3 characters");
    }

    @Test
    public void TC_02_Search_Data_Not_Exist() {
        log.info("Search: Data not exist - Step 01: Input to 'search' textbox with value not exist is'" + searchValue1 + "'");
        searchPage.sendkeyToSearchTextbox(searchValue1);

        log.info("Search: Data not exist - Step 02: Click to 'search' button");
        searchPage.clickToSearchButton();

        log.info("Search: Empty data - Step 03: Verify warning message");
        Assert.assertEquals(searchPage.getNoProductFoundMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void TC_03_Search_Relative_Product_name() {
        log.info("Search: Relative product name - Step 01: Input to 'search' textbox with relative product name is'" + searchValue2 + "'");
        searchPage.sendkeyToSearchTextbox(searchValue2);

        log.info("Search: Relative product name - Step 02: Click to 'search' button");
        searchPage.clickToSearchButton();

        log.info("Search: Relative product name - Step 03: Verify list product is displayed");
        Assert.assertTrue(searchPage.isListProductDisplayed(searchValue2));

        log.info("Search: Relative product name - Step 04: Verify number of product is true");
        int numberOfProductAtResult = searchPage.resultNumberOfProduct(searchValue2);
        int number = 2;
        Assert.assertEquals(numberOfProductAtResult, number);
    }

    @Test
    public void TC_04_Search_Absolute_Product_name() {
        log.info("Search: Absolute product name - Step 01: Input to 'search' textbox with absolute product name is'" + searchValue3 + "'");
        searchPage.sendkeyToSearchTextbox(searchValue3);
        log.info("Search: Absolute product name - Step 02: Click to 'search' button");
        searchPage.clickToSearchButton();
        log.info("Search: Absolute product name - Step 03:Verify product is displayed");
        Assert.assertEquals(searchPage.isProductDisplayed(),searchValue3);
    }

    @Test
    public void TC_05_Advance_Search_Parent_Category() {
        log.info("Advance search: Parent category- Step 01: Input to 'search' textbox with absolute product name is'" + searchValue4 + "'");
        searchPage.sendkeyToSearchTextbox(searchValue4);

        log.info("Advance search: Parent category- Step 02: Click to 'search advance' checkbox");
        searchPage.clickToSearchAdvanceCheckbox();

        log.info("Advance search: Parent category- Step 03: Select category with value is '"+category+"'");
        searchPage.selectCategoryParent(category);

        log.info("Advance search: Parent category- Step 04: Click to 'search' button");
        searchPage.clickToSearchButton();

        log.info("Advance search: Parent category- Step 05: Verify message is displayed");
        Assert.assertEquals(searchPage.getMessageNoResult(),"No products were found that matched your criteria.");
    }

    @Test
    public void TC_06_Advance_Search_Sub_Category() {
        log.info("Advance search: Sub category- Step 01: Input to 'search' textbox with absolute product name is'" + searchValue4 + "'");
        searchPage.sendkeyToSearchTextbox(searchValue4);

        log.info("Advance search: Sub category- Step 02: Click to 'search advance' checkbox");
        searchPage.clickToSearchAdvanceCheckbox();

        log.info("Advance search: Sub category- Step 03: Select category with value is '"+category+"'");
        searchPage.selectCategoryParent(category);

        log.info("Advance search: Sub category- Step 04: Click to 'Automatically search sub categories' checkbox");
        searchPage.clickToSubCategoriesCheckbox();

        log.info("Advance search: Sub category- Step 05: Click to 'search' button");
        searchPage.clickToSearchButton();

        log.info("Advance search: Sub category- Step 06: Verify product is displayed");
        Assert.assertTrue(searchPage.isListProductDisplayed(searchValue4));

        log.info("Advance search: Sub category - Step 07: Verify number of product is true");
        int numberOfProductAtResultAdvanceSearch = searchPage.resultNumberOfProduct(searchValue4);
        int number = 1;
        Assert.assertEquals(numberOfProductAtResultAdvanceSearch, number);
    }

    @Test
    public void TC_07_Advance_Search_Manufacturer() {
        log.info("Advance search: Manufacturer- Step 01: Input to 'search' textbox with absolute product name is'" + searchValue4 + "'");
        searchPage.sendkeyToSearchTextbox(searchValue4);

        log.info("Advance search: Manufacturer- Step 02: Click to 'search advance' checkbox");
        searchPage.clickToSearchAdvanceCheckbox();

        log.info("Advance search: Manufacturer- Step 03: Select category with value is '"+category+"'");
        searchPage.selectCategoryParent(category);

        log.info("Advance search: Manufacturer- Step 04: Click to 'Automatically search sub categories' checkbox");
        searchPage.clickToSubCategoriesCheckbox();

        log.info("Advance search: Manufacturer- Step 05: Select 'Manufacturer' with incorrect manufacturer value is 'HP'");
        searchPage.selectManufacturer("HP");

        log.info("Advance search: Manufacturer- Step 06: Click to 'search' button");
        searchPage.clickToSearchButton();

        log.info("Advance search:Manufacturer- Step 07: Verify message is displayed");
        Assert.assertEquals(searchPage.getMessageNoResult(),"No products were found that matched your criteria.");

        log.info("Advance search: Manufacturer- Step 08: Select 'Manufacturer' with correct manufacturer value is 'Apple'");
        searchPage.selectManufacturer("Apple");

        log.info("Advance search: Manufacturer- Step 09: Click to 'search' button");
        searchPage.clickToSearchButton();

        log.info("Advance search: Manufacturer- Step 10: Verify product is displayed");
        Assert.assertTrue(searchPage.isListProductDisplayed(searchValue4));

        log.info("Advance search: Manufacturer - Step 11: Verify number of product is true");
        int numberOfProductAtResultAdvanceSearch = searchPage.resultNumberOfProduct(searchValue4);
        int number = 1;
        Assert.assertEquals(numberOfProductAtResultAdvanceSearch, number);
    }
}
