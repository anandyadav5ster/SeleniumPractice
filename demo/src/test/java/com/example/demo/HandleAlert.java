package com.example.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest{
    
    public static WebDriver driver;

    @Test
    public static void HandleSimpleAlert(){
        driver = getDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//button[@id='alertBtn']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert msg is "+alert.getText());
    }

}
