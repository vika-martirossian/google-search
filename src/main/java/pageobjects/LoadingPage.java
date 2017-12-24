package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoadingPage extends BasePage {
    private By startButton = By.cssSelector("#start button");
    private By finishText = By.id("finish");
    private By loadingText = By.id("loading");

    public LoadingPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void clickTheButton() {
        click(startButton);
    }

    public boolean isFinishDisplayed() {
       return isElementDisplayed(find(finishText), 10);
    }

    public WebElement getFinish() {
        return find(finishText);
    }

    public boolean isLoadingDisplayed() {
        return isElementDisplayed(find(loadingText), 10);
    }

    public boolean isLoadingInvisible() {
        return isElementInvisible(find(loadingText), 10);
    }
}
