package pages;

import org.openqa.selenium.By;


public class AlertPage extends BasePage {
    private By alertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By confirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By promptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public AlertPage() {
        visit(url());
    }

    public String url() {
        return BASE_URL + "/javascript_alerts";
    }

    public void clickForTheAlert() {
        click(alertButton);
    }

    public void closeAlert() {
        alert().accept();
    }

    public boolean resultIsShown() {
        return isDisplayed(resultText);
    }

    public String resultText() {
        return find(resultText).getText();
    }

    public void clickToConfirm() {
        click(confirmButton);
    }

    public void cancelAlert() {
        alert().dismiss();
    }

    public void clickOnPrompt() {
        click(promptButton);
    }

    public void typeInThePrompt(String text) {
        alert().sendKeys(text);
    }

    @Override
    public String getUrl() {
        return url();
    }
}
