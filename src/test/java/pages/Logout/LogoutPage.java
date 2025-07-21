package pages.Logout;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LogoutPage {

private WebDriver driver;
private WebDriverWait wait;

/*
 * Constructor
 */
public LogoutPage(WebDriver driver){
this.driver = driver;
this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
PageFactory.initElements(driver, this);
}

/*
 * WebElements (Locators) 
 */
@FindBy(xpath="//*[@class='cursor-pointer text-xs text-[#428D59]'']")
@CacheLookup
private WebElement signout;
 
/*
 * Action Method
 */

 public void signout() throws Exception{
  signout.click();
  Thread.sleep(3000);
 }

public void verifySignOut() {
    String expectedURL = "https://staging.paidline.com/signin";
    String actualURL = driver.getCurrentUrl(); // Get the current URL from browser

    if (actualURL.equals(expectedURL)) {
        System.out.println("Sign out successful. Redirected to Sign-In page.");
    } else {
        System.out.println("Sign out failed. Expected URL: " + expectedURL + ", but got: " + actualURL);
    }
}
}
