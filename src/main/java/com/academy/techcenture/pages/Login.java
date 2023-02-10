package com.academy.techcenture.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import static com.academy.techcenture.configReader.ConfigReader.*;

public class Login extends BasePage {
    public Login(WebDriver driver, SoftAssert softAssert, ExtentTest extentTest) {
        super(driver, softAssert, extentTest);
    }

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'negative')]")
    private WebElement errorMessage;

    public void login() {
        verifyLoginPage();
        emailInput.sendKeys(getProperty("username"));
        passwordInput.sendKeys(getProperty("password"));
        clickElement(loginButton,extentTest);
    }

    public void loginNegative() {
        verifyLoginPage();
        emailInput.sendKeys(getProperty("usernameInc"));
        passwordInput.sendKeys(getProperty("passwordInc"));
        clickElement(loginButton,extentTest);
        softAssert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
    }
    private void verifyLoginPage(){
        navigateTo("login",extentTest);
        verifyTitle("Cogmento CRM",extentTest);
        verifyIsEnable(emailInput,"E-mail",extentTest);
        verifyIsEnable(passwordInput,"Password",extentTest);
    }
}