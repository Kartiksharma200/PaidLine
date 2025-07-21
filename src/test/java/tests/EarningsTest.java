package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.OnboardingFlow.SignInPage;
import pages.Earnings.*;
import utils.ScreenshotUtils;
import utils.TestData;

public class EarningsTest extends BaseTest {

    @Test(priority = 1)
    public void loginToPaidlineApp() {
        test = extent.createTest("Login for Earnings Section");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.enterEmail(TestData.validEmail);
            signIn.enterPassword(TestData.validPassword);
            signIn.clickLogin();

            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
            test.pass("Login successful");
            test.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(driver, "loginSuccess"));

        } catch (Exception e) {
            test.fail("Login failed: " + e.getMessage());
            try {
                test.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(driver, "loginError"));
            } catch (Exception ex) {
                test.fail("Screenshot failed: " + ex.getMessage());
            }
        }
    }

    @Test(priority = 2)
    public void verifyEarningsTabs() {
        test = extent.createTest("Verify All Earnings Tabs and Data");

        try {
            // Dashboard Tab
            EarningsDashboardPage dashboard = new EarningsDashboardPage(driver);
            dashboard.goToDashboardTab();
            Assert.assertTrue(dashboard.getThisMonthPayout().contains("$"));
            test.pass("Dashboard Tab Verified");
            test.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(driver, "earningsDashboard"));

            // Payout Methods
            PayoutMethodsPage payoutMethods = new PayoutMethodsPage(driver);
            payoutMethods.goToPayoutMethodsTab();
            Assert.assertTrue(payoutMethods.isBankAccountVisible());
            test.pass("Payout Methods Verified");
            test.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(driver, "payoutMethods"));

            // Payments Tab
            PaymentsPage payments = new PaymentsPage(driver);
            payments.goToPaymentsTab();
            Assert.assertTrue(payments.getTotalEarnings().contains("$"));
            test.pass("Payments Tab Verified");
            test.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(driver, "paymentsTab"));

            // Balances Tab
            BalancesPage balances = new BalancesPage(driver);
            balances.goToBalancesTab();
            Assert.assertTrue(balances.getUSDBalance().contains("$"));
            test.pass("Balances Tab Verified");
            test.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(driver, "balancesTab"));

        } catch (Exception e) {
            test.fail("Earnings tabs verification failed: " + e.getMessage());
            try {
                test.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(driver, "earningsError"));
            } catch (Exception ex) {
                test.fail("Screenshot error: " + ex.getMessage());
            }
        }
    }
}
