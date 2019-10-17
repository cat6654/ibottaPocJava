package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @AndroidFindBy(id="nbv_featured")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement homeButton;

    @AndroidFindBy(id="nbv_find_rebates")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement searchItem;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isHomeButtonVisible() {
        try {
            loadPage(getClass().getName());
            return homeButton.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public RebatesSearchPage clickSearchItem(){
        wait.until(ExpectedConditions.visibilityOf(searchItem));
        searchItem.click();
        return new RebatesSearchPage(driver);
    }
}
