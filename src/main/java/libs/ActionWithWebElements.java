package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionWithWebElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait10, webDriverWait15;

    public ActionWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait10 = new WebDriverWait(webDriver,10);
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }

    public void enterTextToTextFields(WebElement element, String text) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(element));
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
            webDriverWait10.until(ExpectedConditions.visibilityOf(element));
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
