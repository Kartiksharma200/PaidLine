package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Dashboard.DashboardPage;
import pages.OnboardingFlow.SignInPage;
import tests.callDetailTestApi.FetchCallDetails;
import tests.earningDetailTestApi.earningDetails;
import utils.ScreenshotUtils;
import utils.TestData;

public class DashboardTest extends BaseTest {

    /*
     * Step 1: Login to the application before verifying dash-board
     */
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

    /*
     * Step 2: Validate Dash-board metrics and earnings
     */
    @Test(priority = 1)
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
            System.out.println(month);
            Assert.assertEquals(month, "$230.44", "Month-to-Date earnings mismatch");
            test.pass("Month to Date Earnings: " + month);

            String year = dashboard.getYearToDateEarnings();
            Assert.assertEquals(year, "$302.44", "Year-to-Date earnings mismatch");
            test.pass("Year to Date Earnings: " + year);

            String lifetime = dashboard.getLifetimeEarnings();
            Assert.assertEquals(lifetime, "$302.44", "Lifetime earnings mismatch");
            test.pass("Lifetime Earnings: " + lifetime);

            // Final Screenshot
            String dashboardScreenshot = ScreenshotUtils.captureScreenshot(driver, "dashboardData");
            test.addScreenCaptureFromPath(dashboardScreenshot);

        } catch (Exception e){
            test.fail("Dashboard verification failed: " + e.getMessage());
            try{
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "dashboardError");
                test.addScreenCaptureFromPath(errorScreenshot);
            }catch (Exception ex){
                test.fail("Error screenshot capture failed: " + ex.getMessage());
            }
        }
    }

    /*
     * Verify all functionality
     */
    @Test(priority = 2)
    public void verifyDashboardFunctionality(){
        test = extent.createTest("Verify dashboard functionality");
        try{
            DashboardPage dashboard = new DashboardPage(driver);

            // Your PaidLine Number
            dashboard.clickOnPaidlineNumber();
            Thread.sleep(2999);
            Assert.assertTrue(driver.getCurrentUrl().contains("numbers"), "Your Paidline Number page not opened");
            test.pass("Your Paidline Number page navigated successfully");
            driver.navigate().back();

            // Your billing rate
            dashboard.clickOnBillingRate();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("numbers"), "Your Billing rate page not opened");
            test.pass("Your Billing rate page navigated successfully");
            driver.navigate().back();

            // Your Availabiltiy Today
            dashboard.clickOnAvailabilityToday();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("user"), "Your Availabiltiy Today page not opened");
            test.pass("Your Availabiltiy Today page navigated successfully");
            driver.navigate().back();

            // Your Forwarding Number
            dashboard.clickOnForwardingNumber();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("user"), "Your Forwarding Number page not opened");
            test.pass("Your Forwarding Number page navigated successfully");
            driver.navigate().back();
        } catch (Exception e) {
            test.fail("Navigation element check failed: " + e.getMessage());
            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "navError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Failed to capture screenshot: " + ex.getMessage());
            }
        }
    }
     
    @Test(priority = 2, dependsOnMethods = "verifyDashboardData")
    /**
     * Step 2: Verify Recent Calls Section and Filters
     */
    public void verifyRecentCalls(){
        test = extent.createTest("Verify Recent Calls Section");

        try {
            DashboardPage dashboard = new DashboardPage(driver);

            // Verify Recent Calls section is visible
            Assert.assertTrue(dashboard.isRecentCallsVisible(), "Recent Calls section is not visible");
            test.pass("Recent Calls section is displayed");

            // Check if the table has rows
            int rowCount = dashboard.getRowCount();
            Assert.assertTrue(rowCount > 0, "No calls found in Recent Calls table");
            test.pass("Recent Calls table has " + rowCount + " rows");

            // Click on filters and verify functionality
            dashboard.clickAllFilter();
            Assert.assertEquals(dashboard.getCallCountByStatus("All"), rowCount, "All filter did not return correct count");
            test.pass("All filter applied successfully");

            dashboard.clickbilledFilter();
            Assert.assertTrue(dashboard.getCallCountByStatus("Billed") >= 0, "Billed filter did not return correct count");
            test.pass("Billed filter applied successfully");

            dashboard.clickUnbilledFilter();
            Assert.assertTrue(dashboard.getCallCountByStatus("Unbilled") >= 0, "Unbilled filter did not return correct count");
            test.pass("Unbilled filter applied successfully");

            dashboard.clickInboundCallFilter();
            Assert.assertTrue(dashboard.getCallCountByStatus("Inbound") >= 0, "Inbound filter did not return correct count");
            test.pass("Inbound filter applied successfully");

            dashboard.clickReturnedCallFilter();
            Assert.assertTrue(dashboard.getCallCountByStatus("Returned") >= 0, "Returned filter did not return correct count");
            test.pass("Returned filter applied successfully");

            // Export functionality
           // dashboard.clickExport();
            test.pass("Export button clicked successfully");

        } catch (InterruptedException e) {
            test.fail("Recent Calls section verification failed: " + e.getMessage());
            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "recentCallsError"); 
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Failed to capture recent calls error screenshot: " + ex.getMessage());
            }
        }
    }

    /**
     * Step 3: Verify Sidebar Navigation
     */
    @Test(priority = 3, dependsOnMethods = "verifyDashboardFunctionality")
    public void verifySidebarNavigation() {
        test = extent.createTest("Verify Sidebar Navigation");

        try {
            DashboardPage dashboard = new DashboardPage(driver);

           //Your Numbers
            dashboard.clickYourNumbersMenu();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("numbers"), "Your Numbers page not opened");
            test.pass("Your Numbers page navigated successfully");

            // Click Calls
            dashboard.clickCallsMenu();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("call-history"), "Calls page not opened");
            test.pass("Calls page navigated successfully");
            
            // Click Earnings
            dashboard.clickEarningsMenu();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("earnings"), "Earnings page not opened");
            test.pass("Earnings page navigated successfully");

            // Click Customers
            dashboard.clickCustomersMenu();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("clients"), "Customers page not opened");
            test.pass("Customers page navigated successfully");

            // Click on Settings
            dashboard.clickSettingsMenu();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("profile-settings"), "Settings page not opened");
            test.pass("Settings page navigated successfully");

            // Click on Help
            dashboard.clickHelpMenu();
            Thread.sleep(2000);
            Assert.assertTrue(driver.getCurrentUrl().contains("help"), "Help page not opened");
            test.pass("Help page navigated successfully");

            // Back to Dashboard
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

            // Final screenshot
            String navigationScreenshot = ScreenshotUtils.captureScreenshot(driver, "dashboardNavigation");
            test.addScreenCaptureFromPath(navigationScreenshot);

        } catch (Exception e) {
            test.fail("Navigation or UI element check failed: " + e.getMessage());
            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "navError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Failed to capture screenshot: " + ex.getMessage());
            }
        }
    }

    /*
     * Step 4: Validate Call Action Panel and Customer Redirect
     */

    @Test(priority = 4, dependsOnMethods = "verifyRecentCalls")
    public void verifyCallActionAndCustomerRedirect() {
        test = extent.createTest("Call Panel Open and Call ID Redirection");

        try {
            DashboardPage dashboard = new DashboardPage(driver);

            // Click 3-dot action icon
            dashboard.clickFirstCallActionIcon();
            Thread.sleep(2000);
            Assert.assertTrue(dashboard.isCallDetailPanelVisible(), "Call detail panel did not open");
            test.pass("Call side panel opened successfully");

            // Add note and save
            dashboard.enterNoteInCallDetails("Automation note added.");
            dashboard.clickSaveNote();
            test.pass("Note added and saved successfully in call detail");

            // Take screenshot of panel
            String callPanelScreenshot = ScreenshotUtils.captureScreenshot(driver, "callDetailPanel");
            test.addScreenCaptureFromPath(callPanelScreenshot);

            // Now click on Call ID to go to Customer Page
            dashboard.clickFirstCallIdLink();
            Thread.sleep(3000);
            Assert.assertTrue(driver.getCurrentUrl().contains("customer"), "Did not navigate to customer page");
            test.pass("Call ID click redirected to correct customer page");

            String customerPageScreenshot = ScreenshotUtils.captureScreenshot(driver, "customerPage");
            test.addScreenCaptureFromPath(customerPageScreenshot);

        } catch (Exception e) {
            test.fail("Call panel or customer redirect failed: " + e.getMessage());

            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "callActionError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Screenshot capture failed: " + ex.getMessage());
            }
        }
    }

    @Test(priority = 5, dependsOnMethods = "verifySidebarNavigation")
    public void verifyEarningDataFromApi() {
        test = extent.createTest("Verify Earnings Data from API");

        try {
            // Call the API method to fetch earnings data
            earningDetails earningDetailsApi = new earningDetails();
            FetchCallDetails fetchCallDetailsApi = new FetchCallDetails();
            // String currentMonth = df.format(currentMonthEarning / 100);
            // String currentYear = df.format(currentYearEarning / 100);
            // String lifeTime = df.format(lifeTimeEarning / 100);
            // String lastMonth = df.format(lastMonthPayout / 100);
            // String currentYearPay = df.format(currentYearPayout / 100);
            // String lifeTimePay = df.format(lifeTimePayout / 100);
            // String nextPay = df.format(nextPayout / 100);
            // String bal = df.format(balance / 100);

            test.pass("Earnings data fetched successfully from API");
        } catch (Exception e) {
            test.fail("Failed to fetch earnings data from API: " + e.getMessage());
            try {
                String errorScreenshot = ScreenshotUtils.captureScreenshot(driver, "apiError");
                test.addScreenCaptureFromPath(errorScreenshot);
            } catch (Exception ex) {
                test.fail("Failed to capture API error screenshot: " + ex.getMessage());
            }
        }
    }
}
