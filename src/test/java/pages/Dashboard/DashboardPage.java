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
    private WebElement paidlineNumber;

    @FindBy(xpath  = "(//*[@class=\"title-20 !font-semibold !text-brand-green\"])[1]")
    @CacheLookup
    private WebElement paidlineNumbertext;

    @FindBy(xpath = "//p[contains(text(),'Your Billing Rate')]")
    @CacheLookup
    private WebElement billingRate;

    @FindBy(xpath = "//p[contains(text(),'Your Availability Today')]")
    @CacheLookup
    private WebElement availabilityToday;

    @FindBy(xpath = "//p[contains(text(),'Your Forwarding Number')]")
    @CacheLookup
    private WebElement forwardingNumber;

    // Earnings Section
    @FindBy(xpath = "//p[contains(text(),'Month to Date:')]")
    @CacheLookup
    private WebElement monthToDate;

    @FindBy(xpath = "//div[contains(text(),'Year to Date:')]/following-sibling::div[1]")
    @CacheLookup
    private WebElement yearToDate;

    @FindBy(xpath = "//div[contains(text(),'Lifetime:')]/following-sibling::div[1]")
    @CacheLookup
    private WebElement lifetime;

    // === Actions ===
    public String getPaidlineNumber() {
        return paidlineNumbertext.getText();
    }

    public String getBillingRate() {
        return billingRate.getText();
    }

    public String getAvailabilityToday() {
        return availabilityToday.getText();
    }

    public String getForwardingNumber() {
        return forwardingNumber.getText();
    }

    public String getMonthToDateEarnings() {
        return monthToDate.getText();
    }

    public String getYearToDateEarnings() {
        return yearToDate.getText();
    }

    public String getLifetimeEarnings() {
        return lifetime.getText();
    }
}
