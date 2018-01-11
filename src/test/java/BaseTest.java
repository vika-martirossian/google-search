import org.testng.annotations.AfterMethod;
import static setup.DriverSetup.quiteDriver;

public class BaseTest {

    @AfterMethod
    public void tearDownBase() {
        quiteDriver();
    }
}
