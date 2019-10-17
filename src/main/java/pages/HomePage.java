package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BasePage {
    @AndroidFindBy(id="nbv_featured")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement homeButton;

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
}
