package pages.Help;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeedbackPage {

  private WebDriver driver;
  private WebDriverWait wait;

  /*
   * Constructor
   */
  public FeedbackPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  /*
   * WebElements (Locators)
   */

  @FindBy(xpath = "//*[@class=\"heading-24 mb-4\"]")
  @CacheLookup
  private WebElement helptext;

  @FindBy(xpath = "//*[@href=\"/user/help\"]")
  @CacheLookup
  private WebElement sidebarhelp;

  @FindBy(id = "feedbackBtn")
  @CacheLookup
  private WebElement feedbackbutton;

  @FindBy(xpath = "(//*[@class='chakra-radio__control css-1g1ntg'])[1]")
  @CacheLookup
  private WebElement excellent;

  @FindBy(xpath = "(//*[@class='chakra-radio__control css-1g1ntg'])[2]")
  @CacheLookup
  private WebElement verygood;

  @FindBy(xpath = "(//*[@class='chakra-radio__control css-1g1ntg'])[3]")
  @CacheLookup
  private WebElement good;

  @FindBy(xpath = "(//*[@class='chakra-radio__control css-1g1ntg'])[4]")
  @CacheLookup
  private WebElement average;

  @FindBy(xpath = "(//*[@class='chakra-radio__control css-1g1ntg'])[5]")
  @CacheLookup
  private WebElement poor;

  @FindBy(xpath = "(//*[@name='description'])[2]")
  @CacheLookup
  private WebElement description;

  @FindBy(xpath = "//*[@type='submit']")
  @CacheLookup
  private WebElement submitbutton;

  /*
   * Action Method
   */
  public void openHelpPage() throws InterruptedException{
    sidebarhelp.click();
    Thread.sleep(2000);
  }

  public void verifyHelpPage() {
    if (helptext.isDisplayed()) {
      System.out.println("Successful launch help page");
    } else {
      System.out.println("Failed to verify help page");
    }
  }

  public void submitFeedback(String feedbacktext) throws Exception {
    feedbackbutton.click();
    Thread.sleep(2000);
    verygood.click();
    description.sendKeys(feedbacktext);
    Thread.sleep(2000);
    submitbutton.click();
  }

  public void verifyFeedbackSuccessfullySubmit() {

  }

}
