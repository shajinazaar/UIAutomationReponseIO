import Common.ExcelDataReader;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFlowTest extends BaseTest{

    ExtentTest test;

    private void performLogin(String username, String password, String testName, String successMessage) {
        driver.get("https://app.respond.io/user/login");
        test = reportManager.createTest(testName);
        loginPage.enterEmail().sendKeys(username);
        loginPage.enterPassword().sendKeys(password);
        loginPage.clickSignButton().click();
        test.pass(successMessage);
    }


    @Test(dataProvider = "loginData", priority = 1, groups = "login")
    public void successfulLoginTest(String username, String password) {
        performLogin(username, password, "Verify Sign up flow", "Sign up test passed.");
    }

    @Test(dataProvider = "incorrectEmailData", priority = 2, groups = "login")
    public void verifyLoginIncorrectEmailTest(String username, String password) {
        performLogin(username, password, "Verify Sign up flow with wrong email address", "Sign up failed with incorrect email address.");
    }

    @Test(dataProvider = "incorrectPasswordData", priority = 3, groups = "login")
    public void verifyLoginIncorrectPasswordTest(String username, String password) {
        performLogin(username, password, "Verify Sign up flow with correct email address and wrong password", "Sign up failed with incorrect password.");
    }
}
