package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends BasePage {
    private By searchField = By.id("lst-ib");
    private By wikiArmeniaLink = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/h3/a");

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
        visit("https://www.google.com/?gws_rd=cr&dcr=0&ei=vLM2Wt7QGs6akwXTxprIBQ");
    }

    public void search(String value) {
        find(searchField).sendKeys(Keys.RETURN);
    }

    public void findArmenia() {
        find(wikiArmeniaLink).click();
        getUrl().contains("/Armenia");
    }
}