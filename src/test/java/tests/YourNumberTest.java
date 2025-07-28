package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.OnboardingFlow.SignInPage;
import pages.YourNumber.YourNumberPage;
import utils.ScreenshotUtils;
import utils.TestData;

public class YourNumberTest extends BaseTest {

    @BeforeClass
    public void loginToPaidline() {
        test = extent.createTest("Login to Paidline Application");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.enterEmail(TestData.validEmail);
            signIn.enterPassword(TestData.validPassword);
            signIn.clickLogin();
            Thread.sleep(5000);
            Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
            test.pass("Login successful");

            String loginScreenshot = ScreenshotUtils.captureScreenshot(driver, "loginSuccess");
            test.addScreenCaptureFromPath(loginScreenshot);

        } catch (Exception e) {
            test.fail("Login failed: " + e.getMessage());
            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "loginError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Failed to capture login error screenshot: " + ex.getMessage());
            }
        }
    }

    @Test(priority = 1)
    public void verifyAndUpdateYourNumberSettings() {
        test = extent.createTest("Verify & Update Your Number Page");

        try {
            YourNumberPage numberPage = new YourNumberPage(driver);

            // Navigate to Your Number page
            numberPage.clickOnYourNumberHeader();
            Assert.assertTrue(driver.getCurrentUrl().contains("/user/numbers"), "Not on Your Number page");
            test.pass("Navigated to Your Number page");
            Thread.sleep(2000);
            Assert.assertTrue(numberPage.isYourNumberHeaderVisible(), "Your Number header is not visible");
            test.pass("Your Number header is visible");
            Thread.sleep(2000); 
            

            // Call Rate
            numberPage.setCallRate("25");
            numberPage.clickSaveRate();
            test.pass("Call Rate set and saved");

            // Toggle Availability
            numberPage.toggleMonFri();
            numberPage.toggleSatSun();
            test.pass("Availability toggles updated");

            // Set Availability Times
            numberPage.setAvailabilityTimes("10:00AM", "6:00PM", "09:00AM", "5:00PM");
            test.pass("Availability time set");

            // Forwarding Number
            String number = numberPage.getForwardingNumber();
            Assert.assertTrue(number.startsWith("+"), "Forwarding number format is invalid");
            test.pass("Forwarding number verified: " + number);

            // Manage Numbers link
            numberPage.clickManageNumbers();
            test.pass("Manage Numbers link clicked");
            driver.navigate().back();
            Thread.sleep(2000);

            // Whisper Voice
            numberPage.selectWhisperVoice("Female");
            test.pass("Whisper voice set to Female");

            // Call Notification Message
            numberPage.updateCallNotification("Automated test message for call greeting.");
            test.pass("Default call notification updated");

            // Active toggle
            boolean activeBefore = numberPage.isActive();
            numberPage.toggleActiveStatus();
            Thread.sleep(1000);
            boolean activeAfter = numberPage.isActive();
            Assert.assertNotEquals(activeBefore, activeAfter, "Active status toggle failed");
            test.pass("Active status toggled successfully");

            // Screenshot
            String ss = ScreenshotUtils.captureScreenshot(driver, "yourNumberUpdated");
            test.addScreenCaptureFromPath(ss);

        } catch (Exception e) {
            test.fail("Your Number page test failed: " + e.getMessage());
            try {
                String err = ScreenshotUtils.captureScreenshot(driver, "yourNumberError");
                test.addScreenCaptureFromPath(err);
            } catch (Exception ex) {
                test.fail("Screenshot capture failed: " + ex.getMessage());
            }
        }
    }
}
