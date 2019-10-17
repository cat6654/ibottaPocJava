package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{
    @AndroidFindBy(id="nbv_find_rebates")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement searchItem;

    public MainPage(AppiumDriver driver) {
        super(driver);
        try {
            loadPage(getClass().getName());
            wait.until(ExpectedConditions.visibilityOf(searchItem));
        } catch (org.openqa.selenium.NoSuchElementException | NullPointerException | org.openqa.selenium.TimeoutException e) {
            driver.resetApp();
        }
    }

    public RebatesSearchPage clickSearchItem(){
        wait.until(ExpectedConditions.visibilityOf(searchItem));
        searchItem.click();
        return new RebatesSearchPage(driver);
    }

}
