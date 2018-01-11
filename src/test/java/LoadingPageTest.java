import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoadingPage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoadingPageTest extends BaseTest{
    private LoadingPage loadingPage;

    @BeforeMethod
    public void setUp() {
        loadingPage = new LoadingPage();
    }

    @Test
    public void loadingPage() {
        loadingPage.clickTheButton();
        assertTrue(loadingPage.isLoadingDisplayed(), "Loading is not displayed");
        assertTrue(loadingPage.isLoadingInvisible(), "Loading is not hidden");
        assertTrue(loadingPage.isFinishDisplayed());
        assertEquals(loadingPage.getFinish().getText(), "Hello World!");
    }
}