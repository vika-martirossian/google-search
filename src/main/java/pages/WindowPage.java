package pages;

import static setup.DriverSetup.getDriver;

public class WindowPage extends BasePage{
    public WindowPage() {
        super(getDriver());
        visit(url());
    }

    public String url() {
        return BASE_URL + "/windows";
    }

    public void clickLink() {
        find(".example a").click();
    }

    public Object[] getAllWindows() {
        return driver.getWindowHandles().toArray();
    }

    public void switchToWindow(int index) {
        driver.switchTo().window(getAllWindows()[index].toString());
    }
}

