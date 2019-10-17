package utils;

import lombok.Getter;

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
        @Getter
        private static final String appPackage = prop.getProperty("app_package");

        @Getter
        private static final String appActivity = prop.getProperty("app_activity");

        @Getter
        private static final String localAndroidAppKeyword = prop.getProperty("local_android_app_keyword");

        @Getter
        private static final String deviceName = prop.getProperty("device_name");

        @Getter
        private static final String androidPlatformName = prop.getProperty("android_platform_name");

        @Getter
        private static final String iosPlatformName = prop.getProperty("ios_platform_name");

        @Getter
        private static final String androidAutomationName = prop.getProperty("android_automation_name");

        @Getter
        private static final String iosAutomationName = prop.getProperty("ios_automation_name");

        @Getter
        private static final String sessionStartTimeout = prop.getProperty("session_start_timeout");

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
