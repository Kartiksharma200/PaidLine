package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.Dashboard.DashboardPage;
import pages.OnboardingFlow.SignInPage;
import utils.ScreenshotUtils;
import utils.TestData;

public class DashboardTest extends BaseTest {

    /**
     * Step 1: Login to the application before verifying dashboard
     */
    @Test(priority = 1)
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

    /**
     * Step 2: Validate Dashboard metrics and earnings
     */
    @Test(priority = 2)
    public void verifyDashboardData() {
        test = extent.createTest("Verify Dashboard Cards and Earnings");

        try {
            DashboardPage dashboard = new DashboardPage(driver);

            // PaidLine Number
            String paidline = dashboard.getPaidlineNumber();
            Assert.assertTrue(paidline.startsWith("("), "PaidLine number format is invalid");
            test.pass("PaidLine Number: " + paidline);

            // Billing Rate
            String rate = dashboard.getBillingRate();
            Assert.assertTrue(rate.contains("$"), "Billing Rate is not in correct format");
            test.pass("Billing Rate: " + rate);

            // Availability
            String availability = dashboard.getAvailabilityToday();
            Assert.assertTrue(availability.contains("AM") || availability.contains("PM"), "Invalid Availability value");
            test.pass("Availability Today: " + availability);

            // Forwarding Number
            String forward = dashboard.getForwardingNumber();
            Assert.assertTrue(forward.startsWith("+"), "Forwarding number format is invalid");
            test.pass("Forwarding Number: " + forward);

            // Earnings Section
            String month = dashboard.getMonthToDateEarnings();
            Assert.assertEquals(month, "$18", "Month-to-Date earnings mismatch");
            test.pass("Month to Date Earnings: " + month);

            String year = dashboard.getYearToDateEarnings();
            Assert.assertEquals(year, "$18", "Year-to-Date earnings mismatch");
            test.pass("Year to Date Earnings: " + year);

            String lifetime = dashboard.getLifetimeEarnings();
            Assert.assertEquals(lifetime, "$18", "Lifetime earnings mismatch");
            test.pass("Lifetime Earnings: " + lifetime);

            // Final Screenshot
            String dashboardScreenshot = ScreenshotUtils.captureScreenshot(driver, "dashboardData");
            test.addScreenCaptureFromPath(dashboardScreenshot);

        } catch (Exception e) {
            test.fail("Dashboard verification failed: " + e.getMessage());

            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "dashboardError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Error screenshot capture failed: " + ex.getMessage());
            }
        }
    }
}
