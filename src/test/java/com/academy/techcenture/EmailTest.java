package com.academy.techcenture;

import com.academy.techcenture.pages.Email;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class EmailTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Email email = new Email(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        email.clickElement(email.getMenuButton("email"),extentTest);
        email.verifyBasePage();
    }
}