package com.academy.techcenture;

import com.academy.techcenture.pages.Documents;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class DocumentsTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Documents documents = new Documents(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        documents.clickElement(documents.getMenuButton("documents"),extentTest);
        documents.verifyBasePage();
    }
}