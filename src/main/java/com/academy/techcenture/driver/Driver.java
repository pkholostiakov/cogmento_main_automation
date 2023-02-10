package com.academy.techcenture.driver;

import static com.academy.techcenture.configReader.ConfigReader.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    public Driver() {}

    public static WebDriver getDriver(){
        String browser = getProperty("browser").trim().toLowerCase();
        int pageLoadTime = Integer.parseInt(getProperty("pageLoadTime"));
        int implicitWait = Integer.parseInt(getProperty("implicitWait"));

        switch (browser) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Driver not found");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}