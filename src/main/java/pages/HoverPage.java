package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
       return isElementDisplayed(find(By.className("figcaption")), 5);
    }

    public boolean isHeaderHidden() {
        return isElementInvisible(find(By.className("figcaption")), 5);
    }

    public WebElement getHeader() {
        return find(By.className("figcaption"));
    }

    @Override
    public String getUrl() {
        return null;
    }
}
