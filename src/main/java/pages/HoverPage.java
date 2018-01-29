package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.WaitHelper;

public class HoverPage extends BasePage{

    public HoverPage() {
        visit(url());
    }

    public String url() {
        return BASE_URL + "/hovers";
    }

    public void hoverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverAvatar() {
        hoverElement(find(By.className("figure")));
    }

    public boolean isHeaderDisplayed() {
       try {
           WaitHelper.getWait().waitForElementToBeVisible(find(By.className("figcaption")));
           return true;
       } catch (Error e) {
           return false;
       }
    }

    public boolean isHeaderHidden() {
        try {
            WaitHelper.getWait().waitForElementToBeNotVisible(find(By.className("figcaption")));
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public WebElement getHeader() {
        return find(By.className("figcaption"));
    }

    @Override
    public String getUrl() {
        return url();
    }
}
