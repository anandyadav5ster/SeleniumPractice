package com.example.demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HandleNewTab extends BaseTest{
    public static WebDriver driver;

    @Test
    public static void handleNewTab(){
        driver = getDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for(String window : allWindow){
            if(!mainWindow.equals(window)){
                driver.switchTo().window(window);
                String title = driver.getTitle();
                System.out.println("Title of the new tab is "+title);
            }
        }
        
    }
}
