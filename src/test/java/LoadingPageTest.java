import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoadingPage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoadingPageTest {
        private ChromeDriver driver;
        private LoadingPage loadingPage;

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
            driver = new ChromeDriver();
            loadingPage = new LoadingPage(driver);
        }

        @Test
        public void loadingPage() {
            loadingPage.clickTheButton();
            assertTrue(loadingPage.isLoadingDisplayed(), "Loading is not displayed");
            assertTrue(loadingPage.isLoadingInvisible(), "Loading is not hidden");
            assertTrue(loadingPage.isFinishDisplayed());
            assertEquals(loadingPage.getFinish().getText(), "Hello World!");
        }


        @AfterMethod
        public void tearDown() {
            driver.close();
            driver.quit();
        }
    }