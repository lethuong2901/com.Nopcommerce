package Nopcommerce.User;

import PageObject.User.HomePageObject;
import PageObject.User.LoginPageObject;
import commons.BaseTest;
import commons.PageGenerator;
import commons.Utilities.User_Data_Mapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserLogin extends BaseTest {
    WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private User_Data_Mapper userDataMapper;
    String firstName, lastName, email, invalidEmail, unRegisterEmail, password, wrongPassword, confirmPassword;
    private int rand= Random();
    @Parameters({"browserName", "url"})
    @BeforeClass
    public void Beforeclass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getUserHomePage(driver);
        userDataMapper= User_Data_Mapper.getUseData();
        firstName = userDataMapper.getFirstName();
        lastName = userDataMapper.getLastName();
        email = userDataMapper.getEmail();
        invalidEmail = UserRegister.email + ".";
        unRegisterEmail = "UnRegisterEmail@gmail.com";
        password = userDataMapper.getPassword();
        wrongPassword = userDataMapper.getPassword() + "s";
        confirmPassword = userDataMapper.getPassword();
        homePage.clickToHeaderLink(driver,"Log in");
        loginPage = PageGenerator.getLoginPage(driver);
    }


    @Test
    public void TC_01_Login_Empty_Data() {
        log.info("Login: Empty data - Step 01: Click to 'login' button");
        loginPage.clickToLoginButton();

        log.info("Login: Empty data - Step 02: Verify error message at email field is displayed");
        Assert.assertEquals(loginPage.getErrorEmailMessage(), "Please enter your email");
    }

    @Test
    public void TC_02_Login_Invalid_Email() {
        log.info("Login: Invalid Email - Step 01: Input to 'email' textbox with value '"+invalidEmail+"'");
        loginPage.senKeyToEmailTextbox(invalidEmail);

        log.info("Login: Invalid Email - Step 02: Input to 'password' textbox with value '"+password+"'");
        loginPage.senKeyToPassword(password);

        log.info("Login: Invalid Email - Step 03: Click to 'login' button");
        loginPage.clickToLoginButton();

        log.info("Login: Invalid Email - Step 04: Verify error message at email field is displayed");
        Assert.assertEquals(loginPage.getErrorWrongEmailMessage(), "Wrong email");
    }

    @Test
    public void TC_03_Login_UnRegister_Email() {
        log.info("Login: Unregister email - Step 01: Input to 'email' textbox with value '"+unRegisterEmail+"'");
        loginPage.senKeyToEmailTextbox(unRegisterEmail);

        log.info("Login: Unregister email - Step 02: Input to 'password' textbox with value '"+password+"'");
        loginPage.senKeyToPassword(password);

        log.info("Login: Unregister email - Step 03: Click to 'login' button");
        loginPage.clickToLoginButton();

        log.info("Login: Unregister email - Step 04:Verify unsuccessful login message");
        Assert.assertEquals(loginPage.getUnSuccessfulMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void TC_04_Login_Not_Input_Password() {
        log.info("Login: Not input password - Step 01: Input to 'email' textbox with value '"+email+"'");
        loginPage.senKeyToEmailTextbox(email);

        log.info("Login: Not input password - Step 02: Click to 'Login' button ");
        loginPage.clickToLoginButton();

        log.info("Login: Not input password- Step 03: Verify unsuccessful login message");
        Assert.assertEquals(loginPage.getUnSuccessfulMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void TC_05_Login_Wrong_Password() {
        log.info("Login: Wrong password - Step 01: Input to 'email' textbox with value '"+email+"'");
        loginPage.senKeyToEmailTextbox(email);

        log.info("Login: Wrong password - Step 02: Input to 'password' textbox with value '"+wrongPassword+"'");
        loginPage.senKeyToPassword(wrongPassword);

        log.info("Login: Wrong password -  Step 03: Click to 'Login' button ");
        loginPage.clickToLoginButton();

        log.info("Login: Wrong password - Step 04: Verify unsuccessful login message");
        Assert.assertEquals(loginPage.getUnSuccessfulMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void TC_06_Login_Successful_Login(){
        log.info("Login: Successful login - Step 01: Input to 'email' textbox with value '"+email+"'");
        loginPage.senKeyToEmailTextbox(email);

        log.info("Login: Successful login - Step 02: Input to 'password' textbox with value '"+password+"'");
        loginPage.senKeyToPassword(password);

        log.info("Login: Successful login - Step 03: Click to 'Login' button ");
        homePage=loginPage.clickToLoginButton();

        log.info("Login: Successful login - Step 04: Verify 'My account' link is displayed");
        Assert.assertTrue(loginPage.IsMyAccountLinkIsDisplayed("My account"));
    }

    @AfterClass(alwaysRun = true)
    public void AfterClass(){
       closeBrowserDriver();
    }
}
