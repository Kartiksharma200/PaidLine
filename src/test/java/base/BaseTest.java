package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = utils.ExtentManager.createInstance();
    }

    @BeforeTest
    public void setUp() {
        // Launch Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://staging.paidline.com/signin");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close browser after each test
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
