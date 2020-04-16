package pages;

import libs.ConfigClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

//класс для работы со страницей Сотрудники//
public class WorkersPage extends ParentPage  {
    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    private WebElement addButton;
    @FindBy(xpath = "//input[@id='workers_workerSurname']")
    private WebElement workerSurname;
    @FindBy(xpath = "//input[@id='workers_workerName']")
    private WebElement workerName;
    @FindBy(xpath = "//input[@id='workers_workerMiddleName']")
    private WebElement workerMiddleName;
    @FindBy(xpath = "//input[@id='workers_workerPhone']")
    private WebElement workerPhone;
    @FindBy(xpath = "//button[@name='add']")
    private WebElement createWorkerButton;
    @FindBy (xpath = "//div[@class='navbar-custom-menu']")
    private WebElement studentMenu;
    @FindBy (xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    private WebElement exitButton;
    @FindBy (xpath = "//tr[186]//td[1]")
    private WebElement changeValue;
    @FindBy (xpath = "//button[@name='save']")
    private WebElement saveButton;

    public WorkersPage (WebDriver webDriver) {
        super(webDriver);
    }
    public void openPage() {
        try {
            webDriver.get(ConfigClass.getConfigValue("base_url") + "/dictionary/workers");
            logger.info("Workers page was opened");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Cannot open file");
            Assert.fail("Cannot open file");
        }
    }
    //Заполняемые поля типа "InputBox", поэтому использую "enterTextToTextFields"
        public void fillWorkerSurnameName (String workerSurnameName) {
            actionsElements.enterTextToTextFields(workerSurname, workerSurnameName);
        }

        public void fillWorkerName (String workerNameName) {
            actionsElements.enterTextToTextFields(workerName, workerNameName);
        }

        public void fillWorkerMiddleName(String workerMiddleNameName) {
            actionsElements.enterTextToTextFields(workerMiddleName, workerMiddleNameName);
        }
        public void fillWorkerPhone(String workerPhoneName){
            actionsElements.enterTextToTextFields(workerPhone, workerPhoneName) ;
        }
        public void clickAddButton() {
            actionsElements.clickButton(addButton);
        }

        public void clickCreateButton() {
            actionsElements.clickButton(createWorkerButton);
        }

        public void clickRowWorker () {actionsElements.clickButton(changeValue);}

        public void clickSaveButton () {actionsElements.clickButton(saveButton);}

        //добавляю нового работника на странице WorkersPage
        public void addNewWorker(String workerSurnameName, String workerNameName, String workerMiddleNameName, String workerPhoneName)
        {
            clickAddButton();
            fillWorkerSurnameName (workerSurnameName);
            fillWorkerName(workerNameName);
            fillWorkerMiddleName(workerMiddleNameName) ;
            fillWorkerPhone(workerPhoneName);
            clickCreateButton();
        }
     //изменить данные добавленого мною ранее работника
     public void changeValuesWorker (String workerNameName, String workerMiddleNameName, String workerPhoneName)
     {
         clickRowWorker();
         fillWorkerName(workerNameName);
         fillWorkerMiddleName(workerMiddleNameName) ;
         fillWorkerPhone(workerPhoneName);
         clickSaveButton();
     }

    //узнаю общее количество работников, которые были добавлены на страницу
    public int workersAmount() { return actionsElements.countNumbersRows(webDriver) ;}

    //для выхода из учетной записи, когда нахожусь во вкладке "Сотрудники"
    public void clickStudentButton() { actionsElements.clickButton (studentMenu) ;}
    public void clickExitButton() { actionsElements.clickButton (exitButton) ;}
    }



