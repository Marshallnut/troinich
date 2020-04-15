package LoginTest;

import ParentTests.AbstractParentTest;
import org.junit.Test;

public class AddNewWorkerInWorkersPage extends AbstractParentTest {
    @Test
    public void validAddWorker() {
        loginPage.openPageLogin();
        loginPage.loginToPage("Student", "909090");
        workersPage.openPage();
        workersPage.addNewWorker("Toster", "Ivan", "OKay","044555");
        checkExpectedResult("Add worker succesfull", false);
    }
}
