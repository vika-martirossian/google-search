package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    public WebElement find(String cssSelector) {
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator) {
        click(find(locator));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(String cssSelector) {
        click(find(cssSelector));
    }

    public void type(By locator, String text) {
        type(find(locator), text);
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void type(String cssSelector, String text) {
        type(find(cssSelector), text);
    }

    public boolean isDisplayed(WebElement element) {
        try{
            element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public boolean isDisplayed(By locator) {
        try{
            isDisplayed(find(locator));
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public boolean isDisplayed(String cssSelector){
        return isDisplayed(find(cssSelector));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
