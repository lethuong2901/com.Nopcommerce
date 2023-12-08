package Nopcommerce.User;


import PageObject.User.*;
import commons.BaseTest;
import commons.PageGenerator;
import commons.Utilities.User_Data_Mapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserMyAccount extends BaseTest {
    WebDriver driver;
    private User_Data_Mapper userDataMapper;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private AddressPageObject addressPage;
    private CustomerInfoPageObject customerInfoPage;
    private ChangePasswordPageObject changePasswordPage;
    private MyProductReviewsPageObject myProductReviewsPage;
    private ProductReviewPageObject productReviewsPage;
    private ProductDetailPageObject productDetailPage;
    private String email, password;
    private String companyName, country, state;
    private String titleReview, contentReview, rating, styleRating;
    private String currentDay = getCurrentDateTime();
    int rand = Random();
    private String name, newFirstName, newLastName, newEmail, newPassword, newDateOfBirth, newMonthOfBirth, newYearOfBirth;

    @Parameters({"browserName", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        userDataMapper = User_Data_Mapper.getUseData();
        email = userDataMapper.getEmail();
        password = userDataMapper.getPassword();
        newFirstName = "Automation";
        newLastName = "Test";
        newDateOfBirth = "15";
        newMonthOfBirth = "September";
        newYearOfBirth = "1990";
        newEmail = email;
        newPassword = "P12345!";
        companyName = "Automation Test";
        country = "Viet Nam";
        state = "Other";
        name = newFirstName + " " + newLastName;
        titleReview = "Review for product " + rand;
        contentReview = "Good";
        rating = "4";
        homePage = PageGenerator.getUserHomePage(driver);
        homePage.clickToHeaderLink(driver, "Log in");
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.senKeyToEmailTextbox(email);
        loginPage.senKeyToPassword(password);
        homePage = loginPage.clickToLoginButton();

        if (rating == "1") {
            styleRating = "20";
        } else if (rating == "2") {
            styleRating = "40";
        } else if (rating == "3") {
            styleRating = "60";
        } else if (rating == "4") {
            styleRating = "80";
        } else if (rating == "5") {
            styleRating = "100";
        }
    }

    //    @Test
    public void TC_01_MyAccount_Update_CustomerInfo() {
        log.info("My Account: Update Customer Infor- Step 01: Open 'CustomerInfor' page ");
        homePage.clickToHeaderLink(driver, "My account");
        customerInfoPage = PageGenerator.getCustomerInfoPage(driver);

        log.info("My Account: Update Customer Infor- Step 02: Verify 'CustomerInfor' link is displayed");
        Assert.assertTrue(customerInfoPage.isCustomerInforDisplayed());

        log.info("My Account: Update Customer Infor- Step 03: Click To gender ");
        customerInfoPage.clickToGender("male");

        log.info("My Account: Update Customer Infor- Step 04: Update 'firstName' with value'" + newLastName + "'");
        customerInfoPage.updateFirstName(newFirstName);

        log.info("My Account: Update Customer Infor- Step 05: Update 'lasName' with value'" + newLastName + "'");
        customerInfoPage.updateLastName(newLastName);

        log.info("My Account: Update Customer Infor- Step 06: Update 'date of birth' with value'" + newDateOfBirth + "'");
        customerInfoPage.updateDateOfBirth(newDateOfBirth);

        log.info("My Account: Update Customer Infor- Step 07: Update  'month of birth' with value'" + newMonthOfBirth + "'");
        customerInfoPage.updateMonthOfBirth(newMonthOfBirth);

        log.info("My Account: Update Customer Infor- Step 08: Update 'year of birth' with value'" + newYearOfBirth + "'");
        customerInfoPage.updateYearOfBirth(newYearOfBirth);

        log.info("My Account: Update CustomerInfo- Step 09: Update 'email with value'" + newEmail);
        customerInfoPage.updateEmail(newEmail);

        log.info("My Account: Update CustomerInfo- Step 10: Update 'company name' with value'" + companyName);
        customerInfoPage.sendKeyToCompanyTextBox(companyName);

        log.info("My Account: Update CustomerInfo- Step 11: Click to 'save' button");
        customerInfoPage.clickToSaveButton();

        log.info("My Account: Update CustomerInfo- Step 12: Verify gender 'male' is checked");
        Assert.assertTrue(customerInfoPage.IsGenderChecked("male"));

        log.info("My Account: Update CustomerInfo- Step 13: Verify 'firstname' is update");
        Assert.assertTrue(customerInfoPage.IsFirstNameUpdateDisplayed(newFirstName, "value"));

        log.info("My Account: Update CustomerInfo- Step 14: Verify 'lastname' is update");
        Assert.assertTrue(customerInfoPage.IsLastNameUpdateDisplayed(newLastName, "value"));

        log.info("My Account: Update CustomerInfo- Step 15: Verify 'date of birth' is update");
        Assert.assertTrue(customerInfoPage.IsDateOfBirthUpdateDisplayed(newDateOfBirth, "value"));

        log.info("My Account: Update CustomerInfo- Step 16: Verify 'month of birth' is update");
        Assert.assertTrue(customerInfoPage.IsMonthOfBirthUpdateDisplayed("9", "value"));

        log.info("My Account: Update CustomerInfo- Step 17: Verify 'year of birth' is update");
        Assert.assertTrue(customerInfoPage.IsYearUpdateDisplayed(newYearOfBirth, "value"));

        log.info("My Account: Update CustomerInfo- Step 18: Verify 'email' is update");
        Assert.assertTrue(customerInfoPage.IsEmailUpdateDisplayed(newEmail, "value"));

        log.info("My Account: Update CustomerInfo- Step 19: Verify 'company name' is update");
        Assert.assertTrue(customerInfoPage.IsCompanyNameUpdateDisplayed(companyName, "value"));
    }

    //  @Test
    public void TC_02_Add_Address() {
        log.info("My account: Add Address - Step 01: Open 'Address' page ");
        customerInfoPage.clickToSideBarLink(driver, "Addresses");
        addressPage = PageGenerator.getAddressPage(driver);

        log.info("My account: Add Address - Step 02: Click to new address button");
        addressPage.clickToAddNewButton();

        log.info("My account: Add Address - Step 03: Input to 'Firstname' textbox with value'" + newFirstName + "'");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "FirstName", newFirstName);

        log.info("My account: Add Address - Step 04: Input to 'Lastname' textbox with value'" + newLastName + "'");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "LastName", newLastName);

        log.info("My account: Add Address - Step 05: Input to 'Email' textbox with value'" + newEmail + "'");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "Email", newEmail);

        log.info("My account: Add Address - Step 06: Input to 'Company name' textbox with value'" + companyName + "'");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "Company", companyName);

        log.info("My account: Add Address - Step 07: Select country in dropdown");
        addressPage.selectCountryDropdown(country);

        log.info("My account: Add Address - Step 07: Select state in dropdown");
        addressPage.selectStateDropdown(state);

        log.info("My account: Add Address - Step 08: Input to 'Country' textbox");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "City", "Ha Noi");

        log.info("My account: Add Address - Step 09: Input to 'Address1' textbox");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "Address1", "10 Chua Boc");

        log.info("My account: Add Address - Step 10: Input to 'Address2' textbox");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "Address2", "12 Pham Ngoc Thach");

        log.info("My account: Add Address - Step 11: Input to 'ZipPostalCode' textbox");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "ZipPostalCode", "01234");

        log.info("My account: Add Address - Step 12: Input to 'PhoneNumber' textbox");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "PhoneNumber", "0987890789");

        log.info("My account: Add Address - Step 13: Input to 'FaxNumber' textbox");
        addressPage.sendKeyToTextboxAtAddressPage(driver, "FaxNumber", "0989");

        log.info("My account: Add Address - Step 14: Click to 'Save' button");
        addressPage.clickToSaveButton();

        log.info("My account: Add Address - Step 15: Verify 'name' is displayed");
        Assert.assertTrue(addressPage.isInformationUpdated(driver, "name", name));

        log.info("My account: Add Address - Step 16: Verify 'email' is displayed");
        Assert.assertTrue(addressPage.isEmailUpdated(newEmail));

        log.info("My account: Add Address - Step 17: Verify 'phone' is displayed");
        Assert.assertTrue(addressPage.isPhoneUpaded("0987890789"));

        log.info("My account: Add Address - Step 18: Verify 'fax' is displayed");
        Assert.assertTrue(addressPage.isFaxUpdated("0989"));

        log.info("My account: Add Address - Step 19: Verify 'company name' is displayed");
        Assert.assertTrue(addressPage.isInformationUpdated(driver, "company", companyName));

        log.info("My account: Add Address - Step 20: Verify 'address 1' is displayed");
        Assert.assertTrue(addressPage.isInformationUpdated(driver, "address1", "10 Chua Boc"));

        log.info("My account: Add Address - Step 21: Verify 'address 2' is displayed");
        Assert.assertTrue(addressPage.isInformationUpdated(driver, "address2", "12 Pham Ngoc Thach"));

        log.info("My account: Add Address - Step 22: Verify 'city-state-zip' is displayed");
        Assert.assertTrue(addressPage.isInformationUpdated(driver, "city-state-zip", "Ha Noi" + ", " + "01234"));

        log.info("My account: Add Address - Step 23: Verify 'country' is displayed");
        Assert.assertTrue(addressPage.isInformationUpdated(driver, "country", country));

    }

    //  @Test
    public void TC_03_MyAccount_Change_Password() {
        log.info("My account: Change password - Step 01: Open to 'Change password' page");
        addressPage.clickToSideBarLink(driver, "Change password");
        changePasswordPage = PageGenerator.getChangePasswordPage(driver);

        log.info("My account: Change password - Step 02: Input to 'old password' textbox with value'" + password + "'");
        changePasswordPage.SendkeyToOldPasswordTextbox(password);

        log.info("My account: Change password - Step 03: Input to 'new password' textbox with value'" + newPassword + "'");
        changePasswordPage.SendkeyToNewPasswordTextbox(newPassword);

        log.info("My account: Change password - Step 04: Input to 'confirm password' textbox with value'" + newPassword + "'");
        changePasswordPage.SendkeyToConfirmPasswordTextbox(newPassword);

        log.info("My account: Change password - Step 05: Click to 'Change password' button");
        changePasswordPage.clickToChangePasswordButton();

        log.info("My account: Change password - Step 05: Click to 'Close updated'");
        changePasswordPage.clickToCloseUpdated();

        log.info("My account: Change password - Step 05: Click to 'Log out' link");
        changePasswordPage.clickToHeaderLink(driver, "Log out");
        homePage = PageGenerator.getUserHomePage(driver);

        log.info("My account: Change password - Step 05: Click to 'Login' link");
        homePage.clickToHeaderLink(driver, "Log in");

        log.info("My account: Change password - Step 06: Input to 'email' textbox with value '" + email + "'");
        loginPage.senKeyToEmailTextbox(newEmail);

        log.info("My account: Change password - Step 07: Input to 'password' textbox with old password '" + password + "'");
        loginPage.senKeyToPassword(password);

        log.info("My account: Change password - Step 08: Click to 'Login' button");
        loginPage.clickToLoginButton();

        log.info("My account: Change password - Step 09: Verify error login message is displayed");
        Assert.assertEquals(loginPage.getUnSuccessfulMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        log.info("My account: Change password - Step 10: 'Login again' input to 'password' textbox with new password '" + newPassword + "'");
        loginPage.senKeyToPassword(newPassword);

        log.info("My account: Change password - Step 11: Click to 'Login' button");
        loginPage.clickToLoginButton();

        log.info("My account: Change password - Step 12: Verify 'My account' link is displayed");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed(driver, "My account"));
    }

    @Test
    public void TC_04_MyAccount_My_Product_Review() {
        log.info("My Account: My product review - Step 01: Click to a product");
        productDetailPage = homePage.clickToProduct(driver, "Build your own computer");

        log.info("My Account: My product review - Step 02: Click to 'add your review' link");
        productReviewsPage = productDetailPage.clickToAddReviewLink();

        log.info("My Account: My product review - Step 03: In put to 'review title' textbox");
        productReviewsPage.sendkeyToTitleReview(titleReview);

        log.info("My Account: My product review - Step 04: In put to 'review text' textarea");
        productReviewsPage.sendkeyToContentReview(contentReview);

        log.info("My Account: My product review - Step 05: Click to 'rating'");
        productReviewsPage.clickToRating(rating);

        log.info("My Account: My product review - Step 06: Click to 'submit review' button");
        productReviewsPage.clickToSubmitButton();

        log.info("My Account: My product review - Step 06: Verify review is added");
        Assert.assertTrue(productReviewsPage.isReviewAdded());

        log.info("My Account: My product review - Step 07: Click to 'my account' link");
        productReviewsPage.clickToHeaderLink(driver, "My account");

        log.info("My Account: My product review - Step 07: Click to 'My product reviews' link");
        homePage.clickToSideBarLink(driver, "My product reviews");
        myProductReviewsPage = PageGenerator.getMyProductReviewPage(driver);

        log.info("My Account: My product review - Step 08: Verify 'review title' is displayed");
        Assert.assertTrue(myProductReviewsPage.isTitleReviewDisplayed(titleReview));

        log.info("My Account: My product review - Step 10: Verify 'review content' is displayed");
        Assert.assertTrue(myProductReviewsPage.isReviewContentDisplayed(driver, titleReview, contentReview));

        log.info("My Account: My product review - Step 09: Verify 'rating' is displayed");
        Assert.assertTrue(myProductReviewsPage.isRatingDisplayed(titleReview,styleRating));

        log.info("My Account: My product review - Step 11: Verify 'date' is displayed");
        Assert.assertTrue(myProductReviewsPage.isDateDisplayed(titleReview, currentDay));
        System.out.print(currentDay);


    }

    @AfterClass(alwaysRun = true)
    public void AfterClass() {
        //   closeBrowserDriver();
    }

}
