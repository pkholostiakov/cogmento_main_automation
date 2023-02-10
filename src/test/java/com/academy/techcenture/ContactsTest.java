package com.academy.techcenture;

import com.academy.techcenture.pages.Contacts;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Contacts contacts = new Contacts(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        contacts.clickElement(contacts.getMenuButton("contacts"),extentTest);
        contacts.verifyBasePage();
    }
}