package pages.Setting;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.*;

public class SettingPage {

  private WebDriver driver;
  private WebDriverWait wait;

  /*
   * Constructor
   */
  public SettingPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  /*
   * Web Elements (Locators)
   */
  @FindBy(xpath = "//body//main//a[6]")
  @CacheLookup
  private WebElement setting;

  /*
   * Side Bars Locators
   */
  @FindBy(id = "profileBtn")
  @CacheLookup
  private WebElement profile;

  @FindBy(id = "socialBtn")
  @CacheLookup
  private WebElement socialAccount;

  @FindBy(id = "manage-numbersBtn")
  @CacheLookup
  private WebElement manageNumbers;

  @FindBy(id = "paymentsBtn")
  @CacheLookup
  private WebElement payments;

  /*
   * Profile Module Locators
   */

  /*
   * Profile Information section Locators
   */
  
  @FindBy(id = "userInfoEditBtn")
  @CacheLookup
  private WebElement piEditButton;

  @FindBy(id = "userInfoSaveBtn")
  @CacheLookup
  private WebElement piSaveButton;

  @FindBy(id = "userInfoCancelBtn")
  @CacheLookup
  private WebElement piCancelButton;

  @FindBy(xpath = "//*[@name='company']")
  @CacheLookup
  private WebElement piCompany;

  @FindBy(xpath = "//*[@name='title']")
  @CacheLookup
  private WebElement piTittle;

  @FindBy(xpath = "//*[@name='headline']")
  @CacheLookup
  private WebElement piHeadline;

  @FindBy(xpath = "//*[@placeholder=\"Description\"]")
  @CacheLookup
  private WebElement piDescription;

  @FindBy(xpath = "//*[@class=\"peer-checked:opacity-100 absolute opacity-0 text-white top-0 left-0 h-5 w-5\"]")
  @CacheLookup
  private WebElement piCheckBox;

  /*
   * Contact Information Section Locators
   */

  @FindBy(id = "personalInfoEditBtn")
  @CacheLookup
  private WebElement ciEditButton;

  @FindBy(id = "personalInfoCancelBtn")
  @CacheLookup
  private WebElement ciCancelButton;

  @FindBy(id = "personalInfoSaveBtn")
  @CacheLookup
  private WebElement ciSaveButton;

  @FindBy(id = "react-select-3-placeholder")
  @CacheLookup
  private WebElement ciCityDropDown;

  @FindBy(id = "field-:r3l:-label")
  @CacheLookup
  private WebElement ciCountry;

  @FindBy(id = "field-:r3m:-label")
  @CacheLookup
  private WebElement ciZipCode;

  /*
   * Other Locators
   */

  @FindBy(id = "editPasswordBtn")
  @CacheLookup
  private WebElement resetPassword;

  @FindBy(id = "cancleSubBtn")
  @CacheLookup
  private WebElement subscriptionCancelBtn;

  /*
   * Action Methods
   */

  public void openSettingPage() {
    setting.click();
  }

  public void verifySettingPage() throws Exception {
    WaitUtils.waitForElementToBeVisible(driver, profile, 10);
    profile.click();
    Thread.sleep(2000);
    WaitUtils.waitForElementToBeVisible(driver, socialAccount, 10);
    socialAccount.click();
    Thread.sleep(2000);
    WaitUtils.waitForElementToBeVisible(driver, manageNumbers, 10);
    manageNumbers.click();
    Thread.sleep(2000);
    WaitUtils.waitForElementToBeVisible(driver, payments, 10);
    payments.click();
    Thread.sleep(2000);
  }

  public void profileBar() {
    profile.click();
  }

  public void profilePersonalInfo() throws InterruptedException {
    piEditButton.click();
    Thread.sleep(3000);
  }

  public void editPiCompany(String company) throws InterruptedException {
    piCompany.click();
    Thread.sleep(2000);
    piCompany.clear();
    piCompany.sendKeys(company);
    Thread.sleep(2000);
  }

  public void editPiTittle(String tittle) throws InterruptedException {
    piTittle.click();
    Thread.sleep(2000);
    piTittle.clear();
    piTittle.sendKeys(tittle);
    Thread.sleep(3000);
  }

  public void editPiHeadline(String headline) throws InterruptedException {
    piHeadline.click();
    Thread.sleep(2000);
    piHeadline.clear();
    piHeadline.sendKeys(headline);
    Thread.sleep(3000);
  }

  public void editPiDescription(String description) throws InterruptedException {
    piDescription.click();
    Thread.sleep(2000);
    piDescription.clear();
    piDescription.sendKeys(description);
    Thread.sleep(2000);
  }

  public void editPiCheckbox() {
    piCheckBox.click();
  }

  public void editSave() {
    piSaveButton.click();
  }

}
