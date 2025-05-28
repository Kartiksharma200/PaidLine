package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobjects.SignupPage;
import com.utils.DriverManager;

public class SignupFlow {
	
	private WebDriver driver;
	private SignupPage signup;
	
	@BeforeTest
	public void setup() {
		driver = DriverManager.getDriver();
		signup = new SignupPage(driver);
		driver.get("https://staging.paidline.com/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test
	public void signUp() {
		signup.completeSignUp("Kartik", "Sharma", "Helloworld@gmail.com", "Password@123");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
