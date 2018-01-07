package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {
    private By alertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By confirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By promptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public AlertPage(WebDriver webDriver) {
        super(webDriver);
        visit("http://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickForTheAlert() {
        click(alertButton);
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();
    }

    public boolean resultIsShown() {
        return isDisplayed(resultText);
    }

    public String resultText() {
        return find(resultText).getText();
    }

    public void clickToComfirm() {
        click(confirmButton);
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void clickOnPrompt() {
        click(promptButton);
    }

    public void typeInThePrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
