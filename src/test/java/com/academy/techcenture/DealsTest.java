package com.academy.techcenture;

import com.academy.techcenture.pages.Deals;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class DealsTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Deals deals = new Deals(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        deals.clickElement(deals.getMenuButton("deals"),extentTest);
        deals.verifyBasePage();
    }
}