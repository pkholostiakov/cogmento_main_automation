package com.academy.techcenture;

import com.academy.techcenture.pages.Home;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Home home = new Home(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        home.clickElement(home.getMenuButton("home"),extentTest);
        home.verifyBasePage();
    }
}