package pages.Help;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class RaiseTicketPage {

  private WebDriver driver;
  private WebDriverWait wait;

  /*
   * Constructor
   */
  public RaiseTicketPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  /*
   * WebElements (Locators)
   */
  @FindBy(id = "ticketBtn")
  @CacheLookup
  private WebElement raiseticket;

  @FindBy(id = "feedbackBtn")
  @CacheLookup
  private WebElement feedbackbutton;

  @FindBy(xpath = "(//*[@type='checkbox'])[1]")
  @CacheLookup
  private WebElement checkbox1;

  @FindBy(xpath = "(//*[@type='checkbox'])[2]")
  @CacheLookup
  private WebElement checkbox2;

  @FindBy(xpath = "(//*[@type='checkbox'])[3]")
  @CacheLookup
  private WebElement checkbox3;

  @FindBy(xpath = "(//*[@type='checkbox'])[4]")
  @CacheLookup
  private WebElement checkbox4;

  @FindBy(xpath = "(//*[@type='checkbox'])[5]")
  @CacheLookup
  private WebElement checkbox5;

  @FindBy(xpath = "//*[@placeholder='Enter your service request here...']")
  @CacheLookup
  private WebElement servicerequestbox;

  @FindBy(xpath = "//*[@type='submit']")
  @CacheLookup
  private WebElement raiseticketButton;

  /*
   * Action Method
   */

  public void clickOnRaiseTicket() {
    raiseticket.click();
  }

  public void verifyRaiseTicketPage() {
    if (raiseticketButton.isDisplayed()) {
      System.out.println("Verification successfully");
    } else {
      System.out.println("failed to verify");
    }
  }

  public void submitRaiseTicket(String serviceRequestText) throws Exception {
    checkbox1.click();
    checkbox2.click();
    checkbox3.click();
    checkbox4.click();
    checkbox5.click();
    Thread.sleep(2000);
    servicerequestbox.click();
    servicerequestbox.sendKeys(serviceRequestText);
    Thread.sleep(2000);
  }
}
