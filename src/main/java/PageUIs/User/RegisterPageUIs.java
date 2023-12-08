package PageUIs.User;

public class RegisterPageUIs {
    public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
    public static final String CONFIRMPASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
    public static final String WRONG_EMAIL_MESASGE ="xpath=//span[@id='Email-error']" ;
    public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result']";
    public static final String EXISTED_EMAIL_MESSSAGE = "xpath=//div[@class='message-error validation-summary-errors']";
    public static final String RULE_PASSWORD_MESSAGE = "xpath=//span[@id='Password-error']" ;
    public static final String NOT_MATCH_PASSWORD_MESSAGE = "xpath=//span[@id='ConfirmPassword-error']";
    public static String REGISTER_BUTTON= "xpath=//button[@id='register-button']";
    public static String FIRSTNAME_ERROR_MESSAGE="xpath=//span[@id='FirstName-error']";
    public static String LASTNAME_ERROR_MESSAGE="xpath=//span[@id='LastName-error']";
    public static String EMAIL_ERROR_MESSAGE="xpath=//span[@id='Email-error']";
    public static String PASSWORD_ERROR_MESSAGE="xpath=//span[@id='Password-error']";
    public static String CONFIRM_PASSWORD_ERROR_MESSAGE="xpath=//span[@id='ConfirmPassword-error']";
}
