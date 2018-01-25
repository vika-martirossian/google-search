package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoadingPage extends BasePage {
    @FindBy(css = "#start button")
    private WebElement startButton;
    @FindBy(id = "finish")
    private WebElement finishText;
    @FindBy(id = "loading")
    private WebElement loadingText;

    public LoadingPage() {
        visit(url());

    }

    public String url() {
       return BASE_URL + "/dynamic_loading/1";
    }

    public void clickTheButton() {
        click(startButton);
    }

    public boolean isFinishDisplayed() {
       return isElementDisplayed (finishText, 10);
    }

    public WebElement getFinish() {
        return finishText;
    }

    public boolean isLoadingDisplayed() {
        return isElementDisplayed(loadingText, 10);
    }

    public boolean isLoadingInvisible() {
        return isElementInvisible(loadingText, 10);
    }

    @Override
    public String getUrl() {
        return url();
    }
}
