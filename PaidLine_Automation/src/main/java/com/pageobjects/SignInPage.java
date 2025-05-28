package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	private WebDriver driver;
	
	//LOCATORS
	
	@FindBy(xpath = "//*[@placeholder=\"youremail@example.com\"]")
	WebElement signin_email;
	
    @FindBy(xpath = "//*[@placeholder=\"Password\"]")
    WebElement signin_password;
    
    @FindBy(xpath = "//*[@class=\"eyeIcon\"]")
    WebElement signin_password_eye;
    
    @FindBy(xpath = "//*[@type=\"submit\"]")
    WebElement sigin_submit_btn;
    
    //CONSTRUCTOR
    
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    //METHODS
    
    public void signin(String email, String pass) {
    	signin_email.sendKeys(email);
    	signin_password.sendKeys(pass);
    	signin_password_eye.click();
    	sigin_submit_btn.click();
    }
}
