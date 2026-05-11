package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class GoogleTest extends BaseTest{
    
    @Test
    public static void HomePage(){
        WebDriver driver = getDriver();
        
        // 2. Navigate to the URL using double quotes
        driver.get("https://www.google.com");
        
        
        
        // 4. Basic validation
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }
}
