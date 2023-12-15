package Nopcommerce.User;

import PageObject.User.*;
import commons.BaseTest;
import commons.PageGenerator;
import commons.Utilities.User_Data_Mapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserWishlist extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private ProductDetailPageObject productDetailPage;
    private WishlistPageObject wishlistPage;
    private ShoppingCartPageObject shoppingCartPage;
    private User_Data_Mapper userDataMapper;
    String email, password, fullname;

    String productName="Apple MacBook Pro 13-inch";
    @Parameters({"browserName","url"})
    @BeforeClass
    public void Beforeclass(String browserName, String url){
        driver=getBrowserDriver(browserName,url);
        userDataMapper=User_Data_Mapper.getUseData();
        email= userDataMapper.getEmail();
        password=userDataMapper.getPassword();
        fullname=userDataMapper.getFirstName()+" "+userDataMapper.getLastName();
        homePage=PageGenerator.getUserHomePage(driver);
        homePage.clickToHeaderLink(driver,"ico-login");
        loginPage= PageGenerator.getLoginPage(driver);
        loginPage.senKeyToEmailTextbox(email);
        loginPage.senKeyToPassword(password);
        homePage=loginPage.clickToLoginButton();
    }

    @Test
    public void TC_01_Wishlist_Add_To_Wishlist(){
        log.info("Wishlist: Add to wishlist - Step 01: Click to product name at home page");
        productDetailPage=homePage.clickToProduct(driver,productName);

        log.info("Wishlist: Add to wishlist - Step 02: Click to 'add wishlist' at product detail page ");
        productDetailPage.clickToAddWishlistLink();
        sleepInSecond(3);

        log.info("Wishlist: Add to wishlist - Step 03: Verify mesage product is added to wishlist ");
        Assert.assertEquals(productDetailPage.getMessageProductIsAddWishlistDisplayed(),"The product has been added to your wishlist");

        log.info("Wishlist: Add to wishlist - Step 04: Close successful message product is added ");
        productDetailPage.closeToMessage();

        log.info("Wishlist: Add to wishlist - Step 05: Click to 'add wishlist' link at header");
        productDetailPage.clickToHeaderLink(driver,"ico-wishlist");
        wishlistPage=PageGenerator.getWishlistPage(driver);

        log.info("Wishlist: Add to wishlist - Step 06: Verify product is displayed ");
        Assert.assertTrue(wishlistPage.isProductDiplayed(driver,"Product(s)",productName));

        log.info("Wishlist: Add to wishlist - Step 07: Click to 'url share add wishlist' link");
        wishlistPage.clickToUrlShareWishlist();

        log.info("Wishlist: Add to wishlist - Step 08: Verify wishlist title is displayed with name");
        Assert.assertTrue(wishlistPage.isWishlistTitleDisplayed(driver,fullname));

        log.info("Wishlist: Add to wishlist - Step 09: Verify product in wishlist is displayed with name ");
        Assert.assertTrue(wishlistPage.isWishlistProductDisplayed(driver,"Product(s)",productName));
    }
//    @Test
//    public void TC_02_Wishlist_Add_To_Cart(){
//        log.info("Wishlist:Add to cart - Step : Click to 'home' page");
//        wishlistPage.clickToHomePage();
//
//        log.info("Wishlist:Add to cart - Step : Click to 'wishlist' page");
//        wishlistPage.clickToHeaderLink(driver,"ico-wishlist");
//
//        log.info("Wishlist:Add to cart - Step : Click to 'add to cart' checkbox at product name'"+productName+"'");
//        wishlistPage.clickToAddToCartCheckbox();
//
//        log.info("Wishlist:Add to cart - Step : Click to 'add to cart' button");
//        shoppingCartPage=wishlistPage.clickToAddToCartButton();
//
//        log.info("Wishlist:Add to cart - Step : Verify product is displayed at 'shopping cart' page");
//        Assert.assertTrue(shoppingCartPage.isProductDisplayed(driver,""));
//        log.info("Wishlist:Add to cart - Step : Click to 'wishlist' page");
//        log.info("Wishlist:Add to cart - Step : Verify product '"+productName+"' is undisplayed at 'wishlist' page");
//
//    }
}
