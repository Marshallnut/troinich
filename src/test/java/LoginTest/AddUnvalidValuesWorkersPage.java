package LoginTest;

import ParentTests.AbstractParentTest;
import org.junit.Test;

//негативный тесткейс: работник не добавлен в таблицу и видно, что логконтроль срабатывает в поле, но тест "якобы" пройден
public class AddUnvalidValuesWorkersPage extends AbstractParentTest  {
    @Test
    public void validAddWorker() {
        loginPage.openPageLogin();
        loginPage.loginToPage("Student", "909090");
        workersPage.openPage();
        workersPage.addNewWorker("", "", "","");
        checkExpectedResult("Add worker not succesfull", false);
        System.out.println ("Values for adding are empty and don't exists in the table");
    }
}
