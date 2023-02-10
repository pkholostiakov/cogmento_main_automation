package com.academy.techcenture.reports;

import com.academy.techcenture.pages.BasePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

public class Reports extends BasePage {

    public Reports(WebDriver driver, SoftAssert softAssert, ExtentTest extentTest) {
        super(driver, softAssert, extentTest);
    }

    public static void setUpReport(ExtentReports report){
        report.addSystemInfo("ENGINEER", System.getProperty("os.name"));
        report.addSystemInfo("OS NAME", System.getProperty("user.name"));
        report.addSystemInfo("ENVIRONMENT", "QA");
        report.addSystemInfo("JAVA VERSION", System.getProperty("java.version"));
    }

    public static void collectReports(ExtentReports report){
        report.flush();
        report.close();
    }

    public static void getSystemInfoForReport(WebDriver driver,ExtentReports report){
        Capabilities browserCap = ((RemoteWebDriver)driver).getCapabilities();
        report.addSystemInfo("BROWSER NAME", browserCap.getBrowserName());
        report.addSystemInfo("BROWSER VERSION", browserCap.getBrowserVersion());
    }

    public static void getReport(ExtentReports reports, ExtentTest extentTest){
        reports.endTest(extentTest);
    }
}