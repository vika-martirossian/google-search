package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage extends BasePage {
    private By searchField = By.cssSelector("input#lst-ib");
    private By searchButton = By.cssSelector("input[name='btnK']");
    private By results = By.id("resultStats");

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
        visit("https://www.google.com/");
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public void typeSearchText(String text) {
        type(searchField, text);
    }

    public void search(String text) {
        typeSearchText(text);
        clickSearchButton();
    }

    public WebElement getFirstResult() {
        List<WebElement> elements = findElements(By.cssSelector(".rc .r"));
        return elements.get(0);
    }

    public boolean getResults() {
        return isElementDisplayed(find(results), 10);
    }
}