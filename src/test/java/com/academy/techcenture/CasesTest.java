package com.academy.techcenture;

import com.academy.techcenture.pages.Cases;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class CasesTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Cases cases = new Cases(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        cases.clickElement(cases.getMenuButton("cases"),extentTest);
        cases.verifyBasePage();
    }
}