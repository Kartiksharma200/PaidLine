package pages.YourNumbers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class YourNumPage {

    private WebDriver driver;
    private WebDriverWait wait;

   //Constructor
    
    public YourNumPage(WebDriver driver) { 
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Web elements (locators)
    
    @FindBy(xpath = "//*[@placeholder='youremail@example.com']")
    @CacheLookup
    private WebElement emailField;

    @FindBy(xpath = "//*[@placeholder='Password']")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//*[@class='eyeIcon']")
    private WebElement eyeIcon;

    @FindBy(xpath = "//*[@type='submit']")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(linkText = "Forgot Password?")
    private WebElement forgotPasswordLink;

    @FindBy(linkText = "Your PaidLine Number")
    private WebElement paidlineNumber;

    @FindBy(xpath = "//*[@class='chakra-input css-1bnvg7j']")
    private WebElement callRateInput;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement saveRatesButton;

    @FindBy(xpath = "//p[text()='Your Availability']")
    private WebElement availabilityButton;

    @FindBy(xpath = "(//*[@class=\"dropdownArrow mt-4 \"])[1]")
    private WebElement weekdaydropdown;

    
    @FindBy(xpath = "(//*[@class=\"dropdownArrow mt-4 \"])[2]")
    private WebElement weekenddropdown;

    @FindBy(xpath = "//p[contains(@class,'mb-3 flex h-10 cursor-pointer items-center gap-2 text-nowrap rounded-lg px-3 py-1.5 text-sm tracking-wide bg-brand-green !text-white')]")
    private WebElement callForwarding;


    // Actions
    
    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickEyeIcon() {
        eyeIcon.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickEyeIcon();
        clickLogin();
    }
    
    public void ClickpaidlineNum(){
        wait.until(ExpectedConditions.elementToBeClickable(paidlineNumber));
        paidlineNumber.click();
    }

    public void SetCallRate(int SetRate) {
        wait.until(ExpectedConditions.visibilityOf(callRateInput));
        callRateInput.clear();
        callRateInput.sendKeys(String.valueOf(SetRate));
        wait.until(ExpectedConditions.elementToBeClickable(saveRatesButton));
        saveRatesButton.click();
    }

    public void SetAvailability(){
        wait.until(ExpectedConditions.elementToBeClickable(availabilityButton));
        availabilityButton.click();
       // YourAvailability.click();
       wait.until(ExpectedConditions.elementToBeClickable(weekdaydropdown));
       weekdaydropdown.click();

    }

    public boolean isAvailabilitySet() {
        
        return true;
    }

    public void CallForwarding(){
        wait.until(ExpectedConditions.elementToBeClickable(callForwarding));
        callForwarding.click();
    }

}