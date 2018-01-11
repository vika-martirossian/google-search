package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class DropDownPage extends BasePage {
    public DropDownPage() {
        super(getDriver());
        visit(url());
    }

    public String url() {
        return BASE_URL + "/dropdown";
    }

    public WebElement getDropdown() {
        return find(By.id("dropdown"));
    }

    public List<WebElement> getDropdownOptions() {
        return getDropdown().findElements(By.tagName("option"));
    }

    public void selectOption(String optionName) {
        List<WebElement> options = getDropdownOptions();
        for (WebElement option : options) {
            if (option.getText().equals(optionName)) {
                option.click();
            }
        }
    }

    public String getSelectedOption() {
        List<WebElement> options = getDropdownOptions();
        for (WebElement option : options) {
            if (option.isSelected()) {
                return option.getText();
            }
        }
        return null;
    }

    public void forceAlert() {
        ((JavascriptExecutor) driver).executeScript("alert('Hello! I am an alert box!!');");
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();
    }
}
