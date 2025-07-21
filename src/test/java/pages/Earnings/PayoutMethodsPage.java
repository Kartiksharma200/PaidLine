package pages.Earnings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class PayoutMethodsPage {
    private WebDriver driver;

    public PayoutMethodsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Payout Methods')]")
    private WebElement payoutMethodsTab;

    @FindBy(xpath = "//strong[text()='Active Bank Account']")
    private WebElement activeBankText;

    public void goToPayoutMethodsTab() {
        payoutMethodsTab.click();
    }

    public boolean isBankAccountVisible() {
        return activeBankText.isDisplayed();
    }
}
