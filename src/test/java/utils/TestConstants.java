package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestConstants {
    private static Properties prop = PropertiesManagement.getInstance().loadProps("test.properties");

    public static final class Users {
        private static final String USER_ONE = prop.getProperty("mobile_patient_one");
        private static final String USER_ONE_PASSWORD = prop.getProperty("mobile_patient_one_password");
        private static final String DEFAULT_PASSWORD = prop.getProperty("default_password");

        public static String getUserOne() {
            return USER_ONE;
        }

        public static String getUserOnePassword() {
            return USER_ONE_PASSWORD;
        }

        public static String getDefaultPassword() {
            return DEFAULT_PASSWORD;
        }
    }

    public static final class Constants {
        private static final String APP_PACKAGE = prop.getProperty("app_package");
        private static final String APP_ACTIVITY = prop.getProperty("app_activity");
        private static final String LOCAL_ANDROID_APP_KEYWORD = prop.getProperty("local_android_app_keyword");
        private static final String DEVICE_NAME = prop.getProperty("device_name");
        private static final String ANDROID_PLATFORM_NAME = prop.getProperty("android_platform_name");
        private static final String IOS_PLATFORM_NAME = prop.getProperty("ios_platform_name");
        private static final String ANDROID_AUTOMATION_NAME = prop.getProperty("android_automation_name");
        private static final String IOS_AUTOMATION_NAME = prop.getProperty("ios_automation_name");
        private static final String SESSION_START_TIMEOUT = prop.getProperty("session_start_timeout");

        public static String getAppPackage() {
            return APP_PACKAGE;
        }

        public static String getAppActivity() {
            return APP_ACTIVITY;
        }


        public static String getLocalAndroidAppKeyword() {
            return LOCAL_ANDROID_APP_KEYWORD;
        }

        public static String getDeviceName() {
            return DEVICE_NAME;
        }

        public static String getAndroidPlatformName() {
            return ANDROID_PLATFORM_NAME;
        }

        public static String getIosPlatformName() {
            return IOS_PLATFORM_NAME;
        }

        public static String getAndroidAutomationName() {
            return ANDROID_AUTOMATION_NAME;
        }

        public static String getIosAutomationName() {
            return IOS_AUTOMATION_NAME;
        }

        public static String getSessionStartTimeout() {
            return SESSION_START_TIMEOUT;
        }

        public static String getLocalAppBasePath(){
            return String.format("%sapp%sbuild%soutputs%sapk%s", File.separator, File.separator, File.separator, File.separator, File.separator);
        }

        public static String getTestVideoRecordingsDir(String userDir){
            return String.format("%s%stest_videos%s%s%s", userDir, File.separator, File.separator, new SimpleDateFormat("MM-dd-yyyy").format(new Date()), File.separator);
        }

        public static String getTestExtentReportsDir(String userDir){
            return String.format("%s%sextent_reports%s", userDir, File.separator, File.separator);
        }
    }
}
