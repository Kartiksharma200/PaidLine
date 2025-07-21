package pages.Earnings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class BalancesPage {
    private WebDriver driver;

    public BalancesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Balances')]")
    private WebElement balancesTab;

    @FindBy(xpath = "//div[contains(text(),'USD Balance')]/following-sibling::div")
    private WebElement usdBalance;

    public void goToBalancesTab() {
        balancesTab.click();
    }

    public String getUSDBalance() {
        return usdBalance.getText();
    }
}
