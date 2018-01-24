package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CheckboxPage extends BasePage {
    public CheckboxPage() {
        visit(getUrl());
    }

    @FindBys(
            @FindBy(css = "input[type='checkbox']")
    )

    private List<WebElement> checkboxes;

    @Override
    public String getUrl() {
        return BASE_URL + "/checkboxes";
    }

    public void clickOnCheckbox(int index) {
        checkboxes.get(index).click();
    }

    public WebElement getCheckbox(int index) {
        return checkboxes.get(index);
    }
}
