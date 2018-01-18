import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import setup.listeners.SuitListener;

import static setup.DriverSetup.quiteDriver;

@Listeners(SuitListener.class)
public class BaseTest {

    @AfterMethod
    public void tearDownBase() {
        quiteDriver();
    }
}
