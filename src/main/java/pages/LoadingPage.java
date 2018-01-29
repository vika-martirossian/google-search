package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;


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
       try {
           WaitHelper.getWait().waitForElementToBeVisible(finishText);
           return true;
       }catch (Error e) {
           return false;
       }
    }

    public WebElement getFinish() {
        return finishText;
    }

    public boolean isLoadingDisplayed() {
        try {
            WaitHelper.getWait().waitForElementToBeVisible(loadingText);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public boolean isLoadingInvisible() {
        try {
            WaitHelper.getWait().waitForElementToBeNotVisible(loadingText);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    @Override
    public String getUrl() {
        return url();
    }
}
