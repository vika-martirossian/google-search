import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.DropDownPage;

import static org.testng.AssertJUnit.assertEquals;

public class DropDownTest {
    private ChromeDriver driver;
    private DropDownPage dropDownPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        dropDownPage = new DropDownPage(driver);
    }

    @Test
    public void dropDownPage() {
        dropDownPage.selectOption("Option 1");
        assertEquals(dropDownPage.getSelectedOption(), "Option 1");
    }

    @Test
    public void alert() {
        dropDownPage.forceAlert();
        dropDownPage.closeAlert();

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}


