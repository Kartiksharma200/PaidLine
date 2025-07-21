package pages.Calls;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CallsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Sidebar Navigation
    @FindBy(xpath = "//span[text()='Calls']/ancestor::a")
    @CacheLookup
    private WebElement callsMenu;

    // Page title
    @FindBy(xpath = "//h5[contains(text(),'Your Call History')]")
    @CacheLookup
    private WebElement callHistoryHeader;

    // Filter Buttons
    @FindBy(xpath = "//button[text()='All']")
    @CacheLookup
    private WebElement allFilterBtn;

    @FindBy(xpath = "//button[text()='Completed']")
    @CacheLookup
    private WebElement completedFilterBtn;

    @FindBy(xpath = "//button[text()='Missed']")
    @CacheLookup
    private WebElement missedFilterBtn;

    // Export Button
    @FindBy(xpath = "//button[contains(text(),'Export')]")
    @CacheLookup
    private WebElement exportBtn;

    // Pagination Controls
    @FindBy(xpath = "//button[text()='2']")
    @CacheLookup
    private WebElement pageTwoBtn;

    @FindBy(xpath = "//button[text()='Next']")
    @CacheLookup
    private WebElement nextPageBtn;

    // Table rows
    @FindBy(xpath = "//table//tr")
    @CacheLookup
    private java.util.List<WebElement> tableRows;

    // === Actions ===

    public void navigateToCallsPage() {
        callsMenu.click();
    }

    public boolean isCallsPageDisplayed() {
        return callHistoryHeader.isDisplayed();
    }

    public void clickAllFilter() {
        allFilterBtn.click();
    }

    public void clickCompletedFilter() {
        completedFilterBtn.click();
    }

    public void clickMissedFilter() {
        missedFilterBtn.click();
    }

    public void clickExport() {
        exportBtn.click();
    }

    public void clickPageTwo() {
        pageTwoBtn.click();
    }

    public void clickNextPage() {
        nextPageBtn.click();
    }

    public int getTableRowCount() {
        return tableRows.size() - 1; // exclude header row
    }
}
