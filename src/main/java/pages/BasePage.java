package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import java.util.List;


public abstract class BasePage<T> {
    Logger log = Logger.getLogger(Log.class.getName());
    protected WebDriver driver;
    public static final String BASE_URL =
            System.getProperty("selenium.url", "http://the-internet.herokuapp.com");

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void visit(String url) {
        log.info("Visiting " + url);
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public WebElement find(By locator) {
        log.info("Finding elements by " + locator.toString());
        return driver.findElement(locator);
    }

    public WebElement find(String cssSelector) {
        log.info("Finding elements by " + cssSelector);
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator) {
        log.info("Clicking on elements " + locator.toString());
        click(find(locator));
    }

    public void click(WebElement element) {
        log.info("Clicking on elements " + element.toString());
        element.click();
    }

    public void type(By locator, String text) {
        log.info("Typing " + text + "into element " + locator.toString());
        type(find(locator), text);
    }

    public void type(WebElement element, String text) {
        log.info("Typing " + text + "into element " + element.toString());
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element) {
        log.info("Checking visibility of " + element.toString());
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isDisplayed(By locator) {
        log.info("Checking visibility of " + locator.toString());
        try {
            isDisplayed(find(locator));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }


    public List<WebElement> findElements(By locator) {
        log.info("Finding elements by " + locator.toString());
        return driver.findElements(locator);
    }

    public boolean isElementDisplayed(WebElement element, Integer timeout) {
        log.info("Checking visibility of " + element.toString());
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isElementInvisible(WebElement element, Integer timeout) {
        log.info("Checking invisibility of " + element.toString());
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }


    public Alert alert() {
        log.info("Alerting");
        return driver.switchTo().alert();
    }
}
