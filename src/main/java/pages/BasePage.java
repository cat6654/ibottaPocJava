package pages;

import com.google.common.base.Stopwatch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by akosatuchenko on 8/11/2017.
 */
public abstract class BasePage {
    public AppiumDriver driver;
    protected WebDriverWait wait;
    protected static int GLOBAL_WAIT_MODIFIER = 60;
    protected Stopwatch stopwatch = Stopwatch.createUnstarted();

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        //global wait
        wait = new WebDriverWait(driver, GLOBAL_WAIT_MODIFIER);
    }

    public void loadPage(String pageName) {
        System.out.println(String.format("Loading: %s", pageName));
        stopwatch.start();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(GLOBAL_WAIT_MODIFIER)), this);
        stopwatch.stop();
        System.out.println(String.format("Time elapsed for loading %s is %s ms", pageName, stopwatch.elapsed(TimeUnit.MILLISECONDS)));
        stopwatch.reset();
    }
}

