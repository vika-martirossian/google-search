package pages;

import static setup.DriverSetup.getDriver;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage() {
        super(getDriver());
        visit(url());
    }

    public String url() {
        return BASE_URL + "/drag_and_drop";
    }
}
