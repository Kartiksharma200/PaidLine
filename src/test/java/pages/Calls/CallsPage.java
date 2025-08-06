package pages.Calls;

import java.time.Duration;
import java.util.List;

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

    @FindBy(xpath = "//button[text()='Billed']")
    @CacheLookup
    private WebElement billedFilterBtn;

    @FindBy(xpath = "//button[text()='Unbilled']")
    @CacheLookup
    private WebElement unbilledFilterBtn;

    @FindBy(xpath = "//button[text()='Missed']")
    @CacheLookup
    private WebElement missedFilterBtn;

    // Selector for All rows in table
    @FindBy(xpath = "")
    @CacheLookup
    private WebElement callRows;
    
    // Export Button
    @FindBy(xpath = "//span[contains(text(),'Export')]")
    @CacheLookup
    private WebElement exportBtn;
    
    // As Client
    @FindBy(xpath = "//button[contains(text(),'As Client')]")
    @CacheLookup
    private WebElement clientBtn;

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

    // == Filters ==
    public void clickAllFilter() throws InterruptedException {
        allFilterBtn.click();
        Thread.sleep(2000);
    }

    public void clickbilledFilter() throws InterruptedException {
        billedFilterBtn.click();
        Thread.sleep(2000);
    }

      public void clickUnbilledFilter() throws InterruptedException {
        unbilledFilterBtn.click();
        Thread.sleep(2000);
    }

    public void clickMissedFilter() throws InterruptedException {
        missedFilterBtn.click();
        Thread.sleep(2000);
    }
    
    // == Export Dowload == 
    public void clickExport() throws InterruptedException {
        exportBtn.click();
        Thread.sleep(3000);
    }
    
    // == As Client ==
    public void clickOnClientbtn(){
        clientBtn.click();
    }

    public void clickPageTwo(){
        pageTwoBtn.click();
    }

    public void clickNextPage(){
        nextPageBtn.click();
    }

    public int getTableRowCount(){
        return tableRows.size() - 1; // exclude header row
    }

        public boolean isClientCallsDisplayed(){
    try {
        WebElement header = driver.findElement(By.xpath("//h5[contains(text(),'Your Call History')]"));  // example
        return header.isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

   // Returns count of rows in current view
    public int getRowCount() {
        List<WebElement> rows = driver.findElements((By) callRows);
        return rows.size();
    }

    // Returns count of rows by visible status label
    public int getCallCountByStatus(String status) {
        return driver.findElements(By.xpath("//td[contains(text(),'" + status + "')]")).size();
    }


}
