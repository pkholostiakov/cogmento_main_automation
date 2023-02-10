package com.academy.techcenture;

import com.academy.techcenture.pages.Campaigns;
import com.academy.techcenture.pages.Login;
import org.testng.annotations.Test;

public class CampaignsTest extends BaseTest {

    @Test
    public void testBaseButtons(){
        extentTest = report.startTest("Cogmento Calendar page. Base buttons test");
        Campaigns campaigns = new Campaigns(driver,softAssert,extentTest);
        Login login = new Login(driver,softAssert,extentTest);
        login.login();
        campaigns.clickElement(campaigns.getMenuButton("campaigns"),extentTest);
        campaigns.verifyBasePage();
    }
}