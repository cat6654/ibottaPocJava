package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class DriverFactory {
    public static AppiumDriver getDriver(PlatformType platformType, String avdName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        AppiumDriver driver = null;
        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");

        switch(platformType){
            case iOS: {
                capabilities.setCapability(MobileCapabilityType.APP, "");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, TestConstants.Constants.getIosAutomationName());
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, TestConstants.Constants.getIosDeviceName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TestConstants.Constants.getIosPlatformName());
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, TestConstants.Constants.getBrowserName());
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, TestConstants.Constants.getSessionStartTimeout());

                driver = new IOSDriver(serverAddress, capabilities);
                break;
            }
            case Android: {
                String apkPath = TestUtils.getApkPath();
                if (!apkPath.isEmpty()) {
                    capabilities.setCapability(MobileCapabilityType.APP, apkPath);
                } else {
                    System.out.println(String.format("Didn't find any *.apk at %s... Trying to launch existing application.", TestConstants.Constants.getLocalAppBasePath()));
                    capabilities.setCapability("appActivity", TestConstants.Constants.getAppActivity());
                    capabilities.setCapability("appPackage", TestConstants.Constants.getAppPackage());
                }

                List<String> devices = TestUtils.getConnectedDevicesUDID();
                if (devices.iterator().hasNext()) {
                    capabilities.setCapability(MobileCapabilityType.UDID, devices.iterator().next());
                } else {
                    System.out.println(String.format("Didn't find any launched ABDs or connected devices. Trying to launch emulator with name: %s", avdName));
                    capabilities.setCapability("avd", avdName);
                }
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, TestConstants.Constants.getAndroidDeviceName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TestConstants.Constants.getAndroidPlatformName());
                capabilities.setCapability("autoGrantPermissions", true);
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, TestConstants.Constants.getSessionStartTimeout());
                capabilities.setCapability("autoDismissAlerts", true);


                driver = new AndroidDriver(serverAddress, capabilities);
                break;
            }
        }

        return driver;
    }
}
