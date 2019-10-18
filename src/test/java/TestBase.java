import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.LocalDate;

public class TestBase {
    private static String testName = "DEFAULT";
    public static AppiumDriver driver;
    private static final String userDir = System.getProperty("user.dir");
    private static final String testExtentReportsDir = TestConstants.Constants.getTestExtentReportsDir(userDir);
    protected static final String testVideoRecordingsDir = TestConstants.Constants.getTestVideoRecordingsDir(userDir);
    private static String AVD_NAME = System.getProperty("AVD_NAME");
    private static String IPHONE_NAME = System.getProperty("IPHONE_NAME");
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void initReport() throws IOException {
        File reportDir = new File(testExtentReportsDir);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        } else if (!reportDir.isDirectory()) {
            throw new IOException("\"" + testExtentReportsDir + "\" is not a directory.");
        }

        htmlReporter = new ExtentHtmlReporter(new File(testExtentReportsDir, "IbottaAutomatedTestReport.html")
        );
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Ibotta App Automated Tests Report");
        htmlReporter.config().setReportName("Ibotta Android: Automated Test Report");
    }

    @BeforeClass
    public static void setup(Method method) throws MalformedURLException {
        //TODO: think of better way setting smartphone emulator name and getting relevant driver
        if (AVD_NAME == null || AVD_NAME.isEmpty()) {
            AVD_NAME = "Pixel_2_API_29";
        }
        if (IPHONE_NAME == null || IPHONE_NAME.isEmpty()) {
            IPHONE_NAME = "iPhone 11 Pro Max";
        }

        if(method.getName().contains("IOS")) {
            driver = DriverFactory.getDriver(PlatformType.iOS, AVD_NAME);
        } else {
            driver = DriverFactory.getDriver(PlatformType.Android, AVD_NAME);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(Method method) throws IOException, IllegalAccessException, AWTException {
        testName = method.getName();

        TestUtils.startRecording(testVideoRecordingsDir, testName);

        System.out.println(String.format("Starting test: %s", testName));
    }

    @AfterMethod
    public void afterTest(Method method, ITestResult result) throws IOException {
        TestUtils.stopRecording();
        try{
            if (result.getStatus() == ITestResult.FAILURE)
            {
                File file = driver.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File(String.format("%s%s%s_%s.png", testVideoRecordingsDir, File.separator, result.getName(), LocalDate.now())));
                logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
                logger.fail(result.getThrowable());
            }
            else if (result.getStatus() == ITestResult.SUCCESS)
            {
                logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
            }
            else if (result.getStatus() == ITestResult.SKIP)
            {
                logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
            }
        } catch(NullPointerException e){
            System.out.println("You should call 'extent.createTest()' in the begging of a test to save report.");
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void afterSuite(){
        extent.flush();
        try {
            if(driver != null){
                driver.quit();
            }
        } catch (org.openqa.selenium.NoSuchSessionException e){
            e.printStackTrace();
        }
    }
}
