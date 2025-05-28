package DEMO;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFlow {
	
	public static void main(String[] args) {
		WebDriver driver;
		
		driver = new ChromeDriver();
		driver.get("https://staging.paidline.com/signin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement verifyURL = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		if(verifyURL.isDisplayed()) {
			System.out.println("<---------Launch right URl------->");
		}else {
			System.out.println("<---------Failed to verify URL---------->");
		}
		
		driver.findElement(By.xpath("//*[@placeholder=\"Email\"]")).sendKeys("100200kartik@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder=\"Password\"]")).sendKeys("Test@123");
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
	}

}
