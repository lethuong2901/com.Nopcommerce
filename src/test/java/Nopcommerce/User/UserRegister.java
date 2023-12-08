package Nopcommerce.User;

import PageObject.User.HomePageObject;
import PageObject.User.RegisterPageObject;
import commons.BaseTest;
import commons.PageGenerator;
import commons.Utilities.User_Data_Mapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserRegister extends BaseTest {
    private WebDriver driver;
    private HomePageObject userHomePage;
    private RegisterPageObject registerPage;
    private User_Data_Mapper userDataMapper;
    public static String firstName, lastName, email, password, confirmPassword, wrongPassword;
    private int randomEmail = Random();

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        userHomePage = PageGenerator.getUserHomePage(driver);
        userDataMapper=User_Data_Mapper.getUseData();
        firstName=userDataMapper.getFirstName();
        lastName=userDataMapper.getLastName();
        email=userDataMapper.getEmail();
        password=userDataMapper.getPassword();
        confirmPassword=userDataMapper.getPassword();
        wrongPassword=confirmPassword+"1";
        userHomePage.clickToHeaderLink(driver,"Register");
        registerPage=PageGenerator.getRegisterPage(driver);
    }

  //  @Test
    public void TC_01_Register_Empty_Data() {

        log.info("Register: Empty data - Step 01: Click to 'Register' button ");
        registerPage.clickToRegisterButton();

        log.info("Register: Empty data - Step 02: Verify error message at firstname field is displayed");
        Assert.assertEquals(registerPage.getErrorFirstnameMessage(), "First name is required.");

        log.info("Register: Empty data - Step 03: Verify error message at lastname is displayed");
        Assert.assertEquals(registerPage.getErrorLastnameMessage(), "Last name is required.");

        log.info("Register: Empty data - Step 04: Verify error message at email is displayed");
        Assert.assertEquals(registerPage.getErrorEmailMessage(), "Email is required.");

        log.info("Register: Empty data - Step 05: Verify error message at password is displayed");
        Assert.assertEquals(registerPage.getErrorPasswordMessage(), "Password is required.");

        log.info("Register: Empty data - Step 06: Verify error message at confirm pasword is displayed");
        Assert.assertEquals(registerPage.getErrorConfirmPasswordMessage(), "Password is required.");
    }

   // @Test
    public void TC_02_Register_Invalid_Email() {
        log.info("Register: Invalid Email - Step 01: Refresh 'register' page");
        registerPage.reload();

        log.info("Register: Invalid Email - Step 02: Input to 'firstname' textbox with value "+firstName+"");
        registerPage.senkeyToFirstNameTextbox(firstName );

        log.info("Register: Invalid Email - Step 03: Input to 'lastname' textbox with value '"+lastName+"'");
        registerPage.senkeyToLastNameTextbox(lastName );

        log.info("Register: Invalid Email - Step 04: Input to 'email' textbox with value 'WrongEmail.com' ");
        registerPage.senkeyToEmailTextbox("WrongEmail.com");

        log.info("Register: Invalid Email - Step 05: Input to 'password' textbox with value '"+password+"'");
        registerPage.senkeyToPasswordTextbox(password );

        log.info("Register: Invalid Email - Step 06: Input to 'confirm password' textbox with value '"+confirmPassword+"'");
        registerPage.senkeyToConfirmPasswordTextbox(confirmPassword );

        log.info("Register: Invalid Email - Step 07: Click to 'Register' button");
        registerPage.clickToRegisterButton();

        log.info("Register: Invalid Email - Step 08: Verify error message at 'email' field  is displayed");
        Assert.assertEquals(registerPage.getErrorWrongEmailMessage(), "Wrong email");
    }

    @Test
    public void TC_03_Register_Successful() {
        log.info("Register: Successful - Step 01: Refresh 'Register' page");
        registerPage.reload();

        log.info("Register: Successful - Step 02:Input to 'firstname' textbox with value '"+firstName+"'");
        registerPage.senkeyToFirstNameTextbox(firstName );

        log.info("Register: Successful - Step 03:Input to 'lastname' textbox with value '"+lastName+"'");
        registerPage.senkeyToLastNameTextbox(lastName );

        log.info("Register: Successful - Step 04:Input to 'email' textbox with value '"+email+"'");
        System.out.print(email);
        registerPage.senkeyToEmailTextbox(email);

        log.info("Register: Successful - Step 05:Input to 'password' textbox with value '"+password+"'");
        registerPage.senkeyToPasswordTextbox(password );

        log.info("Register: Successful - Step 06:Input to 'confirm password' textbox with value '"+confirmPassword+"'");
        registerPage.senkeyToConfirmPasswordTextbox(confirmPassword );

        log.info("Register: Successful - Step 07: Click to 'Register' button");
        registerPage.clickToRegisterButton();

        log.info("Register: Successful - Step 08: Verify register success message is displayed");
        Assert.assertEquals(registerPage.getSuccessRegisterMessage(),"Your registration completed");
    }

 //   @Test
    public void TC_04_Register_Email_Existed() {
        log.info("Register: Email Existed - Step 01: Click to 'register' link");
        registerPage.clickToHeaderLink(driver,"Register");
        registerPage=PageGenerator.getRegisterPage(driver);

        log.info("Register: Email Existed - Step 02: Input to 'firstname' textbox with value '"+firstName+"'");
        registerPage.senkeyToFirstNameTextbox(firstName );

        log.info("Register: Email Existed - Step 03: Input to 'lastname' textbox with value '"+lastName+"'");
        registerPage.senkeyToLastNameTextbox(lastName );

        log.info("Register: Email Existed - Step 04: Input to 'email' textbox with value '"+email+"'");
        registerPage.senkeyToEmailTextbox(email);

        log.info("Register:Email Existed - Step 05: Input to 'password' textbox with value '"+password+"'");
        registerPage.senkeyToPasswordTextbox(password );

        log.info("Register: Email Existed- Step 06: Input to 'confirm password' textbox with value '"+confirmPassword+"'");
        registerPage.senkeyToConfirmPasswordTextbox(confirmPassword );

        log.info("Register:Email Existed - Step 07: Click to 'register' button");
        registerPage.clickToRegisterButton();

        log.info("Register: Email Existed - Step 08: Verify error message at 'email' field is displayed");
        Assert.assertEquals(registerPage.getErrorExistedEmaiMessage(),"The specified email already exists");
    }

 //   @Test
    public void TC_05_Register_Password_Less_Than_6_characters() {
        log.info("Register: Password less than 6 characters - Step 01: Click to 'register' link");
        registerPage.clickToHeaderLink(driver,"Register");
        registerPage=PageGenerator.getRegisterPage(driver);

        log.info("Register: Password less than 6 characters - Step 02: Input to 'firstname' textbox with value '"+firstName+"'");
        registerPage.senkeyToFirstNameTextbox(firstName );

        log.info("Register: Password less than 6 characters - Step 03: Input to 'lastname' textbox with value '"+lastName+"'");
        registerPage.senkeyToLastNameTextbox(lastName );

        log.info("Register: Password less than 6 characters - Step 04: Input to 'email' textbox with value '"+email+"'");
        registerPage.senkeyToEmailTextbox(email);

        log.info("Register: Password less than 6 characters - Step 05: Input to 'password' textbox with value '12345'");
        registerPage.senkeyToPasswordTextbox("12345");

        log.info("Register: Password less than 6 characters - Step 06: Input to 'confirm password' textbox with value '12345'");
        registerPage.senkeyToConfirmPasswordTextbox(confirmPassword );

        log.info("Register: Password less than 6 characters - Step 07: Click to 'register' button");
        registerPage.clickToRegisterButton();

        log.info("Register: Password less than 6 characters - Step 08: Verify error message at 'password' field is displayed");
        Assert.assertEquals(registerPage.getErrorRulePasswordMessage(),"Password must meet the following rules:\nmust have at least 6 characters");
    }

 //   @Test
    public void TC_06_NOT_MATCH_PASSWORD() {
        log.info("Register: Not match password - Step 01: Click to 'register' link");
        registerPage.clickToHeaderLink(driver,"Register");
        registerPage=PageGenerator.getRegisterPage(driver);

        log.info("Register: Not match password - Step 02: Input to 'firstname' textbox with value '"+firstName+"'");
        registerPage.senkeyToFirstNameTextbox(firstName );

        log.info("Register: Not match password - Step 03: Input to 'lastname' textbox with value '"+lastName+"'");
        registerPage.senkeyToLastNameTextbox(lastName );

        log.info("Register: Not match password - Step 04: Input to 'email' textbox with value '"+email+"'");
        registerPage.senkeyToEmailTextbox(email);

        log.info("Register: Not match password - Step 05: Input to 'password' textbox with value '"+password+"'");
        registerPage.senkeyToPasswordTextbox(password);

        log.info("Register: Not match password - Step 02: Input to 'confirm password' textbox with value '"+wrongPassword+"'");
        registerPage.senkeyToConfirmPasswordTextbox(wrongPassword);

        log.info("Register: Not match password - Step 07: Click to 'register' button");
        registerPage.clickToRegisterButton();

        log.info("Register: Not match password - Step 08: Verify error message at 'confirm password' field is displayed");
        Assert.assertEquals(registerPage.getNotMatchPasswordMessage(),"The password and confirmation password do not match.");
    }

    @AfterClass(alwaysRun = true)
    public void Afterclass(){
        closeBrowserDriver();
    }
}
