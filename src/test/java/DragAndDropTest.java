import org.testng.annotations.BeforeMethod;
import pages.DragAndDropPage;

public class DragAndDropTest {
    private DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setUp() {
        dragAndDropPage = new DragAndDropPage();
    }
}
