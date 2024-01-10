package Nopcommerce.User;

import PageObject.User.HomePageObject;
import PageObject.User.LoginPageObject;
import PageObject.User.ProductDetailPageObject;
import commons.BaseTest;
import commons.PageGenerator;
import commons.Utilities.User_Data_Mapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserOrder extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private User_Data_Mapper user_data_mapper;
    private ProductDetailPageObject productDetailPage;
    String email, password;
    String processor="2.2 GHz Intel Pentium Dual-Core E2200";
    String ram="2 GB";
    String hdd="320 GB";
    @Parameters({"browserName", "url"})
    @BeforeClass
    public void Beforeclass(String browserName, String url) {
       driver=getBrowserDriver(browserName, url);
       user_data_mapper=User_Data_Mapper.getUseData();
       homePage=PageGenerator.getUserHomePage(driver);
       homePage.clickToHeaderLink(driver,"ico-login");
       loginPage=PageGenerator.getLoginPage(driver);
       email=user_data_mapper.getEmail();
       password=user_data_mapper.getPassword();
       loginPage.senKeyToEmailTextbox(email);
       loginPage.senKeyToPassword(password);
       homePage=loginPage.clickToLoginButton();
    }

    @Test
    public void TC_01_Add_Product_To_Cart(){
        log.info("Order: Add to cart - Step 01: Click to 'Add to cart' button at product name");
        productDetailPage=homePage.clickToAddToCart(driver,"Build your own computer");

        log.info("Order: Add to cart - Step 01: Select 'Processor' at product detail page");
        productDetailPage.selectProcessor(processor);

        log.info("Order: Add to cart - Step 01: Select 'Ram' at product detail page");
        productDetailPage.selectRam(ram);

        log.info("Order: Add to cart - Step 01: Select 'HDD' at product detail page");
        productDetailPage.selectHDD(hdd);

        log.info("Order: Add to cart - Step 01: Click to 'Add to cart' button at detail page");
        productDetailPage.clickToAddToCart();

        log.info("Order: Add to cart - Step 01: Verify successful 'add to cart' message");
        Assert.assertEquals(productDetailPage.getAddToCartSuccessfulMessage(),"The product has been added to your shopping cart");

        log.info("Order: Add to cart - Step 01: Close message");
        productDetailPage.closeToMessage();

        log.info("Order: Add to cart - Step 01: Verify product is add to 'shopping cart'");

    }

    @AfterClass(alwaysRun = true)
    public void AfterClass(){
       closeBrowserDriver();
    }
}
