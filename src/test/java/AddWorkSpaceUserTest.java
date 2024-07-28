
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddWorkSpaceUserTest extends BaseTest {

    ExtentTest test;
    public void loginTest(String username, String password) {
        driver.get("https://app.respond.io/user/login");
        test = reportManager.createTest("Verify Sign up flow");
        loginPage.enterEmail().sendKeys(username);
        loginPage.enterPassword().sendKeys(password);
        loginPage.clickSignButton().click();
        test.pass("Sign up test passed.");
    }

    @Test(dataProvider = "loginData", priority = 1, groups = "login")
    public void VerifyLogin(String username, String password) {
        loginTest(username, password);
    }


    @Test(dataProvider = "userData")
    public void VerifyAddWorkSpaceUser(String Email) {
        test = reportManager.createTest("Verify Add Workspace User");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.SettingBtn));
        homePage.clickSettingBtn().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(settingPage.UsersBtn));
        settingPage.clickUsersBtn().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingPage.AddUserBtn));
        settingPage.clickAddUserBtn().click();
        settingPage.enterEmail().sendKeys(Email);
        settingPage.clickAdvancedRestriction().click();
        settingPage.clickRestrictDataExport().click();
        settingPage.clickRestrictContactDeletion().click();
        settingPage.clickAddBtn().click();

    }

    @Test(dataProvider = "userData", dependsOnMethods = "VerifyLogin", priority = 2)
    public void VerifyNewAddedUser(String Email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        VerifyAddWorkSpaceUser(Email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingPage.UserAddedMessage));
        String Message = settingPage.userAddedMessagePopup().getText();
        Assert.assertEquals(Message, "User has been invited to workspace");
        test.pass("User invitation test passed.");
    }


    @Test(dataProvider = "userData", dependsOnMethods = "VerifyLogin", priority = 2)
    public void VerifyWorkSpaceAlreadyAddedUser(String Email) {
        // Check for the 'Invitation has already been sent' message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        VerifyAddWorkSpaceUser(Email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingPage.invitationAlreadySentMessage));
        String message1 = settingPage.invitationAlreadySentMessagePopup().getText();
        Assert.assertEquals(message1, "Invitation has already been sent and is not accepted.");
        test.pass("Invitation already sent test passed.");
    }


}
