package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import sun.rmi.runtime.Log;

import java.util.List;

import static setup.DriverSetup.getDriver;


public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    Logger log = Logger.getLogger(Log.class.getName());
    protected WebDriver driver;
    public static final String BASE_URL =
            System.getProperty("selenium.url", "http://the-internet.herokuapp.com");

    public BasePage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void visit(String url) {
        log.info("Visiting " + url);
        driver.get(url);
        this.get();
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

    public Alert alert() {
        log.info("Alerting");
        return driver.switchTo().alert();
    }

    public abstract String getUrl();
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(getUrl());
    }

}
