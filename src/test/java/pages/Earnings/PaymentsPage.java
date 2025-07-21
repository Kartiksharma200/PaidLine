package pages.Earnings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class PaymentsPage {
    private WebDriver driver;

    public PaymentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Payments')]")
    private WebElement paymentsTab;

    @FindBy(xpath = "//div[contains(text(),'Total Earnings')]/following-sibling::div")
    private WebElement totalEarnings;

    public void goToPaymentsTab() {
        paymentsTab.click();
    }

    public String getTotalEarnings() {
        return totalEarnings.getText();
    }
}
