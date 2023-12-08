package Nopcommerce.User;

import PageObject.User.HomePageObject;
import PageObject.User.SubCategoryPageObject;
import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserSort_Display_Paging extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private SubCategoryPageObject subCategoryPage;
    private String category="Computers";
    private String subcategory="Notebooks";

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void Beforeclass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        log.info("Khởi tạo trang home page");
        homePage = PageGenerator.getUserHomePage(driver);

        log.info("Click to '"+subcategory+"' subcategory' link");
        homePage.clickToSubCategory(category,subcategory);
        subCategoryPage= PageGenerator.getSubCategoryPage(driver);
    }

    @Test(groups ={ "Sort"})
    public void TC_01_Sort_By_Name_A_to_Z(){
        log.info("Sort: Name A to Z - Step 01: Select sort by 'name A to Z' in dropdown");
        subCategoryPage.selectSortByDropdown("Name: A to Z");
        sleepInSecond(2);

        log.info("Sort: Name A to Z - Step 02: Verify product name is sort by A to Z");
        Assert.assertTrue(subCategoryPage.isProductNameSortbyAscending());
    }

    @Test(groups = {"Sort"})
    public void TC_02_Sort_By_Name_Z_to_A(){
        log.info("Sort by: Name Z to A - Step 01: Select sort by 'name Z to A' in dropdown");
        subCategoryPage.selectSortByDropdown("Name: Z to A");
        sleepInSecond(2);

        log.info("Sort by: Name Z to A - Step 02: Verify product name is sort by Z to A");
        Assert.assertTrue(subCategoryPage.isProductNameSortbyDescending());
    }

    @Test(groups = {"Sort"})
    public void TC_03_Sort_By_Price_Low_to_High(){
        log.info("Sort by: Price low to high - Step 01: Select sort by 'price low to high' in dropdown");
        subCategoryPage.selectSortByDropdown("Price: Low to High");
        sleepInSecond(2);

        log.info("Sort by: Price low to high - Step 02: Verify product price is sort by Z to A");
        Assert.assertTrue(subCategoryPage.isProductPriceSortbyAscending());
    }

   @Test(groups = {"Sort"})
    public void TC_04_Sort_By_Price_High_to_Low(){
        log.info("Sort by: Price high to low - Step 01: Select sort by 'price high to low' in dropdown");
        subCategoryPage.selectSortByDropdown("Price: High to Low");
        sleepInSecond(2);

        log.info("Sort by: Price high to low - Step 02: Verify product price is sort by Z to A");
        Assert.assertTrue(subCategoryPage.isProductPriceSortbyDescending());
    }

    @Test(groups={ "Paging" })
    public void TC_05_Paging_Display_3_Per_Page(){
        log.info("Page: Display 3 per page - Step 01: Select display 3 per page");
        subCategoryPage.clickToPagingDropdown("3");

        log.info("Page: Display 3 per page - Step 02: Verify <= 3 product is displayed in per page");
        Assert.assertTrue(subCategoryPage.isLessOrEqualThreePerPage(driver,"3"));

//        log.info("Page: Display 3 per page- Step: Click to paging");
//        subCategoryPage.clickToElement();
//
//        log.info("Page: Display 3 per page - Step 03: Verify 'next' icon ");
//        Assert.assertTrue(subCategoryPage.isNexIconDisplayed("3"));
//
//        log.info("Page: Display 3 per page - Step 03: Verify 'next' icon is undisplayed at last page");
//        Assert.assertTrue(subCategoryPage.isNexIconUnDisplayed("3"));
//
//        log.info("Page: Display 3 per page - Step 04: Verify 'previous' icon at page 2");
//        Assert.assertTrue((subCategoryPage.isPreviousIconDisplayed("3")));

    }

    @Test(groups="Paging")
    public void TC_06_Paging_Display_6_Per_Page(){
        log.info("Page: Display 6 per page - Step 01: Select display 6 per page");
        subCategoryPage.clickToPagingDropdown("6");
        sleepInSecond(1);

        log.info("Page: Display 3 per page - Step 02: Verify <= 6 product is displayed in per page");
        Assert.assertTrue(subCategoryPage.isLessOrEqualSixPerPage(driver,"6"));

    }

    @Test(groups={"Paging"})
    public void TC_07_Paging_Display_9_Per_Page(){
        log.info("Page: Display 9 per page - Step 01: Select display 9 per page");
        subCategoryPage.clickToPagingDropdown("9");

        log.info("Page: Display 9 per page - Step 02: Verify <= 9 product is displayed in per page");
        Assert.assertTrue(subCategoryPage.isLessOrEqualNinePerPage(driver,"9"));
    }


}