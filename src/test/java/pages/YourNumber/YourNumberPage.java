 package pages.YourNumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class YourNumberPage {

    private WebDriver driver;
    private WebDriverWait wait;

   //Constructor
    
    public YourNumberPage(WebDriver driver) { 
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

      // Elements
    @FindBy(xpath = "(//*[@href=\"/user/numbers\"])[2]")
    @CacheLookup
    private WebElement yourNumberHeader;

    @FindBy(xpath = "//input[@placeholder='Add per min rate']")
    @CacheLookup
    private WebElement rateInput;

    @FindBy(xpath = "//button[text()='Save']")
    @CacheLookup
    private WebElement saveRateButton;

    @FindBy(xpath = "//label[text()='MON-FRI']/following-sibling::div")
    @CacheLookup
    private WebElement monFriToggle;

    @FindBy(xpath = "//label[text()='SAT-SUN']/following-sibling::div")
    @CacheLookup
    private WebElement satSunToggle;

    @FindBy(xpath = "(//input[@type='time'])[1]")
    @CacheLookup
    private WebElement monFriStartTime;

    @FindBy(xpath = "(//input[@type='time'])[2]")
    @CacheLookup
    private WebElement monFriEndTime;

    @FindBy(xpath = "(//input[@type='time'])[3]")
    @CacheLookup
    private WebElement satSunStartTime;

    @FindBy(xpath = "(//input[@type='time'])[4]")
    @CacheLookup
    private WebElement satSunEndTime;

    @FindBy(xpath = "//input[contains(@value,'+91')]")
    @CacheLookup
    private WebElement forwardingNumberField;

    @FindBy(xpath = "//a[contains(text(),'Manage Numbers')]")
    @CacheLookup
    private WebElement manageNumbersLink;

    @FindBy(xpath = "//select")
    @CacheLookup
    private WebElement whisperVoiceDropdown;

    @FindBy(xpath = "//textarea")
    @CacheLookup
    private WebElement defaultCallNotification;

    @FindBy(xpath = "//div[text()='Active']/preceding-sibling::div/input[@type='checkbox']")
    @CacheLookup
    private WebElement activeToggle;

    // === Actions ===
    
    // Click on the Your Number header to navigate to the page
    public void clickOnYourNumberHeader() {
        wait.until(ExpectedConditions.visibilityOf(yourNumberHeader));
        yourNumberHeader.click();
    }

    // Check if the Your Number header is visible
    public boolean isYourNumberHeaderVisible() {
        return yourNumberHeader.isDisplayed();
    }

    // Set the call rate in the input field
    public void setCallRate(String rate) {
        rateInput.clear();
        rateInput.sendKeys(rate);
    }

    // Click the Save button for the call rate
    public void clickSaveRate() {
        saveRateButton.click();
    }

    // Toggle the availability for Monday to Friday and Saturday to Sunday
    public void toggleMonFri() {
        monFriToggle.click();
    }

    // Toggle the availability for Saturday and Sunday
    public void toggleSatSun() {
        satSunToggle.click();
    }

    // Set the availability times for Monday to Friday and Saturday to Sunday
    public void setAvailabilityTimes(String start1, String end1, String start2, String end2) {
        monFriStartTime.sendKeys(start1);
        monFriEndTime.sendKeys(end1);
        satSunStartTime.sendKeys(start2);
        satSunEndTime.sendKeys(end2);
    }

    // Get the forwarding number from the input field
    public String getForwardingNumber() {
        return forwardingNumberField.getAttribute("value");
    }

    // Click the Manage Numbers link
    public void clickManageNumbers() {
        manageNumbersLink.click();
    }

    // Select a whisper voice from the dropdown
    public void selectWhisperVoice(String voice) {
        Select dropdown = new Select(whisperVoiceDropdown);
        dropdown.selectByVisibleText(voice);
    }

    // Update the default call notification message
    public void updateCallNotification(String message) {
        defaultCallNotification.clear();
        defaultCallNotification.sendKeys(message);
    }

    // Toggle the active status of the number
    public void toggleActiveStatus() {
        activeToggle.click();
    }

    // Check if the active toggle is selected
    public boolean isActive() {
        return activeToggle.isSelected();
    }

}