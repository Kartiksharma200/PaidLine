package pages.Earnings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class EarningsDashboardPage {
    private WebDriver driver;

    public EarningsDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Dashboard')]")
    private WebElement dashboardTab;

    @FindBy(xpath = "//div[contains(text(),\"This Month’s Payout\")]/following-sibling::div")
    private WebElement thisMonthPayout;

    @FindBy(xpath = "//div[contains(text(),\"Next Month’s Expected Payout\")]/following-sibling::div")
    private WebElement nextMonthPayout;

    public void goToDashboardTab() {
        dashboardTab.click();
    }

    public String getThisMonthPayout() {
        return thisMonthPayout.getText();
    }

    public String getNextMonthPayout() {
        return nextMonthPayout.getText();
    }
}
