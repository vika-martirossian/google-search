import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.GoogleSearchPage;


public class GoogleSearchTest {
    private ChromeDriver driver;
    private GoogleSearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        searchPage = new GoogleSearchPage(driver);
    }

    @Test()
    public void search() {
        searchPage.search("Armenia");
        Assert.assertTrue(searchPage.isDisplayed(searchPage.wikiArmeniaLink));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}