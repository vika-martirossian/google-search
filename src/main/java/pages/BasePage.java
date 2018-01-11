package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {
    protected WebDriver driver;
    public static final String BASE_URL =
            System.getProperty("selenium.url", "http://the-internet.herokuapp.com");

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public WebElement find(String cssSelector) {
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator) {
        click(find(locator));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(By locator, String text) {
        type(find(locator), text);
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isDisplayed(By locator) {
        try {
            isDisplayed(find(locator));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isNotDisplayed(By locator) {
        try {
            isDisplayed(find(locator));
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }


    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public boolean isElementDisplayed(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isElementInvisible(WebElement element, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }


    public Alert alert() {
        return driver.switchTo().alert();
    }
}
