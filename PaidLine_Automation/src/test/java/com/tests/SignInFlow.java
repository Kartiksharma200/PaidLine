package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.SignInPage;
import com.utils.DriverManager;

public class SignInFlow {
	
	private WebDriver driver;	
	private SignInPage signin;
	
	@BeforeTest
	public void setup() {
		driver = DriverManager.getDriver();
		signin = new SignInPage(driver);
		driver.get("https://staging.paidline.com/signin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	
	@Test
	public void login() throws InterruptedException {
		signin.signin("100200kartik@gmail.com", "Test@123");
		Thread.sleep(10000);
	}
	
	public void dashboard() {
		
	}
	
    @AfterTest
	public void teardown() {
		driver.quit();
	}
}
