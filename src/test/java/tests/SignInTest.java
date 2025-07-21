package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import utils.ScreenshotUtils;
import utils.TestData;
import utils.WaitUtils;
import static org.testng.Assert.assertTrue;
import pages.OnboardingFlow.SignInPage;

/**
 * Test class for verifying login scenarios using TestNG, ExtentReports, and screenshot capturing.
 */
public class SignInTest extends BaseTest {

    /**
     * Scenario 1: Login with valid credentials
     * Expected Result: User should be redirected to the dashboard
     */
    @Test(priority = 1)
    public void loginWithValidCredentials() throws Exception {
        test = extent.createTest("Login with Valid Credentials");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login(TestData.validEmail, TestData.validPassword);

            WaitUtils.waitForUrlToContain(driver, "dashboard");

            assertTrue(driver.getCurrentUrl().contains("dashboard"));

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithValidCredentials");
            test.pass("Login successful. Dashboard URL verified.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithValidCredentials_Fail");
            test.fail("Login failed. Error: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 2: Login with invalid credentials
     * Expected Result: User should remain on the login page and see an error
     */
    @Test(priority = 2)
    public void loginWithInvalidCredentials() {
        test = extent.createTest("Login with Invalid Credentials");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login(TestData.invalidEmail, TestData.invalidPassword);

            assertTrue(signIn.isLoginButtonVisible()); // Login button should still be visible (i.e., no redirect)

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithInvalidCredentials");
            test.pass("Invalid login correctly blocked.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithInvalidCredentials_Fail");
            test.fail("Unexpected error: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 3: Login with empty fields
     * Expected Result: Login button remains disabled or no action triggered
     */
    @Test(priority = 3)
    public void loginWithEmptyFields() {
        test = extent.createTest("Login with Empty Fields");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login("", "");

            assertTrue(signIn.isLoginButtonVisible());

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithEmptyFields");
            test.pass("Empty fields handled correctly.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithEmptyFields_Fail");
            test.fail("Error with empty input fields: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 4: Login using SQL injection strings
     * Expected Result: Login should fail
     */
    @Test(priority = 4)
    public void loginWithSQLInjectionInput() {
        test = extent.createTest("Login with SQL Injection Input");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login("' OR '1'='1", "' OR '1'='1");

            assertTrue(signIn.isLoginButtonVisible());

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithSQLInjectionInput");
            test.pass("SQL injection blocked successfully.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithSQLInjectionInput_Fail");
            test.fail("SQL injection test failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 5: Login using XSS script input
     * Expected Result: Login should fail or input sanitized
     */
    @Test(priority = 5)
    public void loginWithXSSInput() {
        test = extent.createTest("Login with XSS Input");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login("<script>alert('XSS')</script>", "test");

            assertTrue(signIn.isLoginButtonVisible());

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithXSSInput");
            test.pass("XSS script input rejected.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithXSSInput_Fail");
            test.fail("XSS input test failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 6: Login with leading/trailing spaces in email
     * Expected Result: Email should be trimmed and login should succeed
     */
    @Test(priority = 6)
    public void loginWithLeadingTrailingSpaces() {
        test = extent.createTest("Login with Leading/Trailing Spaces");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login("  " + TestData.validEmail + "  ", TestData.validPassword);

            WaitUtils.waitForUrlToContain(driver, "dashboard");
            assertTrue(driver.getCurrentUrl().contains("dashboard"));

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithLeadingTrailingSpaces");
            test.pass("Login successful after trimming spaces.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithLeadingTrailingSpaces_Fail");
            test.fail("Failed to handle space-trimmed input: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 7: Login using same email but different password case
     * Expected Result: Login should fail if password is case-sensitive
     */
    @Test(priority = 7)
    public void loginWithCaseSensitivePassword() {
        test = extent.createTest("Login with Case-Sensitive Password");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login(TestData.validEmail, TestData.validPassword.toUpperCase());

            assertTrue(signIn.isLoginButtonVisible());

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithCaseSensitivePassword");
            test.pass("Password case-sensitivity validated.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithCaseSensitivePassword_Fail");
            test.fail("Case-sensitive password check failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 8: Login using very long email and password
     * Expected Result: Login should fail but input should not break UI
     */
    @Test(priority = 8)
    public void loginWithLongStrings() {
        test = extent.createTest("Login with Very Long Strings");

        try {
            SignInPage signIn = new SignInPage(driver);
            String longEmail = "user" + "a".repeat(100) + "@test.com";
            String longPassword = "p@ss" + "1".repeat(100);
            signIn.login(longEmail, longPassword);

            assertTrue(signIn.isLoginButtonVisible());

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithLongStrings");
            test.pass("Handled long input without UI break.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithLongStrings_Fail");
            test.fail("Error with long string input: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 9: Login using special character-only password
     * Expected Result: Login should fail
     */
    @Test(priority = 9)
    public void loginWithSpecialCharactersPassword() {
        test = extent.createTest("Login with Special Characters in Password");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login(TestData.validEmail, "@#%$&*!^~");

            assertTrue(signIn.isLoginButtonVisible());

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithSpecialCharactersPassword");
            test.pass("Special character password handled properly.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "loginWithSpecialCharactersPassword_Fail");
            test.fail("Error during special character login: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 10: Forgot Password Link Functionality
     * Expected Result: Forgot password modal or popup should be displayed
     */
    @Test(priority = 10)
    public void forgotPasswordLinkTest() {
        test = extent.createTest("Forgot Password Link Functionality");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.clickForgotPassword();

            assertTrue(signIn.isResetPasswordPopupVisible());

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "forgotPasswordLinkTest");
            test.pass("Forgot password modal is visible.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "forgotPasswordLinkTest_Fail");
            test.fail("Forgot password test failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }
}
