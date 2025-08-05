package integration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Calls.CallsPage;

public class CallsDataValidator {

    private final WebDriver driver;
    private final CallsPage callsPage;
    private final String token;

    public CallsDataValidator(WebDriver driver, String token) {
        this.driver = driver;
        this.callsPage = new CallsPage(driver);
        this.token = token;
    }

    public void validateMissedCalls() throws InterruptedException {
        callsPage.clickMissedFilter();
        int uiCount = callsPage.getRowCount();
        int apiCount = BackendClient.getCallCountByStatus(token, "Missed");
        System.out.println("UI Missed: " + uiCount + ", API Missed: " + apiCount);
        Assert.assertEquals(uiCount, apiCount, "Mismatch in missed call count");
    }

    public void validateBilledCalls() throws InterruptedException {
        callsPage.clickbilledFilter();
        int uiCount = callsPage.getRowCount();
        int apiCount = BackendClient.getCallCountByStatus(token, "Billed");
        System.out.println("UI Billed: " + uiCount + ", API Billed: " + apiCount);
        Assert.assertEquals(uiCount, apiCount, "Mismatch in billed call count");
    }

    public void validateUnbilledCalls() throws InterruptedException {
        callsPage.clickUnbilledFilter();
        int uiCount = callsPage.getRowCount();
        int apiCount = BackendClient.getCallCountByStatus(token, "Unbilled");
        System.out.println("UI Unbilled: " + uiCount + ", API Unbilled: " + apiCount);
        Assert.assertEquals(uiCount, apiCount, "Mismatch in unbilled call count");
    }
}
