package Common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager {

    private ExtentReports extentReports;
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void initialize() {
        // Initialize ExtentSparkReporter
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "extentReport_" + timestamp + ".html";
        String ReportFilePath = System.getProperty("user.dir") +  "\\src\\main\\resources\\Reports\\"+reportName;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(ReportFilePath);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }


    public ExtentTest createTest(String testName) {
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
        return test;
    }


    public void flush() {
        extentReports.flush();
    }
}
