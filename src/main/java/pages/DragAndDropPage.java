package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import sun.rmi.runtime.Log;

import static setup.DriverSetup.getDriver;

public class DragAndDropPage extends BasePage {
    Logger log = Logger.getLogger(Log.class.getName());

    @FindBy(css = ".ui-draggable")
    private WebElement draggable;

    @FindBy(css = ".ui-droppable")
    private WebElement droppable;


    public DragAndDropPage() {
        visit(getUrl());
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        log.info("i am in isLoaded!");
        waitForElement(draggable);

    }

    public String getUrl() {
        return "http://jqueryui.com/resources/demos/droppable/default.html";
    }

    public void dragAndDrop(WebElement draggable, WebElement target) {
        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(draggable, target).build().perform();
    }

    public void dragAndDrop() {
        dragAndDrop(draggable, droppable);
    }

    public String getDropText() {
        return find(By.cssSelector(".ui-droppable")).getText();
    }


}