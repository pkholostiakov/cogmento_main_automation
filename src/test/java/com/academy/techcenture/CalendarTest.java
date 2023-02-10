package com.academy.techcenture;

import com.academy.techcenture.pages.Calendar;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Calendar calendar = new Calendar(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        calendar.clickElement(calendar.getMenuButton("Calendar"),extentTest);
        calendar.verifyBasePage();
    }
}