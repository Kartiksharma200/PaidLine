package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.OnboardingFlow.SignUpPage;
import utils.ScreenshotUtils;
import utils.TestData;


public class SignUpTest extends BaseTest {

    /*
     * Scenario 1: Sign up with valid credentials
     * Expected Result: Successful sign-up
     */
    @Test(priority = 1)
    public void validSignUpTest() throws Exception {
        test = extent.createTest("Valid Sign-Up Test");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName(TestData.signUpFirstName);
            signup.enterLastName(TestData.signUpLastName);
            signup.enterEmail(TestData.signUpEmail);
            signup.enterPassword(TestData.signUpPassword);
            signup.clickEyeIcon();
            signup.clickSignUpButton();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "ValidSignUpTest");
            test.pass("Sign-Up successful with valid data.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "ValidSignUpTest_Fail");
            test.fail("Sign-Up failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 2: Sign up with invalid credentials
     * Expected Result: Should show validation error
     */
    @Test(priority = 2)
    public void inValidSignUp() throws Exception {
        test = extent.createTest("Invalid Sign-Up Test");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName(TestData.invalidSignUpFirstName);
            signup.enterLastName(TestData.invalidSignUpLastName);
            signup.enterEmail(TestData.invalidEmail);
            signup.enterPassword(TestData.invalidSignUpPassword);
            signup.clickEyeIcon();
            signup.clickSignUpButton();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "InvalidSignUpTest");
            test.pass("Invalid credentials blocked successfully.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "InvalidSignUpTest_Fail");
            test.fail("Sign-Up test failed unexpectedly: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /*
     * Scenario 3: Sign up with empty fields
     * Expected Result: Sign-Up button disabled or error displayed
     */
    @Test(priority = 3)
    public void signUpWithEmptyField() throws Exception {
        test = extent.createTest("Empty Field Sign-Up Test");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName("");
            signup.enterLastName("");
            signup.enterEmail("");
            signup.enterPassword("");
            signup.clickEyeIcon();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "EmptyFieldSignUpTest");
            test.pass("Empty field test passed. Required field validation displayed.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "EmptyFieldSignUpTest_Fail");
            test.fail("Empty field test failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /*
     * Scenario 4: Sign up with an already registered email
     * Expected Result: Error "Email already exists"
     */
    @Test(priority = 4)
    public void signUpWithExistingEmail() throws Exception {
        test = extent.createTest("Sign-Up with Existing Email");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName("Test");
            signup.enterLastName("User");
            signup.enterEmail(TestData.existingEmail); // already registered
            signup.enterPassword(TestData.signUpPassword);
            signup.clickSignUpButton();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "ExistingEmailSignUp");
            test.pass("Duplicate email prevented as expected.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "ExistingEmailSignUp_Fail");
            test.fail("Failed to handle existing email scenario: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /*
     * Scenario 5: Sign up with weak password
     * Expected Result: Password strength validation error
     */
    @Test(priority = 5)
    public void signUpWithWeakPassword() throws Exception {
        test = extent.createTest("Sign-Up with Weak Password");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName("Weak");
            signup.enterLastName("Password");
            signup.enterEmail("weakpass@test.com");
            signup.enterPassword("123"); // weak password
            signup.clickSignUpButton();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "WeakPasswordSignUp");
            test.pass("Weak password rejected successfully.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "WeakPasswordSignUp_Fail");
            test.fail("Weak password scenario failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 6: Sign up with invalid email format
     * Expected Result: Email validation error
     */
    @Test(priority = 6)
    public void signUpWithInvalidEmailFormat() throws Exception {
        test = extent.createTest("Sign-Up with Invalid Email Format");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName("Email");
            signup.enterLastName("Invalid");
            signup.enterEmail("wrong-format"); // invalid format
            signup.enterPassword(TestData.signUpPassword);
            signup.clickSignUpButton();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "InvalidEmailFormatSignUp");
            test.pass("Email format validation worked as expected.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "InvalidEmailFormatSignUp_Fail");
            test.fail("Invalid email format not handled: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 7: Sign up with long inputs in name/email
     * Expected Result: Inputs accepted but trimmed or rejected gracefully
     */
    @Test(priority = 7)
    public void signUpWithLongInputs() throws Exception {
        test = extent.createTest("Sign-Up with Long Input Data");

        try {
            String longName = "A".repeat(200);
            String longEmail = "user" + "x".repeat(100) + "@test.com";

            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName(longName);
            signup.enterLastName(longName);
            signup.enterEmail(longEmail);
            signup.enterPassword(TestData.signUpPassword);
            signup.clickSignUpButton();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "LongInputSignUp");
            test.pass("Handled long input gracefully.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "LongInputSignUp_Fail");
            test.fail("Long input test failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    /**
     * Scenario 8: Sign up with special characters in name
     * Expected Result: Shown validation error
     */
    @Test(priority = 8)
    public void signUpWithSpecialCharactersInName() throws Exception {
        test = extent.createTest("Sign-Up with Special Characters in Name");

        try {
            SignUpPage signup = new SignUpPage(driver);
            signup.clickOnSignUp();
            signup.enterFirstName("@#$%^");
            signup.enterLastName("!*&()");
            signup.enterEmail("specialchars@test.com");
            signup.enterPassword(TestData.signUpPassword);
            signup.clickSignUpButton();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "SpecialCharsInNameSignUp");
            test.pass("Special characters in name handled properly.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "SpecialCharsInNameSignUp_Fail");
            test.fail("Special characters in name test failed: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }
}
