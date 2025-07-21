package pages.Customers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.List;

public class CustomersPage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customersTab;

    @FindBy(xpath = "//table//tr/td[1]/a")
    List<WebElement> customerIdList;

    @FindBy(xpath = "//table//tr[1]//td[7]//button")
    WebElement firstActionButton;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToCustomers() {
        customersTab.click();
    }

    public void clickFirstCustomerID() {
        customerIdList.get(0).click();
    }

    public void clickFirstCustomerActionIcon() {
        firstActionButton.click();
    }
}
