package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage{
    @AndroidFindBy(id="tv_login")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement loginLink;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.ibotta.android:id/tifEmail']//android.widget.EditText[@resource-id='com.ibotta.android:id/etField']")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement emailInput;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.ibotta.android:id/tifPassword']//android.widget.EditText[@resource-id='com.ibotta.android:id/etField']")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement passwordInput;

    @AndroidFindBy(id="bLogin")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement loginButton;

    public LandingPage(AppiumDriver driver) {
        super(driver);
        try {
            loadPage(getClass().getName());
            wait.until(ExpectedConditions.visibilityOf(loginLink));
        } catch (org.openqa.selenium.NoSuchElementException | NullPointerException | org.openqa.selenium.TimeoutException e) {
            driver.resetApp();
        }
    }

    public HomePage login(String username, String password){
        loginLink.click();
        emailInput.clear();
        emailInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.setValue(password);

        loginButton.click();
        return new HomePage(driver);
    }

    public boolean isLoginButtonVisible() {
        try {
            loadPage(getClass().getName());
            return loginButton.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
