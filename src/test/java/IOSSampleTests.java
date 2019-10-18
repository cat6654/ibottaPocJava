import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

public class IOSSampleTests extends TestBase {
    /**
     * ID: 1 Get list of booted ios devices
     */
    @Test
    public void getListOfBootedIOSDevices(){
        logger = extent.createTest("ID: 1 Get list of booted ios devices");
        logger.assignCategory("Sample");
        logger.assignAuthor("Alex Kostuchenko");

        Assert.assertNotEquals(
                TestUtils.getBootedIphoneSimulatorsUDID().size(), 0,
                "List of booted devices should not be empty"
        );
        logger.log(Status.PASS, "Get list of booted devices");
    }
}
