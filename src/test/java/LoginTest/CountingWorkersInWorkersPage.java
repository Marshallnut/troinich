package LoginTest;

import ParentTests.AbstractParentTest;
import org.junit.Test;

public class CountingWorkersInWorkersPage extends AbstractParentTest  {
    @Test
    public void validAddWorker() {
        loginPage.openPageLogin();
        loginPage.loginToPage("Student", "909090");
        workersPage.openPage();

        int count = workersPage.workersAmount();
        System.out.println("Workers amount are "+count);
    }
}
