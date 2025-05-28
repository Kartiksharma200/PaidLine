package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
   private WebDriver driver;
	
   @FindBy(xpath = "//*[@placeholder=\"Jordan\"]")
   WebElement signup_first_name;
   
   @FindBy(xpath = "//*[@placeholder=\"Doe\"]")
   WebElement signup_last_name;
   
   @FindBy(xpath = "//*[@placeholder=\"Email\"]")
   WebElement signup_email;

   @FindBy(xpath = "//*[@placeholder=\"Password\"]")
   WebElement signup_password;

   @FindBy(xpath = "//*[@class=\"eyeIcon\"]")
   WebElement signup_password_eye;

   @FindBy(xpath = "//*[@type=\"submit\"]")
   WebElement signup_submit_btn;

   
   public SignupPage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }

   public void completeSignUp(String first, String last, String email, String pass) {
	   signup_first_name.sendKeys(first);
	   signup_last_name.sendKeys(last);
	   signup_email.sendKeys(email);
	   signup_password.sendKeys(pass);
	   signup_password_eye.click();
	   signup_submit_btn.click();
   }
}
