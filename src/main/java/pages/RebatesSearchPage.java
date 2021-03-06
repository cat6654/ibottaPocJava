package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RebatesSearchPage extends BasePage {
    @AndroidFindBy(id="etSearchText")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement searchField;

    @AndroidFindBy(id="etSearchText")
    @iOSXCUITFindBy(accessibility = "")
    List<MobileElement> searchResults;

    public RebatesSearchPage(AppiumDriver driver) {
        super(driver);
        try {
            loadPage(getClass().getName());
            wait.until(ExpectedConditions.visibilityOf(searchField));
        } catch (org.openqa.selenium.NoSuchElementException | NullPointerException | org.openqa.selenium.TimeoutException e) {
            driver.resetApp();
        }
    }

    public void searchForTheItem(String item){
        searchField.sendKeys(item+"\n");
    }

    public boolean isItemsContainText(String text){
        //TODO add ability to compare results text
        return false;
    }
}
