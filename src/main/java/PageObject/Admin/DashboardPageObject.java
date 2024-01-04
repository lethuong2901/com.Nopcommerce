package PageObject.Admin;

import PageUIs.Admin.DashboardPageUIs;
import PageUIs.Admin.LoginPageUIs;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePage {
    WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToCataLogLink() {
        waitForElementClickable(driver, DashboardPageUIs.CATALOG_LINK);
        clickToElement(driver,DashboardPageUIs.CATALOG_LINK);
    }
}
