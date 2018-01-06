package pageobjects;

import org.openqa.selenium.WebDriver;

public class WindowPage extends BasePage{
    public WindowPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/windows");
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

