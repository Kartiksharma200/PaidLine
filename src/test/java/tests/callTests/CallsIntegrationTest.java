package tests.callTests;

import org.testng.annotations.Test;

import base.BaseTest;
import integration.CallsDataValidator;


public class CallsIntegrationTest extends BaseTest {

    // Replace with real token
    private final String token = "your-auth-token";

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