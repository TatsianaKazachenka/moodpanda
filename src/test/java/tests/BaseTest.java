package tests;

import com.codeborne.selenide.Configuration;
import constants.IConstantsTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest implements IConstantsTest {

    LoginPage loginPage;
    FeedPage feedPage;
    RateYourHappinessPage rateYourHappiness;
    MoodUpdateModal moodUpdateModal;

    LoginSteps loginSteps;
    MoodUpdateModalSteps moodUpdateModalSteps;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        Configuration.holdBrowserOpen = true;
        initSteps();
        initPages();
    }

    @AfterMethod
    public void closeBrowser(){
        getWebDriver().quit();
    }

    public void initPages() {
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappiness = new RateYourHappinessPage();
        moodUpdateModal = new MoodUpdateModal();
    }

    public void initSteps() {
        loginSteps = new LoginSteps();
        moodUpdateModalSteps = new MoodUpdateModalSteps();
    }
}
