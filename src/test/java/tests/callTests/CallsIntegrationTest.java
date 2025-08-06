package tests.callTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import integration.CallsDataValidator;
import pages.OnboardingFlow.SignInPage;
import utils.ScreenshotUtils;
import utils.TestData;
import utils.WaitUtils;


public class CallsIntegrationTest extends BaseTest {

    // Replace with real token
    private final String token = "https://api-staging.paidline.com/api/call-history/vendor/call-history?page=1&pageSize=5&sortBy=%7B%7D&filter=ALL";

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

    
    @Test
    public void validateCallDataBetweenBackendAndUI() {
        test = extent.createTest("Backend vs UI Call Data Validation");

        try {
            CallsDataValidator validator = new CallsDataValidator(driver, token);
            
            

            validator.validateMissedCalls();
            test.pass("Missed call count matched");

            validator.validateBilledCalls();
            test.pass("Billed call count matched");

            validator.validateUnbilledCalls();
            test.pass("Unbilled call count matched");

        } catch (Exception e) {
            test.fail("Data validation failed: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}