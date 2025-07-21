package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.Customers.*;
import utils.ScreenshotUtils;

import static org.testng.Assert.*;

public class CustomersTest extends BaseTest {

    @Test(priority = 1)
    public void verifyCustomerDetailsAndSidebar() {
        test = extent.createTest("Verify Customer Details and Action Sidebar");

        CustomersPage customersPage = new CustomersPage(driver);
        CustomerDetailsPage detailsPage = new CustomerDetailsPage(driver);

        try {
            // Navigate to Customers tab
            customersPage.navigateToCustomers();
            ScreenshotUtils.captureScreenshot(driver, "CustomersPage");

            // Click on first customer ID
            customersPage.clickFirstCustomerID();
            ScreenshotUtils.captureScreenshot(driver, "CustomerDetailsPage");

            // Validate details
            assertTrue(detailsPage.getTotalCallsText().contains("Calls"));
            assertTrue(detailsPage.getTotalRevenueText().contains("Generated"));
            assertNotNull(detailsPage.getFirstCallStatus());

            // Go back and test Action icon
            driver.navigate().back();
            customersPage.clickFirstCustomerActionIcon();
            ScreenshotUtils.captureScreenshot(driver, "CustomerSidebar");

            test.pass("Customer details and action sidebar verified successfully.");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            ScreenshotUtils.captureScreenshot(driver, "Error");
            fail(e.getMessage());
        }
    }
}
