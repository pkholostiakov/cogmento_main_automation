package com.academy.techcenture;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import static com.academy.techcenture.driver.Driver.*;
import static com.academy.techcenture.reports.Reports.*;

public class BaseTest {

    protected static WebDriver driver;
    protected SoftAssert softAssert;
    protected ExtentTest extentTest;
    protected ExtentReports report = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html",true);

    @BeforeTest
    public void beforeTest(){
        setUpReport(report);
    }

    @AfterTest
    public void afterTest(){
        collectReports(report);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = getDriver();
        getSystemInfoForReport(driver,report);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown(){
        quitDriver();
        softAssert.assertAll();
        getReport(report, extentTest);
    }
}