import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoverPage;

import static org.testng.AssertJUnit.assertTrue;

public class HoverTest extends BaseTest{
    private ChromeDriver driver;
    private HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        hoverPage = new HoverPage();
    }

    @Test
    public void hover() {
        assertTrue("Header is shown", hoverPage.isHeaderHidden());
        hoverPage.hoverAvatar();
        assertTrue("Header is not visible", hoverPage.isHeaderDisplayed());
        assertTrue("Header text is not correct", hoverPage.getHeader().getText()
                .contains("name: user1"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}


