package tests.callTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.Calls.CallsPage;
import pages.OnboardingFlow.SignInPage;
import utils.ScreenshotUtils;
import utils.TestData;
import utils.WaitUtils;

public class CallsTest extends BaseTest {

    /*
     * Step 1: Login to the application before accessing Calls section
     */
	@BeforeClass
	public void loginToPaidlineApp() {
	    test = extent.createTest("Login to Paidline Application");

	    try {
	        SignInPage signIn = new SignInPage(driver);
	        signIn.enterEmail(TestData.validEmail);
	        signIn.enterPassword(TestData.validPassword);
	        signIn.clickLogin();

	        // ✅ Use your custom wait utility
	        WaitUtils.waitForUrlToContain(driver, "user/dashboard");

	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("Current URL after login: " + currentUrl);

	        // ✅ Assert to confirm login was successful
	        Assert.assertTrue(currentUrl.contains("user/dashboard"), "Login URL does not contain expected 'user/dashboard'");

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
	        // Force test to fail if login fails
	        throw new RuntimeException(e);
	    }
	}
    /*
     * Step 2: Verify Vendor Calls page functionality after login
     */
    @Test(priority = 1)
    public void verifyVendorCallsPageAndFilters() {
        test = extent.createTest("Verify Vendor Calls Page and Functionalities");

        try {
            CallsPage callsPage = new CallsPage(driver);

            // Navigate to Calls
            callsPage.navigateToCallsPage();
            Assert.assertTrue(callsPage.isCallsPageDisplayed(), "Vendor Calls page not displayed");
            test.pass("Vendor Calls page opened successfully");

            // Screenshot of initial state
            String initialScreenshot = ScreenshotUtils.captureScreenshot(driver, "callsPageLoaded");
            test.addScreenCaptureFromPath(initialScreenshot);

            // Click "Billed" Filter
            callsPage.clickbilledFilter();
            test.pass("Clicked on Billed filter");

            // Click "Unbilled" Filter
            callsPage.clickUnbilledFilter();
            test.pass("Clicked on Unbilled filter");

            // Click "Missed" filter
            callsPage.clickMissedFilter();
            test.pass("Clicked on Missed filter");

            // Click "Inbound Call" filter
            callsPage.clickInboundCallFilter();
            test.pass("Clicked on Inbound Call filter");

            // Click "Returned Call" filter
            callsPage.clickReturnedCallFilter();
            test.pass("Clicked on Returned Call filter");

            // Click "All" filter
            callsPage.clickAllFilter();
            test.pass("Clicked on All filter");

            // Click Export
            callsPage.clickExport();
            test.pass("Clicked on Export button");

            // Go to Page 2 via pagination
            callsPage.clickPageTwo();
            test.pass("Pagination to Page 2 successful");
            System.out.println("Run all function");

            // Final screenshot
            String finalScreenshot = ScreenshotUtils.captureScreenshot(driver, "paginationPage2");
            test.addScreenCaptureFromPath(finalScreenshot);

        } catch (Exception e) {
            test.fail("Vendor Calls page test failed: " + e.getMessage());

            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "callsPageError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Error screenshot capture failed: " + ex.getMessage());
            }
        }
    }

    /*
     * Step 2: Verify Vendor Calls page functionality after login
     */
    @Test(priority = 2, dependsOnMethods = "verifyVendorCallsPageAndFilters")
    public void verifyClientCallsPageAndFilters(){
        test = extent.createTest("Verify Client Calls Page and Functionalities");

        try {
            CallsPage callsPage = new CallsPage(driver);

            // Navigate to Calls
            callsPage.navigateToCallsPage();
            Assert.assertTrue(callsPage.isCallsPageDisplayed(), "Client Calls page not displayed");
            test.pass("Client Calls page opened successfully");

            // Click to As Client 
            callsPage.clickOnClientbtn();
            Assert.assertTrue(callsPage.isClientCallsDisplayed(), "Client view not loaded after clicking client button");
            test.pass("Redirected to Client Calls Page");

            // Click "Billed" Filter
            callsPage.clickbilledFilter();
            test.pass("Clicked on Billed filter"); 

            // Click "Un-billed" Filter
            callsPage.clickUnbilledFilter();
            test.pass("Clicked on Unbilled filter");

            // Click "Missed" filter
            callsPage.clickMissedFilter();
            test.pass("Clicked on Missed filter");

            // Click "All" filter
            callsPage.clickAllFilter();
            test.pass("Clicked on All filter");
            

        } catch (Exception e) {
            test.fail("Client Calls page test failed: " + e.getMessage());

            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "clientCallsPageError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Error screenshot capture failed: " + ex.getMessage());
            }
            // ✅ Make test fail
            throw new RuntimeException(e);
        }
    }
}
