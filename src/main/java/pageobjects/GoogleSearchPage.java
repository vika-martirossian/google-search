package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePage {
    private By searchField = By.cssSelector("input#lst-ib");
    private By searchButton = By.cssSelector("input[name='btnK']");
    public By wikiArmeniaLink = By.xpath("//cite[@class = '_Rm' and text()= 'https://en.wikipedia.org/wiki/Armenia']");

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

    public boolean isSearchResultsDisplayed(WebElement element) {
        return isDisplayed(element);
    }

}