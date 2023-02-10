package com.academy.techcenture.pages;

import static com.academy.techcenture.configReader.ConfigReader.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentTest extentTest;
    protected ExtentReports report;
    protected int waitTime = Integer.parseInt(getProperty("waitTime"));
    private final String settingButtonsCollection = "//div[@role='listbox']//span[contains(text(),'buttonNameToReplace')]";
    private final String menuButtonsCollection = "//div[@class='menu-item-wrapper']//a[contains(@href,'buttonNameToReplace')]";
    private final String menuButtonAddCollection = "//div[@class='menu-item-wrapper']//span[contains(text(),'buttonNameToReplace')]";

    @FindBy (xpath = "//div[@id='top-header-menu']/div")
    protected WebElement cogmentoLogo;
    @FindBy (xpath = "//div[@id='top-header-menu']/b")
    protected WebElement nameLLC;
    @FindBy (xpath = "//span[@class='user-display']")
    protected WebElement fullNameUser;
    @FindBy (xpath = "//a[contains(@href,'billing')]")
    protected WebElement accountStatus;
    @FindBy (xpath = "//input[@type='text']")
    protected WebElement searchInput;
    @FindBy (xpath = "//div[contains(@class,'buttons')]//button[contains(@class,'icon')]")
    protected WebElement pinBtn;
    @FindBy (xpath = "//div[contains(@class,'buttons')]//button[contains(@class,'item')]")
    protected WebElement rubbishBtn;
    @FindBy (xpath = "//div[@role='listbox']")
    protected WebElement settingsBtn;
    @FindBy (xpath = "//div[@class='onesignal-bell-launcher-button']")
    protected WebElement subscribeToNotificationsBtn;


    public BasePage(WebDriver driver, SoftAssert softAssert,ExtentTest extentTest){
        this.driver = driver;
        this.softAssert = softAssert;
        this.extentTest = extentTest;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickElement(WebElement element, ExtentTest extentTest){
        softAssert.assertTrue(element.isEnabled(), element.getText() + " button is not enabled");
        extentTest.log(LogStatus.PASS,element.getText().toUpperCase() + " button is enabled");
        element.click();
        extentTest.log(LogStatus.PASS,element.getText().toUpperCase() + " button is clicked");
    }

    public void navigateTo(String pageName, ExtentTest extentTest){
        driver.get((getProperty("url")) + pageName);
        extentTest.log(LogStatus.INFO, "Navigate to " + pageName.toUpperCase() + " page");
    }

    public void verifyIsEnable(WebElement webElement, String nameWebElement, ExtentTest extentTest){
        softAssert.assertTrue(webElement.isEnabled(),nameWebElement + " is not enabled");
        extentTest.log(LogStatus.PASS, nameWebElement + " is enable");
    }

    public void verifyIsDisplayed(WebElement webElement, String nameWebElement, ExtentTest extentTest){
        softAssert.assertTrue(webElement.isDisplayed(),nameWebElement + " is not displayed");
        extentTest.log(LogStatus.PASS, nameWebElement + " is displayed");
    }

    public void verifyIsEquals(WebElement webElement, String nameWebElement, String expectedText, ExtentTest extentTest){
        softAssert.assertEquals(webElement.getText(), expectedText, nameWebElement + " text is not match");
        extentTest.log(LogStatus.PASS, nameWebElement + " text is match");
    }

    public void verifyTitle(String expectedTitle, ExtentTest extentTest){
        String pageName = driver.getCurrentUrl().substring(driver.getCurrentUrl().lastIndexOf("/")+1);
        softAssert.assertEquals(driver.getTitle(),expectedTitle, pageName.toUpperCase() + " page title is not match");
        extentTest.log(LogStatus.PASS,pageName.toUpperCase() + " title is matched");
    }

    public WebElement getSettingsButton(String buttonName){
        String xpath = settingButtonsCollection.replace("buttonNameToReplace",buttonName);
        WebElement button = driver.findElement(By.xpath(xpath));
        return button;
    }

    public WebElement getMenuButton(String buttonName){
        String xpath = menuButtonsCollection.replace("buttonNameToReplace",buttonName.toLowerCase());
        if (buttonName.contains("add"))
            xpath = menuButtonAddCollection.replace("buttonNameToReplace",buttonName.replace("add","").trim());
        return driver.findElement(By.xpath(xpath));
    }

    public void verifyBasePage(){
        verifyTitle("Cogmento CRM",extentTest);
        verifyIsDisplayed(cogmentoLogo,"Cogmento logo",extentTest);
        verifyIsEquals(nameLLC,"Name LLC","Techcenture LLC",extentTest);
        verifyIsEquals(fullNameUser,"User fullname","Kevin Lee",extentTest);
        verifyIsEquals(accountStatus,"Account status","Free account",extentTest);
        verifyIsEnable(accountStatus,"Account status",extentTest);
        verifyIsEnable(searchInput,"Search input",extentTest);
        verifyIsEnable(pinBtn,"Pin button",extentTest);
        verifyIsEnable(rubbishBtn,"Rubbish button",extentTest);
        verifyIsEnable(settingsBtn,"Settings menu button",extentTest);
        verifyIsEnable(subscribeToNotificationsBtn,"Subscribe to notifications button",extentTest);
        clickElement(settingsBtn,extentTest);
        String[] names = {"Settings","Products","Import","Tools","Log"};
        for (String name: names) {
            verifyIsEnable(getSettingsButton(name),name + " button",extentTest);
        }

        names = new String[] {"Home","Calendar","Contacts","Companies","Deals","Tasks","Cases","Calls","Documents","Email","Campaigns","Forms",
                "Calendar add","Contacts add","Companies add","Deals add","Tasks add","Cases add","Calls add","Documents add"};
        for (String name: names) {
            verifyIsEnable(getMenuButton(name),name + " button",extentTest);
        }
    }
}