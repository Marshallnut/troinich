package libs;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ActionWithWebElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger (getClass());

    public ActionWithWebElements (WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void enterTextToTextField (By element, String text) {
    try {
        webDriver.findElement(element).clear();
        webDriver.findElement(element).sendKeys(text);
        logger.info("");
    }
    catch (Exception e) {
        e.printStackTrace();
        logger.error("");
    }
    public void clickButton (By element) {
        try {
            webDriver.findElement (element).click ();
            logger.info ("");
        }
        catch (Exception e) {
            e.printStackTrace ();
            logger.error ("");
        }
    }
    public boolean isElementDisplay (By element) {
        try {
            return webDriver.findElement (element).isDisplayed());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error ("");
            return false;
        }
    }
    public void SetCheckBox (By element, boolean state) {
        try {
            if (webDriver.findElement (element).isSelected () == state) {
            }
            else {
                webDriver.findElement (element).click();
            }
            logger.info ("The check box is"+state);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error ("");

        }
    }
    private void selectElementFromDD (By element, String itemName) {
        Select dropDownValue = new Select (webDriver.findElement (element));
        try {
            dropDownValue.selectByVisibleText (itemName);
        }
        catch (Exception ex) {
            ex.printStackTrace ();
            logger.error ("");
        }
    }
    }
}