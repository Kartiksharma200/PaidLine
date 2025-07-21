package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import base.BaseTest;
import pages.Help.FeedbackPage;
import pages.Help.RaiseTicketPage;

import pages.OnboardingFlow.SignInPage;
import utils.ScreenshotUtils;
import utils.TestData;
import utils.WaitUtils;

public class HelpTest extends BaseTest{

    @Test(priority = 1)
    public void loginToApp() {
        test = extent.createTest("Login to the Application");

        try {
            SignInPage signInPage = new SignInPage(driver);
            signInPage.login(TestData.validEmail, TestData.validPassword);

            WaitUtils.waitForUrlToContain(driver, "dashboard");
            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

            test.pass("Login successful");
            String path = ScreenshotUtils.captureScreenshot(driver, "loginSuccess");
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            test.fail("Login failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void testSubmitFeedback() {
        test = extent.createTest("Submit Feedback on Help Page");

        try {
            FeedbackPage helpPage = new FeedbackPage(driver);
            helpPage.openHelpPage();

            helpPage.verifyHelpPage();
            test.pass("Help page loaded successfully");

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

    @Test(priority = 3)
    public void testSubmitRaiseTicket() {
        test = extent.createTest("Raise a Ticket from Help Page");

        try {
            RaiseTicketPage ticketPage = new RaiseTicketPage(driver);
            ticketPage.clickOnRaiseTicket();
            ticketPage.verifyRaiseTicketPage();

            ticketPage.submitRaiseTicket("I am facing an issue with the billing section. Please check.");
            test.pass("Ticket filled with service request and checkboxes");
            //ticketPage.clickSubmitButton();
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "ticketFilled");
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
}
