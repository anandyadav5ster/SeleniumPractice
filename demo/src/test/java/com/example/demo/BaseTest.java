package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;

/**
 * Enhanced BaseTest with Parameterization.
 * Supports running via testng.xml <parameter> and Maven -Dbrowser=name.
 * Uses ThreadLocal to ensure thread-safety during parallel execution.
 */
public class BaseTest {
    
    // ThreadLocal container ensures each thread has its own isolated WebDriver instance
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Retrieves the driver instance for the current thread.
     */
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    /**
     * Initializes the driver based on the browser parameter.
     * @param browser Name of the browser passed from testng.xml. 
     * @Optional ensures the test runs even if the XML parameter is missing.
     */
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {
        
        // Priority: Maven Command Line (-Dbrowser) > TestNG XML > Default (chrome)
        String mvnBrowser = System.getProperty("browser");
        if (mvnBrowser != null && !mvnBrowser.isEmpty()) {
            browser = mvnBrowser;
        }

        System.out.println("Thread " + Thread.currentThread().getId() + " - Starting Browser: " + browser);

        WebDriver localDriver;
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                localDriver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                localDriver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                localDriver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser '" + browser + "' is not supported!");
        }
        
        // CRITICAL: Set the initialized driver into the ThreadLocal container
        driverThreadLocal.set(localDriver);

        // Configure the browser using the thread-safe getter
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Properly closes the browser and removes the ThreadLocal reference.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            try {
                getDriver().quit();
            } catch (Exception e) {
                System.err.println("Error while quitting driver: " + e.getMessage());
            } finally {
                // Remove the reference to prevent memory leaks in the thread pool
                driverThreadLocal.remove();
            }
        }
    }
}