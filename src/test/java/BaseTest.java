import Common.ReportManager;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Common.ExcelDataReader;
import PageObjects.SettingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.*;

public class BaseTest extends TestNG {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    SettingPage settingPage;
    ReportManager reportManager;

    @DataProvider(name = "userData")
    public Object[][] getUserData() throws Exception {
        // Return data from your ExcelDataReader
        String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\UsersData.xlsx";
        return ExcelDataReader.getDataFromExcel("USERS", excelFilePath);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
        // Return data from your ExcelDataReader
        String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\LoginData.xlsx";
        return ExcelDataReader.getDataFromExcel("LOGIN", excelFilePath);
    }

    @DataProvider(name = "incorrectEmailData")
    public Object[][] getIncorrectEmailData() throws Exception {
        // Return data from your ExcelDataReader
        String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\LoginData.xlsx";
        return ExcelDataReader.getDataFromExcel("LOGIN", excelFilePath);
    }

    @DataProvider(name = "incorrectPasswordData")
    public Object[][] getIncorrectPasswordData() throws Exception {
        // Return data from your ExcelDataReader
        String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\LoginData.xlsx";
        return ExcelDataReader.getDataFromExcel("LOGIN", excelFilePath);
    }

    @BeforeClass
    public void setUp() {
        // Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        settingPage = new SettingPage(driver);
        reportManager = new ReportManager();
        reportManager.initialize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        reportManager.flush();
    }
}
