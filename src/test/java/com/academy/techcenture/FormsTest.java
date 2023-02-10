package com.academy.techcenture;

import com.academy.techcenture.pages.Forms;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Forms forms = new Forms(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        forms.clickElement(forms.getMenuButton("forms"),extentTest);
        forms.verifyBasePage();
    }
}