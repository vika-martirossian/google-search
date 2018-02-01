import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import setup.listeners.SuitListener;

import static setup.DriverSetup.initDriver;
import static setup.DriverSetup.quiteDriver;

@Listeners(SuitListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUpBase() {
        initDriver();
    }

    @AfterMethod
    public void tearDownBase() {
        quiteDriver();
    }
}
