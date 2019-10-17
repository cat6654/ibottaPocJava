import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import utils.TestConstants;

public class AndroidSampleTests extends TestBase {

    /**
     * ID: 1 User can launch android app
     */
    @Test(enabled = false)
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

    /**
     * ID: 2 User can login
     */
    @Test
    public void userCanLoginTest(){
        logger = extent.createTest("ID: 2 User can login");
        logger.assignCategory("Sample");
        logger.assignAuthor("Alex Kostuchenko");

        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(TestConstants.Users.getUserOne(), TestConstants.Users.getUserOnePassword());
        logger.log(Status.PASS, "Enter credentials and click login button");

        Assert.assertFalse(landingPage.isLoginButtonVisible(), "Login button should not be visible after successful login");
        logger.log(Status.PASS, "Verify if logged in");
    }
}
