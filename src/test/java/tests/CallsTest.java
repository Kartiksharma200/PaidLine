package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Calls.CallsPage;
import pages.OnboardingFlow.SignInPage;

import utils.ScreenshotUtils;
import utils.TestData;

public class CallsTest extends BaseTest {

    /**
     * Step 1: Login to the application before accessing Calls section
     */
    @Test(priority = 1)
    public void loginToPaidlineApp() {
        test = extent.createTest("Login to Paidline Application");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.enterEmail(TestData.validEmail);
            signIn.enterPassword(TestData.validPassword);
            signIn.clickLogin();

            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
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

    /**
     * Step 2: Verify Calls page functionality after login
     */
    @Test(priority = 2)
    public void verifyCallsPageAndFilters() {
        test = extent.createTest("Verify Calls Page and Functionalities");

        try {
            CallsPage callsPage = new CallsPage(driver);

            // Navigate to Calls
            callsPage.navigateToCallsPage();
            Assert.assertTrue(callsPage.isCallsPageDisplayed(), "Calls page not displayed");
            test.pass("Calls page opened successfully");

            // Screenshot of initial state
            String initialScreenshot = ScreenshotUtils.captureScreenshot(driver, "callsPageLoaded");
            test.addScreenCaptureFromPath(initialScreenshot);

            // Click "All" filter
            callsPage.clickAllFilter();
            test.pass("Clicked on All filter");

            // Click "Completed" filter
            callsPage.clickCompletedFilter();
            test.pass("Clicked on Completed filter");

            // Click "Missed" filter
            callsPage.clickMissedFilter();
            test.pass("Clicked on Missed filter");

            // Click Export
            callsPage.clickExport();
            test.pass("Clicked on Export button");

            // Go to Page 2 via pagination
            callsPage.clickPageTwo();
            test.pass("Pagination to Page 2 successful");

            // Final screenshot
            String finalScreenshot = ScreenshotUtils.captureScreenshot(driver, "paginationPage2");
            test.addScreenCaptureFromPath(finalScreenshot);

        } catch (Exception e) {
            test.fail("Calls page test failed: " + e.getMessage());

            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "callsPageError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Error screenshot capture failed: " + ex.getMessage());
            }
        }
    }
}
