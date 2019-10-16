import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidSampleTests extends TestBase {

    /**
     * ID: 1 User can launch android app
     */
    @Test
    public void userCanLaunchAndroidAppTest(){
        logger = extent.createTest("ID: 1 User can launch android app");
        logger.assignCategory("Sample");
        logger.assignAuthor("Alex Kostuchenko");

        Assert.assertFalse(
                driver.getStatus().isEmpty(),
                String.format("Driver's status should not be empty. See failed test recordings at: %s", testVideoRecordingsDir)
        );
        logger.log(Status.PASS, "Reset app");
    }
}
