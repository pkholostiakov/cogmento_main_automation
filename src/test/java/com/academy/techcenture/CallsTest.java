package com.academy.techcenture;

import com.academy.techcenture.pages.Calls;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class CallsTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Calls calls = new Calls(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        calls.clickElement(calls.getMenuButton("Calls"),extentTest);
        calls.verifyBasePage();
    }
}