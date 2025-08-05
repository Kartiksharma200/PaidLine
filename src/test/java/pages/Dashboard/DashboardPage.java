package pages.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Dashboard Cards
    @FindBy(xpath = "//p[contains(text(),'Your PaidLine Number')]")
    @CacheLookup
    private WebElement paidlineNumber; // Your PaidLine Number box

    @FindBy(xpath = "(//p[contains(text(),'(')])[1]")
    @CacheLookup
    private WebElement paidlineNumberValue; // Actual PaidLine Number fetch by "()"

    @FindBy(xpath = "//p[contains(text(),'Your Billing Rate')]")
    @CacheLookup
    private WebElement billingRate; //Billing rate box

    @FindBy(xpath = "(//p[contains(text(),'$')])[1]")
    @CacheLookup
    private WebElement billingRateValue; // Actual Billing Rate fetch

    @FindBy(xpath = "//p[contains(text(),'Your Availability Today')]")
    @CacheLookup
    private WebElement availabilityToday; // Availability box

    @FindBy(xpath = "(//span[contains(text(),'PM')])[1]")
    @CacheLookup
    private WebElement availabilityTodayValue; // Availability data fetch

    @FindBy(xpath = "//p[contains(text(),'Your Forwarding Number')]")
    @CacheLookup
    private WebElement forwardingNumber;

    @FindBy(xpath = "//p[contains(text(),'+91')]")
    @CacheLookup
    private WebElement forwardingNumberValue;

    // Earnings Section
    @FindBy(xpath = "//p[contains(text(),'Month to Date:')]")
    @CacheLookup
    private WebElement monthToDate;

    @FindBy(xpath = "(//p[contains(text(),'$')])[2]")
    @CacheLookup
    private WebElement monthToDateValue;

    @FindBy(xpath = "//div[contains(text(),'Year to Date:')]/following-sibling::div[1]")
    @CacheLookup
    private WebElement yearToDate;

    @FindBy(xpath = "(//p[contains(text(),'$')])[3]")
    @CacheLookup
    private WebElement yearToDateValue;

    @FindBy(xpath = "//div[contains(text(),'Lifetime:')]/following-sibling::div[1]")
    @CacheLookup
    private WebElement lifetime;

    @FindBy(xpath = "(//p[contains(text(),'$')])[4]")
    @CacheLookup
    private WebElement lifetimeValue;

    // Additional Elements for Sidebar & Calls Section
    @FindBy(xpath = "//span[text()='Calls']/parent::a")
    @CacheLookup
    private WebElement callsMenu;

    @FindBy(xpath = "//span[text()='Customers']/parent::a")
    @CacheLookup
    private WebElement customersMenu;

    @FindBy(xpath = "//span[text()='Earnings']/parent::a")
    @CacheLookup
    private WebElement earningsMenu;

    @FindBy(xpath = "//h2[contains(text(),'Your Recent Calls')]")
    @CacheLookup
    private WebElement recentCallsHeader;

    @FindBy(xpath = "//table//tr[1]/td[1]/a")
    @CacheLookup
    private WebElement firstCallId;

    @FindBy(xpath = "//canvas | //div[contains(@class,'recharts')]")
    @CacheLookup
    private WebElement earningsGraph;

    // Call Actions
    @FindBy(xpath = "(//table//button[contains(@class, 'dots')])[1]")
    @CacheLookup
    private WebElement firstCallActionIcon;

    @FindBy(xpath = "//div[contains(@class, 'sidepanel')]")
    @CacheLookup
    private WebElement callDetailsPanel;

    @FindBy(xpath = "//textarea[@placeholder='Write a new call note here.']")
    @CacheLookup
    private WebElement addNoteTextArea;

    @FindBy(xpath = "//button[text()='Save']")
    @CacheLookup
    private WebElement saveNoteButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    @CacheLookup
    private WebElement cancelNoteButton;

    // Call ID link to redirect to customer
    @FindBy(xpath = "(//table//tr[1]/td[1]/a)")
    @CacheLookup
    private WebElement firstCallIdLink;

    // === Actions ===
    public String getPaidlineNumber() {
        return paidlineNumberValue.getText();
    }

    public void clickOnPaidlineNumber(){
        paidlineNumber.click();
    }

    public String getBillingRate() {
        return billingRateValue.getText();
    }

    public void clickOnBillingRate(){
        billingRate.click();
    }

    public String getAvailabilityToday() {
        return availabilityTodayValue.getText();
    }

    public void clickOnAvailabilityToday(){
        availabilityToday.click();
    }

    public String getForwardingNumber() {
        return forwardingNumberValue.getText();
    }

    public void clickOnForwardingNumber(){
        forwardingNumber.click();
    }

    public String getMonthToDateEarnings() {
        return monthToDateValue.getText();
    }

    public String getYearToDateEarnings() {
        return yearToDateValue.getText();
    }

    public String getLifetimeEarnings() {
        return lifetimeValue.getText();
    }

    // Actions
    public void clickCallsMenu() {
        callsMenu.click();
    }

    public void clickCustomersMenu() {
        customersMenu.click();
    }

    public void clickEarningsMenu() {
        earningsMenu.click();
    }

    public boolean isEarningsGraphVisible() {
        return earningsGraph.isDisplayed();
    }

    public boolean isRecentCallsVisible() {
        return recentCallsHeader.isDisplayed() && firstCallId.isDisplayed();
    }

    // Action methods
    public void clickFirstCallActionIcon() {
        firstCallActionIcon.click();
    }

    public boolean isCallDetailPanelVisible() {
        return callDetailsPanel.isDisplayed();
    }

    public void enterNoteInCallDetails(String note) {
        addNoteTextArea.clear();
        addNoteTextArea.sendKeys(note);
    }

    public void clickSaveNote() {
        saveNoteButton.click();
    }

    public void clickFirstCallIdLink() {
        firstCallIdLink.click();
    }

}
