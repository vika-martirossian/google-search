import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WindowPage;

public class MultiWindowTest extends BaseTest {
    public ChromeDriver driver;
    private WindowPage windowPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        windowPage = new WindowPage();
    }

    @Test
    public void windowChange() {
        windowPage.clickLink();
        windowPage.switchToWindow(0);
    }
}
