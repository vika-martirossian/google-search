import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AlertPage;

import static org.testng.Assert.assertTrue;

public class AlertTest {
    private ChromeDriver driver;
    private AlertPage alertPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        alertPage = new AlertPage(driver);
    }

    @Test
    public void closeTheAlert() {
        alertPage.clickForTheAlert();
        alertPage.closeAlert();
        assertTrue(alertPage.resultIsShown(), "Alert is not displayed");
        assertTrue(alertPage.resultText().contains("You successfuly clicked an alert"), "Text is incorrect");
    }

    @Test
    public void confirmTheAlert() {
        alertPage.clickToConfirm();
        alertPage.closeAlert();
        assertTrue(alertPage.resultIsShown(), "Alert is not displayed");
        assertTrue(alertPage.resultText().contains("You clicked: Ok"), "Text is incorrect");
    }

    @Test
    public void cancelTheAlert() {
        alertPage.clickToConfirm();
        alertPage.cancelAlert();
        assertTrue(alertPage.resultIsShown(), "Alert is not displayed");
        assertTrue(alertPage.resultText().contains("You clicked: Cancel"), "Text is incorrect");
    }

    @Test
    public void typeInThePrompt() {
        alertPage.clickOnPrompt();
        alertPage.typeInThePrompt("hello");
        alertPage.closeAlert();
        assertTrue(alertPage.resultIsShown(), "Alert is not displayed");
        assertTrue(alertPage.resultText().contains("hello"), "Text is incorrect");
    }

    @Test
    public void cancelThePrompt() {
        alertPage.clickOnPrompt();
        alertPage.cancelAlert();
        assertTrue(alertPage.resultIsShown(), "Alert is not displayed");
        assertTrue(alertPage.resultText().contains("null"), "Text is incorrect");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
