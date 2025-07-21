package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Help.FeedbackPage;
import pages.Help.RaiseTicketPage;
import pages.Logout.LogoutPage;
import pages.OnboardingFlow.SignInPage;
import pages.YourNumbers.YourNumPage;
import utils.ScreenshotUtils;
import utils.TestData;

public class E2E extends BaseTest {

    /**
     * Step 1: Login using valid credentials
     */
    @Test(priority = 1)
    public void signInWithValidCredentials() {
        test = extent.createTest("Login with Valid Credentials");

        try {
            SignInPage signin = new SignInPage(driver);
            signin.enterEmail(TestData.validEmail);
            signin.enterPassword(TestData.validPassword);
            signin.clickLogin();

            test.pass("Successfully signed in with valid credentials");
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginSuccess");
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            test.fail("Login failed: " + e.getMessage());
        }
    }

    /**
     * Step 2: Verify Dashboard by setting number settings
     */
    @Test(priority = 2)
    public void verifyDashboard() {
        test = extent.createTest("Verify Dashboard Functionalities");

        try {
            YourNumPage dashboard = new YourNumPage(driver);
            dashboard.ClickpaidlineNum();
            dashboard.SetCallRate(TestData.SetRate);
            dashboard.SetAvailability();
            dashboard.CallForwarding();

            test.pass("Dashboard elements interacted successfully");
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "dashboardSetup");
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            test.fail("Dashboard verification failed: " + e.getMessage());
        }
    }

    /**
     * Step 3: Submit feedback from Help section
     */
    @Test(priority = 3)
    public void testSubmitFeedback() {
        test = extent.createTest("Submit Feedback on Help Page");

        try {
            FeedbackPage helpPage = new FeedbackPage(driver);
            helpPage.openHelpPage();  // Assumes method exists to navigate to Help section

            helpPage.verifyHelpPage();
            helpPage.submitFeedback("The app works great, keep it up!");

            test.pass("Feedback submitted successfully");
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "feedbackSubmitted");
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            test.fail("Feedback submission failed: " + e.getMessage());

            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "feedbackError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Could not capture error screenshot: " + ex.getMessage());
            }
        }
    }

    /**
     * Step 4: Raise a ticket from Help section
     */
    @Test(priority = 4)
    public void testSubmitRaiseTicket() {
        test = extent.createTest("Raise a Ticket from Help Page");

        try {
            RaiseTicketPage ticketPage = new RaiseTicketPage(driver);
            ticketPage.clickOnRaiseTicket();
            ticketPage.verifyRaiseTicketPage();
            ticketPage.submitRaiseTicket("I am facing an issue with the billing section. Please check.");

            test.pass("Ticket raised successfully");
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "ticketRaised");
            test.addScreenCaptureFromPath(screenshotPath);

            

        } catch (Exception e) {
            test.fail("Ticket submission failed: " + e.getMessage());

            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "ticketError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Could not capture error screenshot: " + ex.getMessage());
            }
        }
    }

    /**
     * Step 5: Log out from the application
     */
    @Test(priority = 5)
    public void verifyLogoutFunctionality() {
        test = extent.createTest("Logout Functionality");

        try {
            LogoutPage logout = new LogoutPage(driver);
            logout.signout();
            Thread.sleep(2000);
            logout.verifySignOut();
            Thread.sleep(3000);

            test.pass("Logout successful");
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "logoutSuccess");
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            test.fail("Logout failed: " + e.getMessage());

            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "logoutError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Could not capture logout error screenshot: " + ex.getMessage());
            }
        }
    }
}
