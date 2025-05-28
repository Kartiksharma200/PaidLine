package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	private WebDriver driver;
	
	//LOCATORS
	
	@FindBy(xpath = "(//*[@href=\"/user/numbers\"])[2]")
	WebElement dashboard_your_paidline_number;
	
	@FindBy(xpath = "//*[@href=\"/user/numbers?tab=Call+Rate&scrollTo=callRates\"]")
	WebElement dashboard_your_billing_rate;
	
	@FindBy(xpath = "//*[@href=\"/user/numbers?tab=Availability&scrollTo=callForwarding\"]")
	WebElement dashboard_your_availibity_today;
	
	@FindBy(xpath = "//*[@href=\"/user/numbers?tab=Call+Forwarding&scrollTo=callForwarding\"]")
	WebElement dashboard_your_forwarding_number;
	
	@FindBy(xpath = "(//*[@type=\"button\"])[3]")
	WebElement your_earning_dropdown;
	
	@FindBy(xpath = "(//*[@type=\"button\"])[2]")
	WebElement your_earning_view_more;
	
	//CONSTRUCTOR
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//METHODS
	
	public void yourPaidlineNumber() {
		dashboard_your_paidline_number.click();
	}
	
	public void yourBillingRate() {
		dashboard_your_billing_rate.click();
	}

	public void yourAvailibilityToday() {
		dashboard_your_availibity_today.click();
	}
	
	public void yourForwardingNumber() {
		dashboard_your_forwarding_number.click();
	}
}
