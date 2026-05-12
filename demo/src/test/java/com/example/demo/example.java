package com.example.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class example {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		
		driver.get("https://www.google.com");
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("mohan", Keys.ENTER);
		String user = username.getText();
		Assert.assertEquals(user.contains("mohan"), "inputbox should contains search");
	}

}
