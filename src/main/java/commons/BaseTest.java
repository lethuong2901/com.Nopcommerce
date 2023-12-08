package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest extends BasePage {
    WebDriver driver;
    protected final Log log;

    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName) {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("autofill.profile_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            System.out.print("1: " + driver);
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().create();
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        System.out.print("2: " + driver);
        return driver;

    }

    public int Random() {
        Random rand = new Random();
        int random = rand.nextInt(9999);
        return random;
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            //  log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            //   log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            //    log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    DateTime vietnam= DateTime.now("");
//    protected String getCurrentHour(){
//        DateTime nowUTC= new DateTime();
//        int hour=nowUTC.getHourOfDay();
//        return hour;
//    }

    protected String getCurrentDate() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return String.valueOf(day);
    }

    protected String getCurrentMonth() {
        DateTime nowUTC = new DateTime();
        int month = nowUTC.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return String.valueOf(month);
    }

    protected String getCurrentYear() {
        DateTime nowUTC = new DateTime();
        int year = nowUTC.getYear();
        return String.valueOf(year);
    }

    protected String getCurrentHour() {
        DateTime nowUTC = new DateTime();
        int hour = nowUTC.getHourOfDay();
        return String.valueOf(hour);
    }

    protected String getCurrentMinutes() {
        DateTime nowUTC = new DateTime();
        int minute = nowUTC.getMinuteOfHour();
        if (minute < 10) {
            String minuteValue = "0" + minute;
            return minuteValue;
        }

        return String.valueOf(minute);
    }

    protected String getCurrentDateTime() {
        DateTimeZone dateTimeZone = DateTimeZone.forID("America/Los_Angeles");
        DateTime currenDateTime = new DateTime(dateTimeZone);
        DateTimeFormatter formatCurrentDateTime = DateTimeFormat.forPattern("MM/dd/yyyy h:mm a");
        String formattedDateTime = currenDateTime.toString(formatCurrentDateTime);
        return formattedDateTime;
    }


}

