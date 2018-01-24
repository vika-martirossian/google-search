import org.testng.annotations.Test;
import pages.CheckboxPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxTest extends BaseTest{

    CheckboxPage checkboxPage = new CheckboxPage();

    @Test
    public void checkboxSelect() {
        assertFalse(checkboxPage.getCheckbox(0).isSelected(),
                "Checkbox is selected");
        checkboxPage.clickOnCheckbox(0);
        assertTrue(checkboxPage.getCheckbox(0).isSelected(),
                "Checkbox is not selected");
    }
}
