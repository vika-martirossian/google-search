package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public WebElement click() {
        return click();
    }

    public CharSequence[] type(CharSequence... sendKeys) {
        return sendKeys;
    }

    public boolean isDisplayed() {
        return isDisplayed();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
