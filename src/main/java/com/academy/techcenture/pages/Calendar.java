package com.academy.techcenture.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Calendar extends BasePage{

    public Calendar(WebDriver driver, SoftAssert softAssert, ExtentTest extentTest) {
        super(driver, softAssert, extentTest);
    }
}