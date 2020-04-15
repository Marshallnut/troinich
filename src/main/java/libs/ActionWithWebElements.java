package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionWithWebElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextToTextFields(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info("Field was filled ..");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
    }

    public void clickButton(WebElement element) {
        try {
            element.click();
            logger.info("Clicked ..");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
            return false;
        }
    }

    public void setCheckBox(WebElement element, boolean state) {
        try {
            if (element.isSelected() != state) {
                element.click();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
    }
    //подсчитывает общее количество работников, что на странице "Workers". Использовала "tr" вместо "cssSelector"
    public int countNumbersRows(SearchContext table) {
        try {
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            return rows.size()-1;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Can`t count table rows");
            return -1;
        }
    }
}
