package com.academy.techcenture;

import com.academy.techcenture.pages.Companies;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class CompaniesTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Companies companies = new Companies(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        companies.clickElement(companies.getMenuButton("companies"),extentTest);
        companies.verifyBasePage();
    }
}