import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BasePage;
import pageobjects.GoogleSearchPage;


import static org.testng.AssertJUnit.assertTrue;

public class SearchArmenia {
    private ChromeDriver driver;
    private GoogleSearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        searchPage = new GoogleSearchPage(driver);
    }

    @Test
    public void search() throws InterruptedException {
        searchPage.search("Armenia");
        Thread.sleep(3000);
        assertTrue("No such result found!", searchPage.findArmenia());

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}