package pages.Customers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CustomerDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Total Calls')]")
    WebElement totalCallsBox;

    @FindBy(xpath = "//h2[contains(text(),'Generated')]")
    WebElement totalRevenueBox;

    @FindBy(xpath = "//table//tr[1]/td[2]")
    WebElement firstCallStatus;

    @FindBy(xpath = "//table//tr[1]/td[4]")
    WebElement firstCallDuration;

    public CustomerDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTotalCallsText() {
        return totalCallsBox.getText();
    }

    public String getTotalRevenueText() {
        return totalRevenueBox.getText();
    }

    public String getFirstCallStatus() {
        return firstCallStatus.getText();
    }

    public String getFirstCallDuration() {
        return firstCallDuration.getText();
    }
}
