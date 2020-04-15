package LoginTest;

import ParentTests.AbstractParentTest;
import org.junit.Test;

public class SignOutFromWorkersPage extends AbstractParentTest {
    @Test
    public void validAddWorker() {
        loginPage.openPageLogin();
        loginPage.loginToPage("Student", "909090");
        workersPage.openPage();
        workersPage.clickStudentButton();
        workersPage.clickExitButton();
        checkExpectedResult("Sign out succesfull", false);
    }
}
