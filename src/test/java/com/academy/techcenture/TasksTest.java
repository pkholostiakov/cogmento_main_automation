package com.academy.techcenture;

import com.academy.techcenture.pages.Login;
import com.academy.techcenture.pages.Tasks;
import org.testng.annotations.Test;

public class TasksTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Tasks tasks = new Tasks(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        tasks.clickElement(tasks.getMenuButton("tasks"),extentTest);
        tasks.verifyBasePage();
    }
}