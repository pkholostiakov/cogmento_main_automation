package com.academy.techcenture;

import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginPositiveTest() {
        extentTest = report.startTest("Cogmento Login Positive Test");
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
    }

    @Test
    public void loginNegativeTest() {
        extentTest = report.startTest("Cogmento Login Negative Test");
        Login login = new Login(driver,softAssert,extentTest);
        login.loginNegative();
    }
}