package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ScreenshotUtils;
import utils.TestData;
import utils.WaitUtils;
import pages.OnboardingFlow.SignInPage;
import pages.Setting.SettingPage;




public class SettingTest extends BaseTest {

    /*
     * Scenario: Login with Valid Credentials
     * Expected Result: Redirect to Dashboard
     */
    @Test(priority = 1)
    public void loginPaidLine() {
        test = extent.createTest("Login with Valid Credentials");

        try {
            SignInPage signIn = new SignInPage(driver);
            signIn.login(TestData.validEmail, TestData.validPassword);

            WaitUtils.waitForUrlToContain(driver, "dashboard");

            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard URL not found");

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

    /*
     * Click On the Setting 
     */
    @Test(priority = 2, dependsOnMethods = "loginPaidLine")
    public void openSettingPageTest() throws InterruptedException{
        SettingPage settingPage = new SettingPage(driver);
        Thread.sleep(2000);
        settingPage.openSettingPage();
    }

    @Test(priority = 3, dependsOnMethods = "openSettingPageTest")
    public void verifySettingSidebars() throws Exception {
        test = extent.createTest("Verify Setting Sidebar Options");

        try {
            SettingPage settingPage = new SettingPage(driver);
            Thread.sleep(2000);
            settingPage.openSettingPage(); // Optional if already on settings page
            settingPage.verifySettingPage(); // Verifies all sidebar tabs

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "verifySettingSidebars");
            test.pass("Sidebar options (Profile, Social, Numbers, Payments) verified successfully.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "verifySettingSidebars_Fail");
            test.fail("Sidebar verification failed. Error: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }

    @Test(priority = 4, dependsOnMethods = "verifySettingSidebars")
    public void editProfileInformation() throws Exception {
        test = extent.createTest("Edit Profile Information");

        try {
            SettingPage settingPage = new SettingPage(driver);
            Thread.sleep(2000);
            settingPage.profileBar();                // Navigate to profile tab
            settingPage.profilePersonalInfo();       // Enter edit mode

            settingPage.editPiCompany(TestData.company);
            settingPage.editPiTittle(TestData.tittle);
            settingPage.editPiHeadline(TestData.headline);
            settingPage.editPiDescription(TestData.description);

            settingPage.editPiCheckbox();            // Toggle checkbox
            settingPage.editSave();                  // Save info

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "editProfileInformation");
            test.pass("Profile info edited and saved successfully.")
                .addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, "editProfileInformation_Fail");
            test.fail("Profile info edit failed. Error: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            throw e;
        }
    }
}
