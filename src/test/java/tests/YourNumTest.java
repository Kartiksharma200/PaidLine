package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.YourNumbers.YourNumPage;
import utils.TestData;

import static org.testng.Assert.assertTrue;

public class YourNumTest extends BaseTest {

    private YourNumPage yourNumPage;

    @BeforeMethod
    public void login() throws Exception {
        yourNumPage = new YourNumPage(driver);

        // Login with valid credentials before each test
        yourNumPage.login(TestData.validEmail, TestData.validPassword);
       // Thread.sleep(3000);  
    }

    @Test(priority = 1)
    public void testClickYourNumberCard() throws Exception {
        yourNumPage.ClickpaidlineNum();
      //  Thread.sleep(3000);  // Optional wait for UI response
        yourNumPage.SetCallRate(TestData.SetRate);
        Thread.sleep(3000);
       yourNumPage.SetAvailability();
        Thread.sleep(3000);
       yourNumPage.CallForwarding();
       Thread.sleep(3000);
    }
}
