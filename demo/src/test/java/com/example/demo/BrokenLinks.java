package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenLinks extends BaseTest {

    public static WebDriver driver;

    @Test
    public static void brokenLinks() throws IOException {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        driver = getDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        // scrolling
        WebElement brokenLink = driver.findElement(By.cssSelector("#broken-links"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", brokenLink);

        // Take screenshot

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path + "/screenshots/brokenlinks.png"));

        List<WebElement> links = driver.findElements(By.cssSelector("#broken-links>a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            verifyBrokenLinks(url);

        }
        driver.quit();
    }

    static void verifyBrokenLinks(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();
            // if(connection.getResponseCode() == 200){
            if (connection.getResponseCode() >= 400) {
                System.out.println(urlString + " Broken link " + connection.getResponseCode());
            } else {
                System.out.println(urlString + " URL is valid " + connection.getResponseCode());
            }
        } catch (Exception e) {
            System.out.println(urlString + " Broken link exception " + e.getMessage());
        }
    }

    @Test
    public void getWindowHandles() {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        driver = getDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement newTab = driver.findElement(By.xpath("//button[text()='New Tab']"));
        newTab.click();
        String parentWindow = driver.getWindowHandle();

        Set<String> allWindow = driver.getWindowHandles();
        for (String win : allWindow) {
            driver.switchTo().window(win);
            String currentTitle = driver.getTitle();
            if (currentTitle.equalsIgnoreCase("SDET-QA Blog")) { 
                System.out.println("Switched to target window: " + currentTitle);
                // Perform actions...
                driver.close(); // Closes the child window
                break; // Exit loop once found
            }

            driver.switchTo().window(parentWindow);

            System.out.println(driver.getTitle());

        }
        driver.quit();
    }

}
