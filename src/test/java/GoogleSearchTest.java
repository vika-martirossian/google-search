import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import static org.testng.Assert.assertTrue;


public class GoogleSearchTest {
    private ChromeDriver driver;
    private GoogleSearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        searchPage = new GoogleSearchPage(driver);
    }

    @Test
    public void search() {
        searchPage.search("Armenia");
        assertTrue(searchPage.getFirstResult().getText().equals("Armenia - Wikipedia"), "No Armenia here");
        assertTrue(searchPage.getResults(), "No Results are displayed");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}