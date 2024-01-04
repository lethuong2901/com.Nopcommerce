package Nopcommerce.Admin;

import PageObject.Admin.DashboardPageObject;
import PageObject.Admin.LoginPageObject;
import commons.BaseTest;
import commons.GlobalConstant;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminSearchProductName extends BaseTest {
    WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    String username, password = GlobalConstant.PASSWORD_ADMIN;
    @Parameters({"browserName","urlAdmin"})
    @BeforeClass
    public void BeforeClass(String browserName, String urlAdmin){
        driver= getBrowserDriver(browserName,urlAdmin);
        username= GlobalConstant.USERNAME_ADMIN;
        loginPage= PageGenerator.getAdminLoginPage(driver);
        loginPage.senKeyToUsernameTextbox(username);
        loginPage.sendKeyToPasswordTextbox(password);
        dashboardPage=loginPage.clickToLoginButton();
    }

    @Test
    public void TC_01_Search_With_Product_Name()
    {
        log.info("Seach: Search with product name - Step 01: Click to 'Catalog' ");
        dashboardPage.clickToCataLogLink();

        log.info("Seach: Search with product name - Step 01: Click to 'Product' ");
//        dashboardPage.clickToProductLinkAtCataLog();
    }

}
